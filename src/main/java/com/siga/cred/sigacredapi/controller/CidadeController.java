package com.siga.cred.sigacredapi.controller;

import java.util.List;
import java.util.Optional;

import com.siga.cred.sigacredapi.dto.CidadeDTO;
import com.siga.cred.sigacredapi.model.Cidade;
import com.siga.cred.sigacredapi.model.Estado;
import com.siga.cred.sigacredapi.repository.CidadeRepository;
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
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    public List<Cidade> listar(){
        return cidadeRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable int id){
        return cidadeRepository.findById(id)
            .map(result -> ResponseEntity.ok().body(result))
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = {"/uf/{id}"})
    public ResponseEntity<?> findByEstado(@PathVariable int id){
        Optional<Estado> estadoOpcional = estadoRepository.findById(id);
        if(estadoOpcional.isPresent()) {
            return ResponseEntity.ok().body(cidadeRepository.findByEstado(estadoOpcional.get()));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cidade adicionar(@RequestBody CidadeDTO nova_cidade){
        Optional<Estado> estadoOpcional = estadoRepository.findById(nova_cidade.getEstado_id());
        Cidade cidade = null;
        if(estadoOpcional.isPresent()) {
            cidade = new Cidade(0, nova_cidade.getNome(), estadoOpcional.get());
        }
        return cidadeRepository.save(cidade);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody CidadeDTO nova_cidade) {

        return cidadeRepository.findById(id)
            .map(result -> {
                if(nova_cidade.getEstado_id() > 0){
                    Optional<Estado> estadoOpcional = estadoRepository.findById(nova_cidade.getEstado_id());
                    if(estadoOpcional.isPresent()){
                        result.setEstado(estadoOpcional.get());
                    }else{
                        return ResponseEntity.notFound().build();
                    }
                }
                if(nova_cidade.getNome() != null && !nova_cidade.getNome().isEmpty()){
                    result.setNome(nova_cidade.getNome());
                }
                Cidade response = cidadeRepository.save(result);
                return ResponseEntity.ok().body(response);
            }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable int id) {
        return cidadeRepository.findById(id)
            .map(result -> {
                cidadeRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}
