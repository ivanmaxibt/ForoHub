package com.example.foro_hub.service;

import com.example.foro_hub.model.Topico;
import com.example.foro_hub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository repository;

    public Topico crearTopico(Topico topico) {
        return repository.save(topico);
    }

    public List<Topico> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<Topico> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Topico actualizarTopico(Topico topico) {
        return repository.save(topico);
    }

    public void eliminarTopico(Long id) {
        repository.deleteById(id);
    }
}

