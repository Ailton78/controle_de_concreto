package com.parasistema.controle_de_concreto.repositories;

import com.parasistema.controle_de_concreto.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Modifying
    @Query("UPDATE Endereco obj SET obj.logradouro = :logradouro, " +
            "obj.numero = :numero, obj.bairro = :bairro, obj.cidade = :cidade, " +
            "obj.estado = :estado, obj.cep = :cep " +
            "WHERE obj.id = :id")
    void updateEndereco(@Param("id") Long id,
                        @Param("logradouro") String logradouro,
                        @Param("numero") String numero,
                        @Param("bairro") String bairro,
                        @Param("cidade") String cidade,
                        @Param("estado") String estado,
                        @Param("cep") String cep);
}
