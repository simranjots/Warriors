package Players;


import java.util.ArrayList;

public class Player {

    public int health;
    public String name;
    public int rank;
    public int selected_weapon;


    // Constructor
    public Player(int health, String name, int rank, int selected_weapon) {
        this.health = health;
        this.name = name;
        this.rank = rank;
        this.selected_weapon = selected_weapon;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSelected_weapon(int i) {
        return selected_weapon;
    }

    public void setSelected_weapon(int selected_weapon) {
        this.selected_weapon = selected_weapon;
    }
    public int attackPlayer(Player name){

        return this.health;
    }
}
