package DTO;

import java.time.LocalDate;

public class SuperheroCreationYearDTO {

    private String heroName;
    private String realName;
    private LocalDate creationYear;

    public SuperheroCreationYearDTO(int heroName, String realName, LocalDate creationYear) {
        this.heroName = heroName;
        this.realName = realName;
        this.creationYear = creationYear;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public LocalDate getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(LocalDate creationYear) {
        this.creationYear = creationYear;


    }
}
