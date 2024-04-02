package DefiningClassesExercises.PokemonTrainer.PokémonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemon;

    public Trainer(String name,int numberOtBadges,List<Pokemon> pokemon){
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemon = new ArrayList<>();
    }



    public String getName() {
        return name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public List<Pokemon>  getPokemon() {
        return pokemon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfBadges() {
        this.numberOfBadges++;
    }

    public void setPokemon(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }
}
