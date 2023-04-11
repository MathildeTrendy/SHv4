package controllers;
import model.Superhero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repositories.SuperheroRepository;
import services.Service;

import java.util.ArrayList;

@RestController
@RequestMapping("/superhelte")
public class SuperheroController {


    @Autowired
    private Service superheroService;
    private SuperheroRepository superheroRepository;

    public SuperheroController(Service superheroService) {
        this.superheroService = superheroService;
    }



    @GetMapping("/name-and-year/{hero_name}")
    public Superhero getByName(@PathVariable("hero_name") String name) {
        return superheroService.getNamesAndYearBy(name);
    }





}
