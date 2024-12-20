package com.parasistema.controle_de_concreto.controllers;

import com.parasistema.controle_de_concreto.dto.cliente_dto.ClienteDTO;
import com.parasistema.controle_de_concreto.dto.cliente_dto.ClienteEnderecoDTO;
import com.parasistema.controle_de_concreto.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO>findById(@PathVariable Long id){
        ClienteDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{id}/endereco")
    public ResponseEntity<ClienteEnderecoDTO>findByIdClienteEndereco(@PathVariable Long id){
        ClienteEnderecoDTO dto = service.findByIdClienteEndereco(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ClienteDTO>>findAll(Pageable pageable) {
        Page<ClienteDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto) ;
    }

    @GetMapping(value = "/endereco")
    public ResponseEntity<Page<ClienteEnderecoDTO>>findAllClienteEndereco(Pageable pageable) {
        Page<ClienteEnderecoDTO> dto = service.findAllClienteEndereco(pageable);
        return ResponseEntity.ok(dto) ;
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> insert( @RequestBody ClienteDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PostMapping(value = "/endereco")
    public ResponseEntity<ClienteEnderecoDTO> insertClienteEndereco( @RequestBody ClienteEnderecoDTO dto){
        dto = service.insertClienteEndereco(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @RequestBody ClienteDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
