package com.parasistema.controle_de_concreto.services;

import com.parasistema.controle_de_concreto.dto.cliente_dto.ClienteDTO;
import com.parasistema.controle_de_concreto.dto.cliente_dto.ClienteEnderecoDTO;
import com.parasistema.controle_de_concreto.entities.Cliente;
import com.parasistema.controle_de_concreto.entities.Endereco;
import com.parasistema.controle_de_concreto.repositories.ClienteRepository;
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
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional(readOnly = true)
    public ClienteDTO findById(Long id){
        Cliente cliente = repository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Recurso não encontrado"));
        return new ClienteDTO(cliente);
    }

    @Transactional(readOnly = true)
    public ClienteEnderecoDTO findByIdClienteEndereco(Long id){
        ClienteEnderecoDTO cliente = repository.findByIdClienteEndereco(id);
        return cliente;
    }

  @Transactional(readOnly = true)
    public Page<ClienteDTO> findAll(Pageable pageable){
        Page<ClienteDTO> result= repository.findAllCliente(pageable);
        return result;
    }
    @Transactional(readOnly = true)
    public Page<ClienteEnderecoDTO>findAllClienteEndereco(Pageable pageable){
        Page<ClienteEnderecoDTO> result= repository.findAllClienteEndereco(pageable);
        return result;
    }

    @Transactional
    public ClienteDTO insert(ClienteDTO dto){
        Cliente entity = new Cliente();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ClienteDTO(entity);
    }
    @Transactional
    public ClienteEnderecoDTO insertClienteEndereco(ClienteEnderecoDTO dto){
        Cliente entity = new Cliente();
        copyDtoToEntityEndereco(dto, entity);
        entity = repository.save(entity);
        return new ClienteEnderecoDTO(entity);
    }

    @Transactional
    public ClienteDTO update(Long id, ClienteDTO dto){
        try {
            Cliente entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ClienteDTO(entity);
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

    private void copyDtoToEntity(ClienteDTO dto, Cliente entity) {
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setCpf_cnpj(dto.getCpf_cnpj());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
    }
    private void copyDtoToEntityEndereco(ClienteEnderecoDTO dto, Cliente entity) {
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
