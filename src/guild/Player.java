package guild;

public class Player {
    private String name;
    private String clazz;
    private String rank;
    private String description;


    public Player(String name, String clazz){
        this.name = name;
        this.clazz = clazz;
        this.rank = "Trial";
        this.description = "n\\a";
    }

    public String getName() {
        return name;
    }

    public String getClazz() {
        return clazz;
    }

    public String getRank() {
        return rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

//    "Player {name}: {clazz}
//    Rank: {rank}
//    Description: {description}"


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Player %s: %s%n",name,clazz));
        str.append(String.format("Rank: %s%n",rank));
        str.append(String.format("Description: %s",description));
        return str.toString();
    }
}
