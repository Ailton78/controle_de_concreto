package com.parasistema.controle_de_concreto.services;

import com.parasistema.controle_de_concreto.dto.EnderecoDTO;
import com.parasistema.controle_de_concreto.entities.Endereco;
import com.parasistema.controle_de_concreto.repositories.EnderecoRepository;
import com.parasistema.controle_de_concreto.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    @Transactional
    public EnderecoDTO insert(EnderecoDTO dto){
        Endereco entity = new Endereco();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new EnderecoDTO(entity);
    }

    @Transactional
    public EnderecoDTO update(Long id, EnderecoDTO dto){
        try {
            Endereco entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new EnderecoDTO(entity);
        }catch (EntityNotFoundException e){
            throw  new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    private void copyDtoToEntity(EnderecoDTO dto, Endereco entity) {
        entity.setId(dto.getId());
        entity.setLogradouro(dto.getLogradouro());
        entity.setNumero(dto.getNumero());
        entity.setBairro(dto.getBairro());
        entity.setCidade(dto.getCidade());
        entity.setEstado(dto.getEstado());
        entity.setCep(dto.getCep());
    }

}
