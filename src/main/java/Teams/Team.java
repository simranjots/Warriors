package Teams;
import Players.Player;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Team {
    static  int thisteam,anotherteam;
    static  int Teama,Teamb;
    public String color;
    public String team_name;
    protected static int x = 500;
    protected static int y = 500;
    public int x_axis;
    public int y_axis;
    public int radius;
    public int member;
    boolean Lose ;
    boolean winner ;
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
        this.Lose =false;
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
         if (this.x_axis > 20) {
             this.setX_axis(this.x_axis - rand.nextInt((50- 1) + 1) + 1);
         } else {
             x_axis = 0;
         }
         if (this.y_axis > 20) {
             this.setY_axis(this.y_axis - rand.nextInt((50- 1) + 1) + 1);
         } else {
             y_axis = 0;
         }
     }//moveTeam Ends


      public boolean battleTeam(Team other_team){
        System.out.println("Attacks");

        //rand.nextInt((max - min) + 1) + min;
        Game:
        while ((this.getMember() > -1) && (other_team.getMember() > -1)) {
             Teama =this.getMember()-1;
             Teamb=other_team.getMember()-1;
            if (Teama < 0) {
                Teama=0;
            }
            if ( Teamb<0) {
               Teamb =0;
            }

            thisteam = rand.nextInt(( Teama- 0) + 1) +0;
            anotherteam = rand.nextInt((Teamb - 0) + 1) + 0;

            System.out.println("Team 1 = " + thisteam);
            System.out.println("Team 2 =" + anotherteam);

            System.out.println("Player " + this.getPlayer().get(0).get(thisteam).getName() +
                    " fighting with " + other_team.getPlayer().get(0).get(anotherteam).getName());

            while (other_team.getPlayer().get(0).get(anotherteam).getHealth() > 0) {
                //My health and enemy health

                this.getPlayer().get(0).get(thisteam).setHealth(this.getPlayer().get(0).get(thisteam).getHealth() -
                        other_team.getPlayer().get(0).get(anotherteam).getWeapons().get(other_team.getPlayer().get(0).get(anotherteam).getSelected_weapon()).fire());

                System.out.println(this.getPlayer().get(0).get(thisteam).getName()+ " HP = "+this.getPlayer().get(0).get(thisteam).getHealth());

                other_team.getPlayer().get(0).get(anotherteam).setHealth(other_team.getPlayer().get(0).get(anotherteam).getHealth() -
                        this.getPlayer().get(0).get(thisteam).getWeapons().get(this.getPlayer().get(0).get(thisteam).getSelected_weapon()).fire());

                System.out.println(other_team.getPlayer().get(0).get(anotherteam).getName()+ " HP = "+other_team.getPlayer().get(0).get(anotherteam).getHealth());

                if (this.getPlayer().get(0).get(thisteam).getHealth() < 0) {
                   break ;
                } else {
                    continue;
                }

            }//second while

            if (this.getPlayer().get(0).get(thisteam).getHealth() < 0) {
                System.out.println("Player " + this.getPlayer().get(0).get(thisteam).getName() + " Dies !!!");
                this.setLose(true);
                other_team.setWinner(true);
                this.setMember(this.getMember() - 1);
                System.out.println(this.getTeam_name()+" remaining member are "+this.getMember());
               }
            else {
                System.out.println("Player " + other_team.getPlayer().get(0).get(anotherteam).getName() + " Dies !!!");
                other_team.setLose(true);
                this.setWinner(true);
                other_team.setMember(other_team.getMember() - 1);
                System.out.println(other_team.getTeam_name() + " remaining member are " + other_team.getMember());
            }
            if ((this.getMember() < -1)){
               break ;
            }else if((other_team.getMember() < -1)) {
               break ;
            }else {
                continue Game;
            }

        }//first while


        return true;
      }//battleTeam Ends
}