package com.siga.cred.sigacredapi.dto;

public class ClienteDTO {

    private String nome;
    private Long endereco_id;
    private Long telefone;
    private String email;
    
    public ClienteDTO(String nome, Long endereco_id, Long telefone, String email) {
        this.nome = nome;
        this.endereco_id = endereco_id;
        this.telefone = telefone;
        this.email = email;
    }

    public ClienteDTO() {
        this.nome = "";
        this.endereco_id = 0l;
        this.telefone = 0l;
        this.email = "";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getEndereco_id() {
        return endereco_id;
    }

    public void setEndereco_id(Long endereco_id) {
        this.endereco_id = endereco_id;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

}
