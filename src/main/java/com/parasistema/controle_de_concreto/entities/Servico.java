package com.parasistema.controle_de_concreto.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataInicio;
    private LocalDate dataFinal;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico reposavel;

    @ManyToOne
    @JoinColumn(name = "obra_id")
    private Obra obra;


    @OneToMany(mappedBy = "servico")
    private List<Ensaio> ensaios = new ArrayList<>();

    public Servico(){}

    public Servico(Long id, LocalDate dataInicio, LocalDate dataFinal,
                   Tecnico reposavel, Obra obra, List<Ensaio> ensaios) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.reposavel = reposavel;
        this.obra = obra;
        this.ensaios = ensaios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Tecnico getReposavel() {
        return reposavel;
    }

    public void setReposavel(Tecnico reposavel) {
        this.reposavel = reposavel;
    }

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    public List<Ensaio> getEnsaios() {
        return ensaios;
    }

    public void addEnsaios(Ensaio entity) {
        ensaios.add(entity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Servico servico = (Servico) o;
        return Objects.equals(id, servico.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
