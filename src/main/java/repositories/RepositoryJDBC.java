package repositories;

import DTO.SuperheroCityDTO;
import DTO.SuperheroCreationYearDTO;
import DTO.SuperheroStrengthNumberDTO;
import DTO.SuperheroSuperpowerDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepositoryJDBC implements IRepository{

    String url = "jdbc:mysql://localhost:3306/Superhero_database"; // URL to the database
    String user = "root"; // Username for the database
    String password = "Mathmilo1996"; // Password to the database
    Connection connection = DriverManager.getConnection(url, user, password);

    public RepositoryJDBC() throws SQLException {}

    @Override
    public List<SuperheroCreationYearDTO> getAllSuperheroes() throws SQLException {
    List<SuperheroCreationYearDTO> heroes = new ArrayList<>();
    String query = "SELECT * FROM superhero";
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
        SuperheroCreationYearDTO hero = new SuperheroCreationYearDTO(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getDate("creation_date").toLocalDate()
        );
        heroes.add(hero);
    }
        return heroes;
}

    @Override
    public List<SuperheroCreationYearDTO> getSuperheroesName(String heroName) throws SQLException {

        //Method uses JDBC to connect to a database and execute a SELECT query with a WHERE clause to find a particular superhero's name.
        //The IRepository interface must be implemented using JDBC to retrieve data from this database

        List<SuperheroCreationYearDTO> heroes = new ArrayList<>();
        String query = "SELECT * FROM superhero WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, heroName);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            SuperheroCreationYearDTO hero = new SuperheroCreationYearDTO(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDate("creation_date").toLocalDate()
            );
            heroes.add(hero);
        }
        return heroes;
    }

    @Override
    public List<SuperheroStrengthNumberDTO> getNumberOfPowers() throws SQLException {
        List<SuperheroStrengthNumberDTO> heroes = new ArrayList<>();
        String query = "SELECT superhero_name, COUNT(*) as power_count FROM superhero_powers GROUP BY superhero_name";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String heroName = resultSet.getString("superhero_name");
                int powerCount = resultSet.getInt("power_count");
                SuperheroStrengthNumberDTO hero = new SuperheroStrengthNumberDTO(heroName, powerCount);
                heroes.add(hero);
            }
        }
        return heroes;
    }

    @Override
    public List<SuperheroStrengthNumberDTO> getNumberOfPowerName(String heroName) throws SQLException {
        List<SuperheroStrengthNumberDTO> heroes = new ArrayList<>();
        String query = "SELECT superhero_name, COUNT(*) as power_count FROM superhero_powers WHERE superhero_name = ?";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, heroName);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int powerCount = resultSet.getInt("power_count");
                    SuperheroStrengthNumberDTO hero = new SuperheroStrengthNumberDTO(heroName, powerCount);
                    heroes.add(hero);
                }
            }
        }
        return heroes;
    }

    @Override
    public List<SuperheroSuperpowerDTO> getSuperpower() {
        List<SuperheroSuperpowerDTO> heroList = new ArrayList<>();

            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                String query = "SELECT superhero.name, superpower.power FROM superhero JOIN hero_superpower ON superhero.id = hero_superpower.hero_id JOIN superpower ON hero_superpower.power_id = superpower.id";
                PreparedStatement statement = connection.prepareStatement(query);

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String power = resultSet.getString("power");
                    heroList.add(new SuperheroSuperpowerDTO(name, power));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return heroList;
        }

    @Override
    public List<SuperheroSuperpowerDTO> getSuperpowerName(String heroName) {
        List<SuperheroSuperpowerDTO> heroList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT superhero.name, superpower.power FROM superhero JOIN hero_superpower ON superhero.id = hero_superpower.hero_id JOIN superpower ON hero_superpower.power_id = superpower.id WHERE superhero.name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, heroName);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String power = resultSet.getString("power");
                heroList.add(new SuperheroSuperpowerDTO(name, power));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return heroList;
    }

    @Override
    public List<SuperheroCityDTO> getHeroCity() {
    List<SuperheroCityDTO> heroCityList = new ArrayList<>();
            try {
                Connection connection = DriverManager.getConnection(url, user, password);
                Statement statement = connection.createStatement();
                String query = "SELECT heroName, cityName FROM superhero JOIN city ON superhero.city_id = city.id";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    SuperheroCityDTO heroCity = new SuperheroCityDTO();
                    heroCity.setHeroName(resultSet.getString("heroName"));
                    heroCity.setCity(resultSet.getString("cityName"));
                    heroCityList.add(heroCity);
                }
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return heroCityList;
        }

    @Override
    public List<SuperheroCityDTO> getHeroCityName(String heroName) {
        return null;
    }
}
}