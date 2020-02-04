package Teams;
import Players.Player;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Team {
    public String color;
    public String team_name;
    public int x = 20 ;
    public int y = 20;
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
    public Team(String color, String team_name,ArrayList<Player> p) {
        this.color = color;
        this.team_name = team_name;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public int location_x_axis(){
        x_axis =rand.nextInt(x);
        System.out.println("X-axis = "+x_axis);
        return x_axis;

    }
    public int location_y_axis(){
        y_axis =rand.nextInt(y);
        System.out.println("Y-axis = "+y_axis);
        System.out.println("");
        return y_axis;
    }

    //Add Player to the Team
    public void addPlayerToTeam(Team ob,int members){
        team_Player =new ArrayList<>();
        team_Player.add(ob);
        Iterator itr=team_Player.iterator();

        while(itr.hasNext()){
            Team st=(Team)itr.next();
            System.out.println("******* TOTAL TEAM MEMBERS = " +members+ " **************");
            for (int i=0;i<members;i++) {

                System.out.println(" Team Name = " + st.getTeam_name() + " \n Team Color = " + st.getColor() + "\n Players = " + st.getPlayer().get(0).get(i).getName());
            }
        }
    }
    /*public void attackTeam(Team otherteam){
        System.out.println("Attacks");
        for(int x = 0; x <= this.member; x++)//it doesnt display the first card
        {
            System.out.println(player.get(x).getHealth() + " " + player.get(x).getName() + " " + player.get(x).getRank());
        }
        for(int x = 0; x <=otherteam.member; x++)//it doesnt display the first card
        {
            System.out.println(player.get(x).getHealth() + " " + player.get(x).getName() + " " + player.get(x).getRank());
        }
    }*/

}