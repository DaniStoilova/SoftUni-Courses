package DefiningClassesExercises.CatLady.CatLady;

public class StreetExtraordinaire {
    private String name;
    private double decibelsOfMeows;

    public StreetExtraordinaire(String name, double decibelsOfMeows){
        this.name = name;
        this.decibelsOfMeows = decibelsOfMeows;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDecibelsOfMeows(double decibelsOfMeows){
        this.decibelsOfMeows = decibelsOfMeows;
    }
    public String getName(){
        return name;
    }
    public double getDecibelsOfMeows(){
        return decibelsOfMeows;
    }
    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f",name,decibelsOfMeows);
    }

}
