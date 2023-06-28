package LadyCat;

public class Cat {
    private String breed;
    private String name;
    private double criteria;

    public Cat(String breed, String name, double criteria) {
        this.breed = breed;
        this.name = name;
        this.criteria = criteria;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f",breed,name,criteria);
    }
}
