package PokemonTrainer;
import java.util.ArrayList;


import java.util.List;


public class Trainer {
    private String name;
    private int badges = 0;
    private List<Pokemon> pokemons;

    public Trainer(String name){
        this.name = name;
        this.pokemons = new ArrayList<>();
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setBadges() {
        this.badges += 1;
    }

    public int getBadges() {
        return badges;
    }

    public String getName() {
        return name;
    }
}
