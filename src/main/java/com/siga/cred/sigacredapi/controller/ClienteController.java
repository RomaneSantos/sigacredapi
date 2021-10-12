package com.siga.cred.sigacredapi.controller;

import java.util.List;
import java.util.Optional;

import com.siga.cred.sigacredapi.dto.ClienteDTO;
import com.siga.cred.sigacredapi.model.Cliente;
import com.siga.cred.sigacredapi.model.Endereco;
import com.siga.cred.sigacredapi.repository.ClienteRepository;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;


    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable Long id){
        return clienteRepository.findById(id)
            .map(result -> ResponseEntity.ok().body(result))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@RequestBody ClienteDTO cliente){
        Optional<Endereco> enderecoOpcional = enderecoRepository.findById(cliente.getEndereco_id());
        Cliente novo = null;
        if(enderecoOpcional.isPresent()){
            novo = new Cliente(0l, cliente.getNome(), enderecoOpcional.get(), cliente.getTelefone(), cliente.getEmail());
        }
        return clienteRepository.save(novo);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ClienteDTO cliente) {
        return clienteRepository.findById(id)
            .map(result -> {
                if(cliente.getEndereco_id() > 0){
                    Optional<Endereco> enderecoOpcional = enderecoRepository.findById(cliente.getEndereco_id());
                    if(enderecoOpcional.isPresent()) {
                        result.setEndereco(enderecoOpcional.get());
                    }else{
                        return ResponseEntity.notFound().build();
                    }
                }
                if(cliente.getNome() != null && !cliente.getNome().isEmpty()){
                    result.setNome(cliente.getNome());
                }
                if(cliente.getTelefone() > 0){
                    result.setTelefone(cliente.getTelefone());
                }
                if(cliente.getEmail() != null && !cliente.getEmail().isEmpty()){
                    result.setEmail(cliente.getEmail());
                }
                Cliente response = clienteRepository.save(result);
                return ResponseEntity.ok().body(response);
            }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return clienteRepository.findById(id)
            .map(result -> {
                clienteRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}
