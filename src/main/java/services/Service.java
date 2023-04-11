package services;

import model.Superhero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import repositories.SuperheroRepository;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private SuperheroRepository superheltRepository;

    public Service(SuperheroRepository superheltRepository) {
        this.superheltRepository = superheltRepository;
    }

    @GetMapping("/name/{name}")
    public Superhero getByName(@PathVariable("name") String name) {
        return superheroService.getSuperheroByName(name);
    }

