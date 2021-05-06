package com.example.filmy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class FilmyApplication {

    private final FilmRepository repository;

    @Autowired
    public FilmyApplication(FilmRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FilmyApplication.class, args);
    }

    @EventListener(ApplicationContextEvent.class)
    public void start() {
        repository.save(new Film("Igrzyska śmierci", 2012, "StudioCanal"));
        repository.save(new Film("Harry Potter i Kamień Filozoficzny", 2001, "Warner Bros."));
        repository.save(new Film("Władca Pierścieni", 2001, "New Line Cinema"));
    }

}
