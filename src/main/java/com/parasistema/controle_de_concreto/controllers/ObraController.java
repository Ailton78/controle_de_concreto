package com.parasistema.controle_de_concreto.controllers;

import com.parasistema.controle_de_concreto.dto.obra_dto.ObraEnderecoDTO;
import com.parasistema.controle_de_concreto.services.ObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/obras")
public class ObraController {

    @Autowired
    private ObraService service;

    @GetMapping(value = "/{id}/endereco")
    public ResponseEntity<ObraEnderecoDTO>findByIdFornecedorEndereco(@PathVariable Long id){
        ObraEnderecoDTO dto = service.findByIdFornecedorEndereco(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/endereco")
    public ResponseEntity<Page<ObraEnderecoDTO>>findAllFornecedorEndereco(Pageable pageable) {
        Page<ObraEnderecoDTO> dto = service.findAllFornecedorEndereco(pageable);
        return ResponseEntity.ok(dto) ;
    }

    @PostMapping(value = "/endereco")
    public ResponseEntity<ObraEnderecoDTO> insertObraEndereco(@RequestBody ObraEnderecoDTO dto){
        dto = service.insertObraEndereco(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ObraEnderecoDTO> update(@PathVariable Long id, @RequestBody ObraEnderecoDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
