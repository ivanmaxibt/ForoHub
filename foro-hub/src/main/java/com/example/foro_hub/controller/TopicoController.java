package com.example.foro_hub.controller;

import com.example.foro_hub.model.Topico;
import com.example.foro_hub.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoService service;

    @PostMapping
    public ResponseEntity<Topico> crearTopico(@RequestBody Topico topico) {
        Topico nuevoTopico = service.crearTopico(topico);
        return new ResponseEntity<>(nuevoTopico, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Topico> obtenerTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id)
            .map(topico -> new ResponseEntity<>(topico, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @RequestBody Topico topico) {
        if (!service.obtenerPorId(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        topico.setId(id);
        Topico actualizado = service.actualizarTopico(topico);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        if (!service.obtenerPorId(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.eliminarTopico(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

