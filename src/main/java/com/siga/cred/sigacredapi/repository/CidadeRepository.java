package com.siga.cred.sigacredapi.repository;

import java.util.List;

import com.siga.cred.sigacredapi.model.Cidade;
import com.siga.cred.sigacredapi.model.Estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

    public List<Cidade> findByEstado(Estado estado);
}
