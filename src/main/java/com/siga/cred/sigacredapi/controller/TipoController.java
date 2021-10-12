package com.siga.cred.sigacredapi.controller;

import java.util.List;

import com.siga.cred.sigacredapi.model.Tipo;
import com.siga.cred.sigacredapi.repository.TipoRepository;

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
@RequestMapping("/tipos")
public class TipoController {

    @Autowired
    private TipoRepository tipoRepository;

    @GetMapping
    public List<Tipo> listar(){
        return tipoRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable int id){
        return tipoRepository.findById(id)
            .map(result -> ResponseEntity.ok().body(result))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tipo adicionar(@RequestBody Tipo tipo){
        return tipoRepository.save(tipo);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Tipo tipo) {
        return tipoRepository.findById(id)
            .map(result -> {
                result.setNome(tipo.getNome());
                Tipo response = tipoRepository.save(result);
                return ResponseEntity.ok().body(response);
            }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable int id) {
        return tipoRepository.findById(id)
            .map(result -> {
                tipoRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}
