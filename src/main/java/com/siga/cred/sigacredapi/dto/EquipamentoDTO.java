package com.siga.cred.sigacredapi.dto;

public class EquipamentoDTO {

    private int tipo_id;
    private int marca_id;

    public EquipamentoDTO(){

    }
    
    public EquipamentoDTO(int tipo_id, int marca_id) {
        this.tipo_id = tipo_id;
        this.marca_id = marca_id;
    }

    public int getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(int tipo_id) {
        this.tipo_id = tipo_id;
    }

    public int getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(int marca_id) {
        this.marca_id = marca_id;
    }

}
