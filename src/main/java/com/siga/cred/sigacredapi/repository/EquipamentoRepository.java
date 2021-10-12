package com.siga.cred.sigacredapi.repository;

import java.util.List;

import com.siga.cred.sigacredapi.model.Equipamento;
import com.siga.cred.sigacredapi.model.Marca;
import com.siga.cred.sigacredapi.model.Tipo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
    public List<Equipamento> findByTipo(Tipo tipo);
    public List<Equipamento> findByMarca(Marca marca);
}
