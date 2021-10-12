package com.siga.cred.sigacredapi.dto;

import java.util.Date;

public class RegistroDTO {

    private Date created;
    private Date updated;
    private String descricao;

    public RegistroDTO(Date created, Date updated, String descricao) {
        this.created = created;
        this.updated = updated;
        this.descricao = descricao;
    }
    
    public RegistroDTO() {
        this.created = new Date();
        this.updated = new Date();
        this.descricao = "";
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
