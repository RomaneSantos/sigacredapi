package com.siga.cred.sigacredapi.repository;

import java.util.List;

import com.siga.cred.sigacredapi.model.Servico;
import com.siga.cred.sigacredapi.model.Status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
    public List<Servico> findByStatusIsNot(Status status);
}
