package com.siga.cred.sigacredapi.controller;

import java.util.List;

import com.siga.cred.sigacredapi.model.Marca;
import com.siga.cred.sigacredapi.repository.MarcaRepository;

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
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping
    public List<Marca> listar(){
        return marcaRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable int id){
        return marcaRepository.findById(id)
            .map(result -> ResponseEntity.ok().body(result))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Marca adicionar(@RequestBody Marca marca){
        return marcaRepository.save(marca);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Marca marca) {
        return marcaRepository.findById(id)
            .map(result -> {
                result.setNome(marca.getNome());
                Marca response = marcaRepository.save(result);
                return ResponseEntity.ok().body(response);
            }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable int id) {
        return marcaRepository.findById(id)
            .map(result -> {
                marcaRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}
