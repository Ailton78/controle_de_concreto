package com.parasistema.controle_de_concreto.dto.cliente_dto;

import com.parasistema.controle_de_concreto.entities.Cliente;

public class ClienteEnderecoDTO {

    private Long id;
    private String nome;
    private String cpf_cnpj;
    private String phone;
    private String email;
    private Long idEndereco;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public ClienteEnderecoDTO(){}

    public ClienteEnderecoDTO(Long id, String nome, String cpf_cnpj, String phone, String email,
                              Long idEndereco, String logradouro, String numero, String bairro,
                              String cidade, String estado, String cep) {
        this.id = id;
        this.nome = nome;
        this.cpf_cnpj = cpf_cnpj;
        this.phone = phone;
        this.email = email;
        this.idEndereco = idEndereco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public ClienteEnderecoDTO(Cliente entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.cpf_cnpj = entity.getCpf_cnpj();
        this.phone = entity.getPhone();
        this.email = entity.getEmail();
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

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
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
