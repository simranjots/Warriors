package Teams;
import Players.Player;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Team {
    public String color;
    public String team_name;
    protected static int x = 15;
    protected static int y = 15;
    public int x_axis;
    public int y_axis;
    public int radius;
    public int member;
    boolean Lose = false;
    boolean winner = false;
    protected int score;
    protected int kills;
    protected static int max_team_members = 20;
    //Objects
    Random rand = new Random();
    ArrayList<Team> team_Player;
    ArrayList<ArrayList<Player>> player;

    // Constructor
    public Team(String color, String team_name,ArrayList<Player> p,int mem) {
        this.color = color;
        this.team_name = team_name;
        this.x_axis = location_x_axis();
        this.y_axis = location_y_axis();
        this.member =mem;
        this.radius =10* mem;
        player = new ArrayList<>();
        player.add(p);
    }


    // player function


    public ArrayList<ArrayList<Player>> getPlayer() {
        return player;
    }

    //Team functions
    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public int getMax_team_members() {
        return max_team_members;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public boolean isLose() {
        return Lose;
    }

    public void setLose(boolean lose) {
        Lose = lose;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getX_axis() {
        return x_axis;
    }

    public void setX_axis(int x_axis) {
        this.x_axis = x_axis;
    }

    public int getY_axis() {
        return y_axis;
    }

    public void setY_axis(int y_axis) {
        this.y_axis = y_axis;
    }

    public int location_x_axis(){
        x_axis =rand.nextInt((x - 1) + 1) + 1;
        return x_axis;

    }
    public int location_y_axis(){
        y_axis =rand.nextInt((y - 1) + 1) + 1;
        return y_axis;
    }

    //Add Player to the Team
    public void addPlayerToTeam(Team ob){
        team_Player =new ArrayList<>();
        team_Player.add(ob);
        Iterator itr=team_Player.iterator();

        while(itr.hasNext()){
            Team st=(Team)itr.next();
            System.out.println("******* TOTAL TEAM MEMBERS = " +member+ " **************");
            System.out.println(" \tTeam Name = " + st.getTeam_name() + "\t Team Color = " + st.getColor()+"\t Radius = " +st.getRadius()
                    +"\t "+st.getX_axis()+","+st.getY_axis()+" \tPlayers");
            for (int i=0;i<member;i++) {
                System.out.println("\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t"+st.getPlayer().get(0).get(i).getName());
            }
        }
    }
    public boolean conflict(Team b){
       double dist=Math.sqrt((b.x_axis-this.x_axis)*(b.x_axis-this.x_axis) + (b.y_axis-this.y_axis)*(b.y_axis-this.y_axis));
       System.out.println(dist);
       System.out.println("A = "+this.x_axis);
        System.out.println("B = "+b.x_axis);
        System.out.println("A = "+this.y_axis);
        System.out.println("B = "+b.y_axis);
       if(dist<=(this.radius+b.radius)) {
           return true;
       }
       else {
           return false;
       }
    }
     public void moveTeam() {
         if (this.x_axis > 2) {
             this.setX_axis(this.x_axis - 2);
         } else {
             x_axis = 0;
         }
         if (this.y_axis > 2) {
             this.setY_axis(this.y_axis - 2);
         } else {
             y_axis = 0;
         }
     }//moveTeam Ends

      public void battleTeam(Team otherteam){
        System.out.println("Attacks");
          //My health and enemy health
          System.out.println("Player " +this.getPlayer().get(0).get(0).getName()+ " fighting with " + otherteam.getPlayer().get(0).get(0).getName());
          int h  = this.getPlayer().get(0).get(0).getHealth() - otherteam.getPlayer().get(0).get(0).getWeapons().get(0).fire();
                this.getPlayer().get(0).get(0).setHealth(h);

                System.out.println(h);
          /*int firearm1 =this.getPlayer().get(0).get(0).getWeapons().get(0).fire_rate();
          int dam1=this.getPlayer().get(0).get(0).getWeapons().get(0).damage();
          int damage1 =firearm1*dam1;
          */int h1  = otherteam.getPlayer().get(0).get(0).getHealth() - this.getPlayer().get(0).get(0).getWeapons().get(1).fire();
          this.getPlayer().get(0).get(0).setHealth(h1);

          System.out.println(h1);
         // otherPlayer.setHealth(otherPlayer.getHealth() - this.getWeapons().get(this.getSelectedWeapon()).getDamage());

      }//battleTeam Ends

}