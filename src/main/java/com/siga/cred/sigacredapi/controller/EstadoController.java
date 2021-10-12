package com.siga.cred.sigacredapi.controller;

import java.util.List;

import com.siga.cred.sigacredapi.model.Estado;
import com.siga.cred.sigacredapi.repository.EstadoRepository;

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
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    public List<Estado> listar(){
        return estadoRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable int id){
        return estadoRepository.findById(id)
            .map(result -> ResponseEntity.ok().body(result))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estado adicionar(@RequestBody Estado estado){
        return estadoRepository.save(estado);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Estado novo) {
        return estadoRepository.findById(id)
            .map(result -> {
                result.setNome(novo.getNome());
                result.setSigla(novo.getSigla());
                Estado response = estadoRepository.save(result);
                return ResponseEntity.ok().body(response);
            }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable int id) {
        return estadoRepository.findById(id)
            .map(result -> {
                estadoRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}
