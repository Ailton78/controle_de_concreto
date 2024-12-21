package com.parasistema.controle_de_concreto.repositories;


import com.parasistema.controle_de_concreto.dto.fornecedor_dto.FornecedorDTO;
import com.parasistema.controle_de_concreto.dto.fornecedor_dto.FornecedorEnderecoDTO;
import com.parasistema.controle_de_concreto.entities.Fornecedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    @Query("SELECT new  com.parasistema.controle_de_concreto.dto.fornecedor_dto.FornecedorDTO( obj.id, obj.nome, obj.cpf_cnpj, " +
            "obj.phone, obj.email) FROM Fornecedor obj")
    Page<FornecedorDTO> findAllFornecedor(Pageable pageable);

    @Query("SELECT new com.parasistema.controle_de_concreto.dto.fornecedor_dto.FornecedorEnderecoDTO( " +
            "obj.id, obj.nome, obj.cpf_cnpj, obj.phone, obj.email, obj.endereco.id, obj.endereco.logradouro, " +
            "obj.endereco.numero, obj.endereco.bairro, obj.endereco.cidade, obj.endereco.estado, obj.endereco.cep) " +
            "FROM Fornecedor  obj ")
    Page<FornecedorEnderecoDTO> findAllFornecedorEndereco(Pageable pageable);

    @Query("SELECT new com.parasistema.controle_de_concreto.dto.fornecedor_dto.FornecedorEnderecoDTO(" +
            "obj.id, obj.nome, obj.cpf_cnpj, obj.phone, obj.email, obj.endereco.id, obj.endereco.logradouro, " +
            "obj.endereco.numero, obj.endereco.bairro, obj.endereco.cidade, obj.endereco.estado, obj.endereco.cep) " +
            "FROM Fornecedor obj WHERE obj.id = :id")
    FornecedorEnderecoDTO findByIdFornecedorEndereco(@Param("id") Long id);


}
