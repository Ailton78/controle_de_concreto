package com.parasistema.controle_de_concreto.services;

import com.parasistema.controle_de_concreto.dto.fornecedor_dto.FornecedorDTO;
import com.parasistema.controle_de_concreto.dto.fornecedor_dto.FornecedorEnderecoDTO;
import com.parasistema.controle_de_concreto.entities.Endereco;
import com.parasistema.controle_de_concreto.entities.Fornecedor;
import com.parasistema.controle_de_concreto.repositories.FornecedorRepository;
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
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    @Transactional(readOnly = true)
    public FornecedorDTO findById(Long id){
        Fornecedor fornecedor = repository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Recurso não encontrado"));
        return new FornecedorDTO(fornecedor);
    }

    @Transactional(readOnly = true)
    public FornecedorEnderecoDTO findByIdFornecedorEndereco(Long id){
        FornecedorEnderecoDTO fornecedor = repository.findByIdFornecedorEndereco(id);
        return fornecedor;
    }

  @Transactional(readOnly = true)
    public Page< FornecedorDTO> findAll(Pageable pageable){
        Page<FornecedorDTO> result= repository.findAllFornecedor(pageable);
        return result;
    }
    @Transactional(readOnly = true)
    public Page<FornecedorEnderecoDTO>findAllFornecedorEndereco(Pageable pageable){
        Page<FornecedorEnderecoDTO> result= repository.findAllFornecedorEndereco(pageable);
        return result;
    }

    @Transactional
    public FornecedorDTO insert(FornecedorDTO dto){
        Fornecedor entity = new Fornecedor();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new FornecedorDTO(entity);
    }
    @Transactional
    public FornecedorEnderecoDTO insertClienteEndereco(FornecedorEnderecoDTO dto){
        Fornecedor entity = new Fornecedor();
        copyDtoToEntityEndereco(dto, entity);
        entity = repository.save(entity);
        return new FornecedorEnderecoDTO(entity);
    }

    @Transactional
    public FornecedorDTO update(Long id, FornecedorDTO dto){
        try {
            Fornecedor entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new FornecedorDTO(entity);
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

    private void copyDtoToEntity(FornecedorDTO dto, Fornecedor entity) {
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setCpf_cnpj(dto.getCpf_cnpj());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
    }
    private void copyDtoToEntityEndereco(FornecedorEnderecoDTO dto, Fornecedor entity) {
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setCpf_cnpj(dto.getCpf_cnpj());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());

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
