package com.siga.cred.sigacredapi.dto;

public class EnderecoDTO {
    private int cidade_id;
    private int cep;
    private String rua;
    private int numero;

    public EnderecoDTO(int cidade_id, int cep, String rua, int numero) {
        this.cidade_id = cidade_id;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
    }

    public EnderecoDTO() {
        this.cidade_id = 0;
        this.cep = 0;
        this.rua = "";
        this.numero = 0;
    }

    public int getCidade_id() {
        return cidade_id;
    }

    public void setCidade_id(int cidade_id) {
        this.cidade_id = cidade_id;
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

}
