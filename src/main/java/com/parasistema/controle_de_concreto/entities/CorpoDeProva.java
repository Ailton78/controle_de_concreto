package com.parasistema.controle_de_concreto.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_corpo_de_prova")
public class CorpoDeProva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(unique = true)
    private String identificacao;
    private LocalDate dataMoldagem;
    private String idade;
    private Double diametro;
    private Double altura;
    private String capeamento;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico reposavel;

    @OneToMany(mappedBy = "corpoDeProva")
    private Set<Ensaio> ensaios = new HashSet<>();

    public CorpoDeProva(){}

    public CorpoDeProva(Long id, String identificacao, LocalDate dataMoldagem,
                        String idade, Double diametro, Double altura, String capeamento,
                        Tecnico reposavel, Set<Ensaio> ensaios) {
        this.id = id;
        this.identificacao = identificacao;
        this.dataMoldagem = dataMoldagem;
        this.idade = idade;
        this.diametro = diametro;
        this.altura = altura;
        this.capeamento = capeamento;
        this.reposavel = reposavel;
        this.ensaios = ensaios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getidentificacao() {
        return identificacao;
    }

    public void setidentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public LocalDate getDataMoldagem() {
        return dataMoldagem;
    }

    public void setDataMoldagem(LocalDate dataMoldagem) {
        this.dataMoldagem = dataMoldagem;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public Double getDiametro() {
        return diametro;
    }

    public void setDiametro(Double diametro) {
        this.diametro = diametro;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getCapeamento() {
        return capeamento;
    }

    public void setCapeamento(String capeamento) {
        this.capeamento = capeamento;
    }

    public Tecnico getReposavel() {
        return reposavel;
    }

    public void setReposavel(Tecnico reposavel) {
        this.reposavel = reposavel;
    }

    public Set<Ensaio> getEnsaios() {
        return ensaios;
    }

    public void addEnsaios(Ensaio entity) {
        ensaios.add(entity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CorpoDeProva that = (CorpoDeProva) o;
        return Objects.equals(identificacao, that.identificacao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(identificacao);
    }
}
