package DTO;

public class SuperheroSuperpowerDTO {

    private String heroName;
    private String realName;
    private String superpower;

    public SuperheroSuperpowerDTO(String heroName, String realName) {
        this.heroName = heroName;
        this.realName = realName;
        this.superpower = superpower;
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

    public String getSuperpower() {
        return superpower;
    }

    public void setSuperpower(String superpower) {
        this.superpower = superpower;
    }
}
