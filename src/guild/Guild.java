package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player){
        if(capacity > roster.size()){
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return roster.removeIf(p -> p.getName().equals(name));


    }

    public void promotePlayer(String name){
        Optional<Player> first = roster.stream().filter(p -> p.getName().equals(name)).findFirst();
        if(first.isPresent()){
            if(!first.get().getRank().equals("Member")){
                first.get().setRank("Member");
            }

        }
    }

    public void demotePlayer(String name){
        Optional<Player> first = roster.stream().filter(p -> p.getName().equals(name)).findFirst();
        if(first.isPresent()){
            if(!first.get().getRank().equals("Trial")){
                first.get().setRank("Trial");
            }

        }
    }

    public Player[] kickPlayersByClass(String clazz){

        List<Player> pl = new ArrayList<>();
        for (int i = 0; i < roster.size() ; i++) {
            if(roster.get(i).getClazz().equals(clazz)) {
                pl.add(roster.get(i));
            }
        }

       if(!pl.isEmpty()) {
           for (Player player : pl) {
               roster.remove(player);
           }
       }
        return  pl.toArray(Player[]::new);
    }

    public int count(){
        return roster.size();
    }

    public String report(){
        StringBuilder str  = new StringBuilder();
        str.append(String.format("Players in the guild: %s:%n",this.name));
        if(roster.size()> 0) {
            for (Player player : roster) {
                str.append(player.toString()).append("\n");
            }
        }

        return str.toString().trim();
    }







}
