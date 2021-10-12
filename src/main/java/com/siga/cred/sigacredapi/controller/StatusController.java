package com.siga.cred.sigacredapi.controller;

import java.util.List;

import com.siga.cred.sigacredapi.model.Status;
import com.siga.cred.sigacredapi.repository.StatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;

    @GetMapping
    public List<Status> listar(){
        return statusRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable Long id){
        return statusRepository.findById(id)
            .map(result -> ResponseEntity.ok().body(result))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Status adicionar(@RequestBody Status status){
        return statusRepository.save(status);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Status status) {
        return statusRepository.findById(id)
            .map(result -> {
                result.setNome(status.getNome());
                Status response = statusRepository.save(result);
                return ResponseEntity.ok().body(response);
            }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return statusRepository.findById(id)
            .map(result -> {
                statusRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}
