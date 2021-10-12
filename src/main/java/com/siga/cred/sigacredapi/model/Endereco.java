package com.siga.cred.sigacredapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "endereco")
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    @Column(nullable = false)
    private int cep;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private int numero;

    public Endereco(Long id, Cidade cidade, int cep, String rua, int numero) {
        this.id = id;
        this.cidade = cidade;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
    }

    public Endereco() {
        this.id = 0l;
        this.cidade = null;
        this.cep = 0;
        this.rua = "";
        this.numero = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Endereco [cep=" + cep + ", cidade=" + cidade + ", id=" + id + ", numero=" + numero + ", rua=" + rua
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + cep;
        result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + numero;
        result = prime * result + ((rua == null) ? 0 : rua.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Endereco other = (Endereco) obj;
        if (cep != other.cep)
            return false;
        if (cidade == null) {
            if (other.cidade != null)
                return false;
        } else if (!cidade.equals(other.cidade))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (numero != other.numero)
            return false;
        if (rua == null) {
            if (other.rua != null)
                return false;
        } else if (!rua.equals(other.rua))
            return false;
        return true;
    }
   
}
