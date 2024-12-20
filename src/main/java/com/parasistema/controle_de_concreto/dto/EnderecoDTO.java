package com.parasistema.controle_de_concreto.dto;

import com.parasistema.controle_de_concreto.entities.Endereco;

public class EnderecoDTO {

    private Long id;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public EnderecoDTO(){}

    public EnderecoDTO(Long id, String logradouro, String numero, String bairro,
                       String cidade, String estado, String cep) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
    public EnderecoDTO(Endereco entity) {
        this.id = entity.getId();
        this.logradouro = entity.getLogradouro();
        this.numero = entity.getNumero();
        this.bairro = entity.getBairro();
        this.cidade = entity.getCidade();
        this.estado = entity.getEstado();
        this.cep = entity.getCep();
    }

    public Long getId() {
        return id;
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
