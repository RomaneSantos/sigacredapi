package com.siga.cred.sigacredapi.controller;

import java.util.List;
import java.util.Optional;

import com.siga.cred.sigacredapi.dto.ServicoDTO;
import com.siga.cred.sigacredapi.model.Cliente;
import com.siga.cred.sigacredapi.model.Equipamento;
import com.siga.cred.sigacredapi.model.Problema;
import com.siga.cred.sigacredapi.model.Registro;
import com.siga.cred.sigacredapi.model.Servico;
import com.siga.cred.sigacredapi.model.Status;
import com.siga.cred.sigacredapi.repository.ClienteRepository;
import com.siga.cred.sigacredapi.repository.EquipamentoRepository;
import com.siga.cred.sigacredapi.repository.ProblemaRepository;
import com.siga.cred.sigacredapi.repository.RegistroRepository;
import com.siga.cred.sigacredapi.repository.ServicoRepository;
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
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Autowired
    private ProblemaRepository problemaRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private RegistroRepository registroRepository;

    @Autowired
    private StatusRepository statusRepository;

    @GetMapping
    public List<Servico> listar(){
        return servicoRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable Long id){
        return servicoRepository.findById(id)
            .map(result -> ResponseEntity.ok().body(result))
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = {"/pendentes"})
    public List<Servico> findByPendentes(){
        return servicoRepository.findByStatusIsNot(statusRepository.findFirstByNome("Finalizado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servico adicionar(@RequestBody ServicoDTO servico){
        Optional<Cliente> clienteOpcional = clienteRepository.findById(servico.getCliente_id());
        Optional<Equipamento> equipamentoOpcional = equipamentoRepository.findById(servico.getEquipamento_id());
        Optional<Problema> problemaOpcional = problemaRepository.findById(servico.getProblema_id());
        Optional<Registro> registroOpcional = registroRepository.findById(servico.getRegistro_id());
        Optional<Status> statusOpcional = statusRepository.findById(servico.getStatus_id());
        Servico novo = null;
        if(clienteOpcional.isPresent()){
            if(equipamentoOpcional.isPresent()){
                if(problemaOpcional.isPresent()){
                    if(statusOpcional.isPresent()){
                        novo = new Servico(0l, clienteOpcional.get(), equipamentoOpcional.get(), problemaOpcional.get(), statusOpcional.get(), servico.getCreated(), servico.getUpdated(), servico.getFinalized());
                        if(registroOpcional.isPresent()){
                            novo.adiconarNovoRegistro(registroOpcional.get());
                        }
                    }
                }
            }
        }
        return servicoRepository.save(novo);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ServicoDTO servico) {
        return servicoRepository.findById(id)
            .map(result -> {
                if(servico.getCliente_id() > 0){
                    Optional<Cliente> clienteOpcional = clienteRepository.findById(servico.getCliente_id());
                    if(clienteOpcional.isPresent()) {
                        result.setCliente(clienteOpcional.get());
                    }else{
                        return ResponseEntity.notFound().build();
                    }
                }
                if(servico.getEquipamento_id() > 0){
                    Optional<Equipamento> equipamentoOpcional = equipamentoRepository.findById(servico.getEquipamento_id());
                    if(equipamentoOpcional.isPresent()) {
                        result.setEquipamento(equipamentoOpcional.get());
                    }else{
                        return ResponseEntity.notFound().build();
                    }
                }
                if(servico.getProblema_id() > 0){
                    Optional<Problema> problemaOpcional = problemaRepository.findById(servico.getProblema_id());
                    if(problemaOpcional.isPresent()) {
                        result.setProblema(problemaOpcional.get());
                    }else{
                        return ResponseEntity.notFound().build();
                    }
                }
                if(servico.getRegistro_id() > 0){
                    Optional<Registro> registroOpcional = registroRepository.findById(servico.getRegistro_id());
                    if(registroOpcional.isPresent()) {
                        result.adiconarNovoRegistro(registroOpcional.get());
                    }
                }
                if(servico.getStatus_id() > 0){
                    Optional<Status> statusOpcional = statusRepository.findById(servico.getStatus_id());
                    if(statusOpcional.isPresent()) {
                        result.setStatus(statusOpcional.get());
                    }
                }
                if(servico.getFinalized() != null){
                    result.setFinalized(servico.getFinalized());
                }
                result.setUpdated(servico.getUpdated());
                Servico response = servicoRepository.save(result);
                return ResponseEntity.ok().body(response);
            }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return servicoRepository.findById(id)
            .map(result -> {
                servicoRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}
