package com.example.senai.AtvPontuada1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String logradouro;
    private String numero;
    private String complemento;
    private String ciddade;

    public Endereco() {
    }
    public Endereco(Long id, String logradouro, String numero, String complemento, String ciddade) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.ciddade = ciddade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCiddade() {
        return ciddade;
    }

    public void setCiddade(String ciddade) {
        this.ciddade = ciddade;
    }
}
