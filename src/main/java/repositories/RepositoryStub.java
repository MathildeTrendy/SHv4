package repositories;

import DTO.SuperheroCityDTO;
import DTO.SuperheroCreationYearDTO;
import DTO.SuperheroStrengthNumberDTO;
import DTO.SuperheroSuperpowerDTO;
import model.Superhero;
import model.Superpower;

import java.util.ArrayList;
import java.util.List;

public class RepositoryStub implements IRepository {

    private List<Superhero> superheroes = new ArrayList<>();

    public void RepositoryStub() {
        superheroes.add(new Superhero("Peter Pan", "Wanda Maximoff", 2001, true, 6));
        superheroes.add(new Superhero("Peter Plys", "Winnie The Pooh", 1966, false, 1));
        superheroes.add(new Superhero("Blomst", "Flower", 1954, false, 23));
        superheroes.add(new Superhero("Kaptajn Underhyler", "Peeta Mallark", 2010, true, 5));
        superheroes.add(new Superhero("Scooby Doo", "Melvin Doo", 1977, false, 5));
        superheroes.add(new Superhero("Scrappy Doo", "Srudde Dee", 2021, false, 10));
        superheroes.add(new Superhero("Jern Henrik", "Heinrich Heineken", 1968, true, 10));
        superheroes.add(new Superhero("Clover", "Tina Trend", 2014, true, 12));
    }


    @Override
        public List<SuperheroCreationYearDTO> getAllSuperheroes() {
            List<SuperheroCreationYearDTO> dtos = new ArrayList<>();
            for (Superhero superhero : superheroes) {
                dtos.add(new SuperheroCreationYearDTO(superhero.getHeroId(), superhero.getHeroName(), superhero.getCreationYear()));
            }
            return dtos;
        }


    @Override
    public List<SuperheroCreationYearDTO> getSuperheroesName(String heroName) {
        List<SuperheroCreationYearDTO> dtos = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if (superhero.getHeroName().equalsIgnoreCase(heroName)) {
                dtos.add(new SuperheroCreationYearDTO(superhero.getHeroId(), superhero.getHeroName(), superhero.getCreationYear()));
            }
        }
        return dtos;
    }

    @Override
    public List<SuperheroStrengthNumberDTO> getNumberOfPowers() {
        List<SuperheroStrengthNumberDTO> dtos = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            dtos.add(new SuperheroStrengthNumberDTO(superhero.getHeroName(), superhero.getStrength().size()));
        }
        return dtos;
    }

    @Override
    public List<SuperheroStrengthNumberDTO> getNumberOfPowerName(String heroName) {
        List<SuperheroStrengthNumberDTO> dtos = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if (superhero.getHeroName().equalsIgnoreCase(heroName)) {
                dtos.add(new SuperheroStrengthNumberDTO(superhero.getHeroName(), superhero.getStrength().size()));
            }
        }
        return dtos;
    }

    @Override
    public List<SuperheroSuperpowerDTO> getSuperpower() {
        List<SuperheroSuperpowerDTO> dtos = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            for (Superpower superpower : superhero.getSuperpowers()) {
                dtos.add(new SuperheroSuperpowerDTO(superhero.getHeroName(), superpower.getName()));
            }
        }
        return dtos;
    }

    @Override
    public List<SuperheroSuperpowerDTO> getSuperpowerName(String heroName) {
        List<SuperheroSuperpowerDTO> dtos = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if (superhero.getHeroName().equalsIgnoreCase(heroName)) {
                for (Superpower superpower : superhero.getSuperpowers()) {
                    dtos.add(new SuperheroSuperpowerDTO(superhero.getHeroName(), superpower.getName()));
                }
            }
        }
        return dtos;
    }

    @Override
    public List<SuperheroCityDTO> getHeroCity() {
        List<SuperheroCityDTO> result = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            result.add(new SuperheroCityDTO(
        }
        return result;
    }

    @Override
    public List<SuperheroCityDTO> getHeroCityName(String heroName) {
        List<SuperheroCityDTO> searchResult = new ArrayList<>();

        for (Superhero superhero : superheroes) {
            if (superhero.getHeroName().equals(heroName)) {
                searchResult.add(new SuperheroCityDTO(superhero.getHeroName(), superhero.getCity().getName()));;
            }
        }

        return searchResult;

    }
}
