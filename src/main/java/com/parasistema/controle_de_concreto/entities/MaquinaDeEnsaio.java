package com.parasistema.controle_de_concreto.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_maquina_ensaio")
public class MaquinaDeEnsaio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private String indentificacao;
    private String serie;
    private String classe;
    private String certificacao;
    private LocalDate dataCalibacao;
    private LocalDate ProximaCalibracao;

    @OneToMany(mappedBy = "maquinaDeEnsaio")
    private List<Ensaio> ensaios = new ArrayList<>();

    public MaquinaDeEnsaio() {
    }

    public MaquinaDeEnsaio(Long id, String descricao, String indentificacao, String serie,
                           String classe, String certificacao, LocalDate dataCalibacao,
                           LocalDate proximaCalibracao, List<Ensaio> ensaios) {
        this.id = id;
        this.descricao = descricao;
        this.indentificacao = indentificacao;
        this.serie = serie;
        this.classe = classe;
        this.certificacao = certificacao;
        this.dataCalibacao = dataCalibacao;
        ProximaCalibracao = proximaCalibracao;
        this.ensaios = ensaios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIndentificacao() {
        return indentificacao;
    }

    public void setIndentificacao(String indentificacao) {
        this.indentificacao = indentificacao;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getCertificacao() {
        return certificacao;
    }

    public void setCertificacao(String certificacao) {
        this.certificacao = certificacao;
    }

    public LocalDate getDataCalibacao() {
        return dataCalibacao;
    }

    public void setDataCalibacao(LocalDate dataCalibacao) {
        this.dataCalibacao = dataCalibacao;
    }

    public LocalDate getProximaCalibracao() {
        return ProximaCalibracao;
    }

    public void setProximaCalibracao(LocalDate proximaCalibracao) {
        ProximaCalibracao = proximaCalibracao;
    }

    public List<Ensaio> getEnsaios() {
        return ensaios;
    }

    public void addEnsaio(Ensaio entity) {
        ensaios.add(entity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaquinaDeEnsaio that = (MaquinaDeEnsaio) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
