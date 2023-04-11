package DTO;

public class SuperheroStrengthNumberDTO {

    private String heroName;
    private String realName;
    private int strength;


    public SuperheroStrengthNumberDTO(String heroName, int strength) {
        this.heroName = heroName;
        this.realName = realName;
        this.strength = strength;
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

    public int getStrength() {
        return strength;
    }

    public void setSuperpower(int strength) {
        this.strength = strength;
    }






}

