package com.siga.cred.sigacredapi.repository;

import com.siga.cred.sigacredapi.model.Status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    public Status findFirstByNome(String nome);
}
