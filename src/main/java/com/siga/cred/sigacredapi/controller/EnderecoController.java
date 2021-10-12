package com.siga.cred.sigacredapi.controller;

import java.util.List;
import java.util.Optional;

import com.siga.cred.sigacredapi.dto.EnderecoDTO;
import com.siga.cred.sigacredapi.model.Cidade;
import com.siga.cred.sigacredapi.model.Endereco;
import com.siga.cred.sigacredapi.repository.CidadeRepository;
import com.siga.cred.sigacredapi.repository.EnderecoRepository;

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
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public List<Endereco> listar(){
        return enderecoRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable Long id){
        return enderecoRepository.findById(id)
            .map(result -> ResponseEntity.ok().body(result))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco adicionar(@RequestBody EnderecoDTO novo_endereco){
        Optional<Cidade> cidadeOpcional = cidadeRepository.findById(novo_endereco.getCidade_id());
        Endereco endereco = null;
        if(cidadeOpcional.isPresent()) {
            endereco = new Endereco(0l, cidadeOpcional.get(), novo_endereco.getCep(), novo_endereco.getRua(), novo_endereco.getNumero());
        }
        return enderecoRepository.save(endereco);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody EnderecoDTO novo_endereco) {

        return enderecoRepository.findById(id)
            .map(result -> {
                if(novo_endereco.getCidade_id() > 0){
                    Optional<Cidade> cidadeOpcional = cidadeRepository.findById(novo_endereco.getCidade_id());
                    if(cidadeOpcional.isPresent()){
                        result.setCidade(cidadeOpcional.get());
                    }else{
                        return ResponseEntity.notFound().build();
                    }
                }
                if(novo_endereco.getCep() > 0){
                    result.setCep(novo_endereco.getCep());
                }
                if(novo_endereco.getRua() != null && !novo_endereco.getRua().isEmpty()){
                    result.setRua(novo_endereco.getRua());
                }
                if(novo_endereco.getNumero() > 0){
                    result.setNumero(novo_endereco.getNumero());
                }
                Endereco response = enderecoRepository.save(result);
                return ResponseEntity.ok().body(response);
            }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return enderecoRepository.findById(id)
            .map(result -> {
                enderecoRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}
