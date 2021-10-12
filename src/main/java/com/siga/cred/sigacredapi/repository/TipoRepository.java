package com.siga.cred.sigacredapi.repository;

import com.siga.cred.sigacredapi.model.Tipo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Integer> {
    
}
