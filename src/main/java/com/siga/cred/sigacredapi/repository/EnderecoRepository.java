package com.siga.cred.sigacredapi.repository;

import com.siga.cred.sigacredapi.model.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
}
