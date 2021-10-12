package com.siga.cred.sigacredapi.repository;

import com.siga.cred.sigacredapi.model.Marca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {
    
}
