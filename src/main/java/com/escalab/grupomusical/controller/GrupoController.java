package com.escalab.grupomusical.controller;

import java.util.List;

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

import com.escalab.grupomusical.exception.ModeloNotFoundException;
import com.escalab.grupomusical.model.Grupo;
import com.escalab.grupomusical.service.GrupoService;
import javax.validation.Valid;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @GetMapping
    public ResponseEntity<List<Grupo>> listar(){
        List<Grupo> lista = grupoService.getAll();
        return new ResponseEntity<List<Grupo>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grupo> listarPorId(@PathVariable("id") Integer id) {
        if(id != null && id > 0){
            Grupo gr = grupoService.findById(id);
            return new ResponseEntity<Grupo>(gr, HttpStatus.OK);
        }{
            return new ResponseEntity<Grupo>(new Grupo(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Grupo> registrar(@Valid @RequestBody Grupo grupo){
        Grupo gr = grupoService.save(grupo);
        return new ResponseEntity<Grupo>(gr, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Grupo> modificar(@Valid @RequestBody Grupo grupo){
        Grupo gr = grupoService.update(grupo);
        return new ResponseEntity<Grupo>(gr, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
        Grupo gr = grupoService.findById(id);
        if (gr.getIdGrupo() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
        grupoService.delete(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
