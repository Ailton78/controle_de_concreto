package com.parasistema.controle_de_concreto.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_ensaio")
public class Ensaio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double carga;
    private Double tempo;

    @ManyToOne
    @JoinColumn(name = "corpo_de_prova_id")
    private CorpoDeProva corpoDeProva;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    private Servico servico;

    @ManyToOne
    @JoinColumn(name = "maquina_id")
    private MaquinaDeEnsaio maquinaDeEnsaio;

    public Ensaio(){}

    public Ensaio(Long id, Double carga, Double tempo,
                  CorpoDeProva corpoDeProva, Servico servico, MaquinaDeEnsaio maquinaDeEnsaio) {
        this.id = id;
        this.carga = carga;
        this.tempo = tempo;
        this.corpoDeProva = corpoDeProva;
        this.servico = servico;
        this.maquinaDeEnsaio = maquinaDeEnsaio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCarga() {
        return carga;
    }

    public void setCarga(Double carga) {
        this.carga = carga;
    }

    public Double getTempo() {
        return tempo;
    }

    public void setTempo(Double tempo) {
        this.tempo = tempo;
    }

    public CorpoDeProva getCorpoDeProva() {
        return corpoDeProva;
    }

    public void setCorpoDeProva(CorpoDeProva corpoDeProva) {
        this.corpoDeProva = corpoDeProva;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public MaquinaDeEnsaio getMaquinaDeEnsaio() {
        return maquinaDeEnsaio;
    }

    public void setMaquinaDeEnsaio(MaquinaDeEnsaio maquinaDeEnsaio) {
        this.maquinaDeEnsaio = maquinaDeEnsaio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ensaio ensaio = (Ensaio) o;
        return Objects.equals(id, ensaio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
