package com.parasistema.controle_de_concreto.repositories;

import com.parasistema.controle_de_concreto.dto.cliente_dto.ClienteDTO;
import com.parasistema.controle_de_concreto.dto.cliente_dto.ClienteEnderecoDTO;
import com.parasistema.controle_de_concreto.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT new  com.parasistema.controle_de_concreto.dto.cliente_dto.ClienteDTO( obj.id, obj.nome, obj.cpf_cnpj, " +
            "obj.phone, obj.email) FROM Cliente obj")
    Page<ClienteDTO> findAllCliente(Pageable pageable);

    @Query("SELECT new com.parasistema.controle_de_concreto.dto.cliente_dto.ClienteEnderecoDTO(" +
            "obj.id, obj.nome, obj.cpf_cnpj, obj.phone, obj.email, obj.endereco.id, obj.endereco.logradouro, " +
            "obj.endereco.numero, obj.endereco.bairro, obj.endereco.cidade, obj.endereco.estado, obj.endereco.cep) " +
            "FROM Cliente obj ")
    Page<ClienteEnderecoDTO> findAllClienteEndereco(Pageable pageable);

    @Query("SELECT new com.parasistema.controle_de_concreto.dto.cliente_dto.ClienteEnderecoDTO(" +
            "obj.id, obj.nome, obj.cpf_cnpj, obj.phone, obj.email, obj.endereco.id, obj.endereco.logradouro, " +
            "obj.endereco.numero, obj.endereco.bairro, obj.endereco.cidade, obj.endereco.estado, obj.endereco.cep) " +
            "FROM Cliente obj WHERE obj.id = :id")
    ClienteEnderecoDTO findByIdClienteEndereco(@Param("id") Long id);


}
