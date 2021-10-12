package com.siga.cred.sigacredapi.repository;

import com.siga.cred.sigacredapi.model.Problema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemaRepository extends JpaRepository<Problema, Long> {
    
}
