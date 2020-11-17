package com.escalab.grupomusical.controller;

import com.escalab.grupomusical.exception.ModeloNotFoundException;
import com.escalab.grupomusical.model.Musico;
import com.escalab.grupomusical.service.MusicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/grupos")
public class MusicoController {
    @Autowired
    private MusicoService musicoService;

    @GetMapping
    public ResponseEntity<List<Musico>> listar(){
        List<Musico> lista = musicoService.getAll();
        return new ResponseEntity<List<Musico>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musico> listarPorId(@PathVariable("id") Integer id){
        if(id != null && id > 0){
            Musico ms = musicoService.findById(id);
            return new ResponseEntity<Musico>(ms, HttpStatus.OK);
        }{
            return new ResponseEntity<Musico>(new Musico(), HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<Musico> registrar(@Valid @RequestBody Musico musico){
    	Musico ms = musicoService.save(musico);
    	return new ResponseEntity<Musico>(ms, HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<Musico> modificar(@Valid @RequestBody Musico musico){
    	Musico ms = musicoService.update(musico);
    	return new ResponseEntity<Musico>(ms, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
    	Musico ms = musicoService.findById(id);
    	if(ms.getIdMusico() == null) {
    		throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
    	}
    	musicoService.delete(id);
    	return new ResponseEntity<Object>(HttpStatus.OK);
    }
    
}
