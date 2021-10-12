package com.siga.cred.sigacredapi.controller;

import java.util.List;
import java.util.Optional;

import com.siga.cred.sigacredapi.dto.EquipamentoDTO;
import com.siga.cred.sigacredapi.model.Equipamento;
import com.siga.cred.sigacredapi.model.Marca;
import com.siga.cred.sigacredapi.model.Tipo;
import com.siga.cred.sigacredapi.repository.EquipamentoRepository;
import com.siga.cred.sigacredapi.repository.MarcaRepository;
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
@RequestMapping("/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private TipoRepository tipoRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping
    public List<Equipamento> listar(){
        return equipamentoRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable Long id){
        return equipamentoRepository.findById(id)
            .map(result -> ResponseEntity.ok().body(result))
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = {"/tipo/{id}"})
    public ResponseEntity<?> findByTipo(@PathVariable int id){
        Optional<Tipo> tipoOpcional = tipoRepository.findById(id);
        if(tipoOpcional.isPresent()){
            return ResponseEntity.ok().body(equipamentoRepository.findByTipo(tipoOpcional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = {"/marca/{id}"})
    public ResponseEntity<?> findByMarca(@PathVariable int id){
        Optional<Marca> marcaOpcional = marcaRepository.findById(id);
        if(marcaOpcional.isPresent()){
            return ResponseEntity.ok().body(equipamentoRepository.findByMarca(marcaOpcional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipamento adicionar(@RequestBody EquipamentoDTO equipamento){
        Optional<Tipo> tipoOpcional = tipoRepository.findById(equipamento.getTipo_id());
        Optional<Marca> marcaOpcional = marcaRepository.findById(equipamento.getMarca_id());
        Equipamento novo = null;
        if(tipoOpcional.isPresent()){
            if(marcaOpcional.isPresent()){
                novo = new Equipamento(0l, tipoOpcional.get(), marcaOpcional.get());
            }
        }
        return equipamentoRepository.save(novo);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody EquipamentoDTO equipamento) {
        return equipamentoRepository.findById(id)
            .map(result -> {
                if(equipamento.getTipo_id() > 0){
                    Optional<Tipo> tipoOpcional = tipoRepository.findById(equipamento.getTipo_id());
                    if(tipoOpcional.isPresent()) {
                        result.setTipo(tipoOpcional.get());
                    }else{
                        return ResponseEntity.notFound().build();
                    }
                }
                if(equipamento.getMarca_id() > 0){
                    Optional<Marca> marcaOpcional = marcaRepository.findById(equipamento.getMarca_id());
                    if(marcaOpcional.isPresent()) {
                        result.setMarca(marcaOpcional.get());
                    }else{
                        return ResponseEntity.notFound().build();
                    }
                }
                Equipamento response = equipamentoRepository.save(result);
                return ResponseEntity.ok().body(response);
            }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return equipamentoRepository.findById(id)
            .map(result -> {
                equipamentoRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}
