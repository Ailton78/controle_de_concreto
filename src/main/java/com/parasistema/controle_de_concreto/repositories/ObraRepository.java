package com.parasistema.controle_de_concreto.repositories;


import com.parasistema.controle_de_concreto.dto.obra_dto.ObraDTO;
import com.parasistema.controle_de_concreto.dto.obra_dto.ObraEnderecoDTO;
import com.parasistema.controle_de_concreto.entities.Obra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ObraRepository extends JpaRepository<Obra, Long> {

    @Query("SELECT new com.parasistema.controle_de_concreto.dto.obra_dto.ObraEnderecoDTO( " +
            "obj.id, obj.nome, obj.endereco.id, obj.endereco.logradouro, " +
            "obj.endereco.numero, obj.endereco.bairro, obj.endereco.cidade, obj.endereco.estado, obj.endereco.cep) " +
            "FROM Obra  obj ")
    Page<ObraEnderecoDTO>findAllObraEndereco(Pageable pageable);

    @Query("SELECT new com.parasistema.controle_de_concreto.dto.obra_dto.ObraEnderecoDTO(" +
            "obj.id, obj.nome, obj.endereco.id, obj.endereco.logradouro, " +
            "obj.endereco.numero, obj.endereco.bairro, obj.endereco.cidade, obj.endereco.estado, obj.endereco.cep) " +
            "FROM Obra obj WHERE obj.id = :id")
    ObraEnderecoDTO findByIdFornecedorEndereco(@Param("id") Long id);

    @Query("SELECT new com.parasistema.controle_de_concreto.dto.obra_dto.ObraDTO( " +
            "obj.id, obj.nome) FROM Obra obj WHERE obj.id = :id ")
    ObraDTO findObraById(@Param("id") Long id);

    @Modifying
    @Query("UPDATE Obra obj SET obj.nome = :nome WHERE obj.id = :id")
    void updateObra(@Param("id") Long id, @Param("nome") String nome);







}
