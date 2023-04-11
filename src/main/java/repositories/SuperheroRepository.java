package repositories;

import model.Superhero;

import java.sql.*;

public class SuperheroRepository {

    public Superhero getHeroByNamesAndYear(String hero_name, String real_name, int creation_year) {
        try (
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/superhero", "root", "Mathmilo1996")
        ) {
            String SQL = "SELECT * FROM superhero WHERE " + hero_name + " = \"" + real_name + "\";" + creation_year + "\";";
            Statement stmt = con.createStatement();

            ResultSet rst = stmt.executeQuery(SQL);
            System.out.println("Forbundet til Database");
            if (rst.next()) {
                int heroId = rst.getInt("superhero_id");
                String heroName = rst.getString("hero_name");
                String realName = rst.getString("real_name");
                int creationYear = rst.getInt("creation_year");
                String superPower = rst.getString("superpower");
                int human = rst.getInt("is_human");
                double strength = rst.getDouble("strength");

                System.out.println(heroId + heroName + realName + creationYear + superPower);

                return new Superhero(heroId, heroName, realName, creationYear, superPower, human, strength);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}



