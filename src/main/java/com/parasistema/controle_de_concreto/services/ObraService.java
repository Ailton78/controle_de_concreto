package com.parasistema.controle_de_concreto.services;

import com.parasistema.controle_de_concreto.dto.obra_dto.ObraDTO;
import com.parasistema.controle_de_concreto.dto.obra_dto.ObraEnderecoDTO;
import com.parasistema.controle_de_concreto.entities.Endereco;
import com.parasistema.controle_de_concreto.entities.Obra;
import com.parasistema.controle_de_concreto.repositories.EnderecoRepository;
import com.parasistema.controle_de_concreto.repositories.ObraRepository;
import com.parasistema.controle_de_concreto.services.exceptions.DatabaseException;
import com.parasistema.controle_de_concreto.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ObraService {

    @Autowired
    private ObraRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional(readOnly = true)
    public ObraEnderecoDTO findByIdFornecedorEndereco(Long id){
        ObraEnderecoDTO obra = repository.findByIdFornecedorEndereco(id);
        return obra;
    }

    @Transactional(readOnly = true)
    public Page<ObraEnderecoDTO>findAllFornecedorEndereco(Pageable pageable){
        Page<ObraEnderecoDTO> result= repository.findAllObraEndereco(pageable);
        return result;
    }


    @Transactional
    public ObraEnderecoDTO  insertObraEndereco(ObraEnderecoDTO  dto){
        Obra entity = new Obra();
        copyDtoToEntityEndereco(dto, entity);
        entity = repository.save(entity);
        return new ObraEnderecoDTO(entity);
    }

    @Transactional
    public ObraEnderecoDTO update(Long id, ObraEnderecoDTO dto){
        try {

            repository.updateObra(id, dto.getNome());
            ObraEnderecoDTO endDto = repository.findByIdFornecedorEndereco(id);
            enderecoRepository.updateEndereco(endDto.getIdEndereco(), dto.getLogradouro(), dto.getNumero(),
                    dto.getBairro(), dto.getCidade(),
                    dto.getEstado(), dto.getCep());
            dto = repository.findByIdFornecedorEndereco(id);
            return dto;

        }catch (EntityNotFoundException e){
            throw  new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!repository.existsById(id)){
            throw  new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Falha de integridade referencial");
        }

    }

    private void copyDtoToEntityEndereco(ObraEnderecoDTO dto, Obra entity) {
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());

        Endereco endereco = new Endereco();
        endereco.setLogradouro(dto.getLogradouro());
        endereco.setNumero(dto.getNumero());
        endereco.setBairro(dto.getBairro());
        endereco.setCidade(dto.getCidade());
        endereco.setEstado(dto.getEstado());
        endereco.setCep(dto.getCep());

        entity.setEndereco(endereco);
    }

}
