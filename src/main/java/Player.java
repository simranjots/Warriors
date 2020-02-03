public class Player {

    protected int health;
    protected String name;
    protected int rank;
    protected int selected_weapon;

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

    public int getSelected_weapon() {
        return selected_weapon;
    }

    public void setSelected_weapon(int selected_weapon) {
        this.selected_weapon = selected_weapon;
    }

    public int attack(){

        return 0;
    }
}
