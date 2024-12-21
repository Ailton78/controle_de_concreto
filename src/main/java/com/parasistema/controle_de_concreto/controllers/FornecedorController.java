package com.parasistema.controle_de_concreto.controllers;

import com.parasistema.controle_de_concreto.dto.cliente_dto.ClienteDTO;
import com.parasistema.controle_de_concreto.dto.cliente_dto.ClienteEnderecoDTO;
import com.parasistema.controle_de_concreto.dto.fornecedor_dto.FornecedorDTO;
import com.parasistema.controle_de_concreto.dto.fornecedor_dto.FornecedorEnderecoDTO;
import com.parasistema.controle_de_concreto.services.ClienteService;
import com.parasistema.controle_de_concreto.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<FornecedorDTO>findById(@PathVariable Long id){
        FornecedorDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/{id}/endereco")
    public ResponseEntity< FornecedorEnderecoDTO>findByIdFornecedorEndereco(@PathVariable Long id){
        FornecedorEnderecoDTO dto = service.findByIdFornecedorEndereco(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<FornecedorDTO>>findAll(Pageable pageable) {
        Page<FornecedorDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto) ;
    }

    @GetMapping(value = "/endereco")
    public ResponseEntity<Page<FornecedorEnderecoDTO>>findAllFornecedorEndereco(Pageable pageable) {
        Page<FornecedorEnderecoDTO> dto = service.findAllFornecedorEndereco(pageable);
        return ResponseEntity.ok(dto) ;
    }

    @PostMapping
    public ResponseEntity<FornecedorDTO> insert( @RequestBody FornecedorDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PostMapping(value = "/endereco")
    public ResponseEntity<FornecedorEnderecoDTO> insertClienteEndereco( @RequestBody FornecedorEnderecoDTO dto){
        dto = service.insertClienteEndereco(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FornecedorDTO> update(@PathVariable Long id, @RequestBody FornecedorDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
