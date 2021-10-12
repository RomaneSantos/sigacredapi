package com.siga.cred.sigacredapi.dto;

import java.util.Date;

public class ServicoDTO {

    private Long cliente_id;
    private Long equipamento_id;
    private Long problema_id;
    private Long registro_id;
    private Long status_id;
    private Date created;
    private Date updated;
    private Date finalized;

    
    public ServicoDTO(Long cliente_id, Long equipamento_id, Long problema_id, Long registro_id, Long status_id, Date created, Date updated, Date finalized) {
        this.cliente_id = cliente_id;
        this.equipamento_id = equipamento_id;
        this.problema_id = problema_id;
        this.registro_id = registro_id;
        this.status_id = status_id;
        this.created = created;
        this.updated = updated;
        this.finalized = finalized;
    }

    public ServicoDTO() {
        this.cliente_id = 0l;
        this.equipamento_id = 0l;
        this.problema_id = 0l;
        this.registro_id = 0l;
        this.status_id = 0l;
        this.created = new Date();
        this.updated = new Date();
        this.finalized = null;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Long getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Long status_id) {
        this.status_id = status_id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getFinalized() {
        return finalized;
    }

    public void setFinalized(Date finalized) {
        this.finalized = finalized;
    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Long getEquipamento_id() {
        return equipamento_id;
    }

    public void setEquipamento_id(Long equipamento_id) {
        this.equipamento_id = equipamento_id;
    }

    public Long getProblema_id() {
        return problema_id;
    }

    public void setProblema_id(Long problema_id) {
        this.problema_id = problema_id;
    }

    public Long getRegistro_id() {
        return registro_id;
    }

    public void setRegistro_id(Long registro_id) {
        this.registro_id = registro_id;
    }
    
}
