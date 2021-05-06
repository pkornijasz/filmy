package com.example.filmy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmApi {
    private final FilmRepository repository;

    @Autowired
    public FilmApi(FilmRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping
    public List<Film> getAllFilms() {
        return repository.findAll();
    }

    @PostMapping
    @FilmAspect
    public void addFilm(@RequestBody Film film) {
        repository.save(film);
    }
}
