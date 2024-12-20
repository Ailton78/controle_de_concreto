package com.parasistema.controle_de_concreto.dto.cliente_dto;

import com.parasistema.controle_de_concreto.entities.Cliente;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpf_cnpj;
    private String phone;
    private String email;

    public ClienteDTO(){}

    public ClienteDTO(Long id, String nome, String cpf_cnpj, String phone, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf_cnpj = cpf_cnpj;
        this.phone = phone;
        this.email = email;
    }


    public ClienteDTO(Cliente entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.cpf_cnpj = entity.getCpf_cnpj();
        this.phone = entity.getPhone();
        this.email = entity.getEmail();
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

}
