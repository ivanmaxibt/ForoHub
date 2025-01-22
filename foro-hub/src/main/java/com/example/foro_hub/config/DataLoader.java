package com.example.foro_hub.config;

import com.example.foro_hub.model.Autor;
import com.example.foro_hub.model.Curso;
import com.example.foro_hub.model.Topico;
import com.example.foro_hub.repository.AutorRepository;
import com.example.foro_hub.repository.CursoRepository;
import com.example.foro_hub.repository.TopicoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(TopicoRepository topicoRepo, AutorRepository autorRepo, CursoRepository cursoRepo) {
        return _ -> {
            Autor autor = new Autor();
            autorRepo.save(autor);

            Curso curso = new Curso();
            cursoRepo.save(curso);

            Topico topico1 = new Topico();
            topico1.setTitulo("Primer Tópico");
            topico1.setMensaje("Este es el primer tópico");
            topico1.setFechaCreacion(LocalDateTime.now());
            topicoRepo.save(topico1);

            Topico topico2 = new Topico();
            topico2.setTitulo("Segundo Tópico");
            topico2.setMensaje("Este es el segundo tópico");
            topico2.setFechaCreacion(LocalDateTime.now());
            topicoRepo.save(topico2);
        };
    }
}

