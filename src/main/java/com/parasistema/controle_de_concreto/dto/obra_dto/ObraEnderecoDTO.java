package com.parasistema.controle_de_concreto.dto.obra_dto;

import com.parasistema.controle_de_concreto.entities.Obra;

public class ObraEnderecoDTO {

    private Long id;
    private String nome;
    private Long idEndereco;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public ObraEnderecoDTO(){}

    public ObraEnderecoDTO(Long id, String nome, Long idEndereco, String logradouro,
                           String numero, String bairro, String cidade, String estado, String cep) {
        this.id = id;
        this.nome = nome;
        this.idEndereco = idEndereco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public ObraEnderecoDTO(Obra entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.idEndereco = entity.getEndereco().getId();
        this.logradouro = entity.getEndereco().getLogradouro();
        this.numero = entity.getEndereco().getNumero();
        this.bairro = entity.getEndereco().getBairro();
        this.cidade = entity.getEndereco().getCidade();
        this.estado = entity.getEndereco().getEstado();
        this.cep = entity.getEndereco().getCep();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }
}
