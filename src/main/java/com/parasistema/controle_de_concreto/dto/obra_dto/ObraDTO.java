package com.parasistema.controle_de_concreto.dto.obra_dto;

import com.parasistema.controle_de_concreto.entities.Obra;

public class ObraDTO {
    private Long id;
    private String nome;

    public ObraDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public ObraDTO(Obra entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
