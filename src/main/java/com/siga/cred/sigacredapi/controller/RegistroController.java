package com.siga.cred.sigacredapi.controller;

import java.util.List;

import com.siga.cred.sigacredapi.dto.RegistroDTO;
import com.siga.cred.sigacredapi.model.Registro;
import com.siga.cred.sigacredapi.repository.RegistroRepository;

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
@RequestMapping("/registros")
public class RegistroController {

    @Autowired
    private RegistroRepository registroRepository;

    @GetMapping
    public List<Registro> listar(){
        return registroRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable Long id){
        return registroRepository.findById(id)
            .map(result -> ResponseEntity.ok().body(result))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Registro adicionar(@RequestBody RegistroDTO registro){
        Registro novo = new Registro(0l, registro.getCreated(), registro.getUpdated(), registro.getDescricao());
        return registroRepository.save(novo);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody RegistroDTO registro) {
        return registroRepository.findById(id)
            .map(result -> {
                if(registro.getDescricao() != null && !registro.getDescricao().isEmpty()){
                    result.setDescricao(registro.getDescricao());
                }
                result.setUpdated(registro.getUpdated());
                Registro response = registroRepository.save(result);
                return ResponseEntity.ok().body(response);
            }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return registroRepository.findById(id)
            .map(result -> {
                registroRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}
