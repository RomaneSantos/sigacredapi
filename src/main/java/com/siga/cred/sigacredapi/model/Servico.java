package com.siga.cred.sigacredapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "servico")
@Entity
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamento;

    @ManyToOne
    @JoinColumn(name = "problema_id")
    private Problema problema;

    @OneToMany
    @JoinColumn(name = "servico_id")
    private List<Registro> registros;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date finalized;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    public Servico(Long id, Cliente cliente, Equipamento equipamento, Problema problema, Status status, Date created, Date updated, Date finalized) {
        this.id = id;
        this.cliente = cliente;
        this.equipamento = equipamento;
        this.problema = problema;
        this.status = status;
        this.created = created;
        this.updated = updated;
        this.finalized = finalized;
    }

    public Servico() {
        this.id = 0l;
        this.cliente = null;
        this.equipamento = null;
        this.problema = null;
        this.status = null;
        this.created = new Date();
        this.updated = new Date();
        this.finalized = new Date();
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Problema getProblema() {
        return problema;
    }

    public void setProblema(Problema problema) {
        this.problema = problema;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

    public void adiconarNovoRegistro(Registro registro){
        if (this.registros == null)
            registros = new ArrayList<Registro>();
		
		registros.add(registro);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "Servico [cliente=" + cliente + ", equipamento=" + equipamento + ", id=" + id + ", problema=" + problema
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        result = prime * result + ((equipamento == null) ? 0 : equipamento.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((problema == null) ? 0 : problema.hashCode());
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
        Servico other = (Servico) obj;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        if (equipamento == null) {
            if (other.equipamento != null)
                return false;
        } else if (!equipamento.equals(other.equipamento))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (problema == null) {
            if (other.problema != null)
                return false;
        } else if (!problema.equals(other.problema))
            return false;
        return true;
    }

    
}
