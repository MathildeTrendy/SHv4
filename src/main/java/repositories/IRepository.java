package repositories;

import DTO.SuperheroCityDTO;
import DTO.SuperheroCreationYearDTO;
import DTO.SuperheroStrengthNumberDTO;
import DTO.SuperheroSuperpowerDTO;

import java.sql.SQLException;
import java.util.List;

public interface IRepository {

    List<SuperheroCreationYearDTO> getAllSuperheroes() throws SQLException;
    List<SuperheroCreationYearDTO> getSuperheroesName(String heroName) throws SQLException;

    List <SuperheroStrengthNumberDTO> getNumberOfPowers() throws SQLException;
    List <SuperheroStrengthNumberDTO> getNumberOfPowerName(String heroName) throws SQLException;

    List<SuperheroSuperpowerDTO> getSuperpower();
    List<SuperheroSuperpowerDTO> getSuperpowerName(String heroName);

    List<SuperheroCityDTO> getHeroCity();
    List<SuperheroCityDTO> getHeroCityName(String heroName);

}
