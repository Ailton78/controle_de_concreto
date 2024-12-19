package com.parasistema.controle_de_concreto.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_tecnico")
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cargo;

    @OneToMany(mappedBy = "reposavel")
    private List<CorpoDeProva> corpoDeProvaList = new ArrayList<>();

    @OneToMany(mappedBy = "reposavel")
    private List<Servico> servicos = new ArrayList<>();

    public Tecnico(){}

    public Tecnico(Long id, String nome, String cargo,
                   List<CorpoDeProva> corpoDeProvaList, List<Servico> servicos) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.corpoDeProvaList = corpoDeProvaList;
        this.servicos = servicos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<CorpoDeProva> getCorpoDeProvaList() {
        return corpoDeProvaList;
    }

    public void addCorpoDeProva(CorpoDeProva entity) {
        corpoDeProvaList.add(entity);
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void addServico(Servico entity) {
        servicos.add(entity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tecnico tecnico = (Tecnico) o;
        return Objects.equals(id, tecnico.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
