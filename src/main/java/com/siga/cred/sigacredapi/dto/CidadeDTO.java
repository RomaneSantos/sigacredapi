package com.siga.cred.sigacredapi.dto;

public class CidadeDTO {
    private String nome;
    private int estado_id;

    public CidadeDTO(){
        this.nome = "";
        this.estado_id = 0;
    }

    public CidadeDTO(String nome, int estado_id){
        this.nome = nome;
        this.estado_id = estado_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(int estado_id) {
        this.estado_id = estado_id;
    }
}
