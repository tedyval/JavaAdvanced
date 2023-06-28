package Google;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemon;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public Person(String name){
        this.name = name;
        this.company = null;
        this.pokemon = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.car = null;
    }


    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemon() {
        return pokemon;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String pokeList = "";
        if(pokemon.size() > 0){
            pokeList = pokemon.stream().map(p->p.getPokemonName() + " " + p.getPokemonType()).collect(Collectors.joining(System.lineSeparator())) + "\n";
        }

        String parentsList = "";
        if(parents.size() > 0){
          parentsList = parents.stream().map(p->p.getParentName() + " " + p.getParentBirthday()).collect(Collectors.joining(System.lineSeparator())) + "\n";
        }
        String childrenList = "";
        if(children.size() > 0){
            childrenList = children.stream().map(p->p.getChildName() + " " + p.getChildBirthday()).collect(Collectors.joining(System.lineSeparator()));
        }

        String companyPrint= "";
        if(company != null){
            companyPrint = company.toString();
        }

        String carPrint = "";
        if(car != null){
            carPrint = car.toString();
        }

        StringBuilder str = new StringBuilder();
        str.append(name).append("\n")
                .append("Company:").append("\n").append(companyPrint)
                .append("Car:").append("\n").append(carPrint)
                .append("Pokemon:").append("\n").append(pokeList)
                .append("Parents:").append("\n").append(parentsList)
                .append("Children:").append("\n").append(childrenList);

        return  str.toString();

    }
}

