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
    boolean Lose;
    boolean winner ;
    protected int score;
    protected int kills;
    //Objects
    Random rand = new Random();
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
        this.winner=true;
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

     public void moveTeam() {
         if (this.getX_axis() > 20) {
             this.setX_axis(this.getX_axis() - rand.nextInt((100- 1) + 1) + 1);
         } else {
            setX_axis(0);
         }
         if (this.getY_axis() > 20) {
             this.setY_axis(this.getY_axis() - rand.nextInt((100- 1) + 1) + 1);
         } else {
             setY_axis(0);
         }
     }//moveTeam Ends


      public Team battleTeam(Team other_team){
        System.out.println("Attacks");
        System.out.println(this.getTeam_name());
        System.out.println(this.getMember());
        System.out.println(other_team.getTeam_name());
        System.out.println(other_team.getMember());

        //rand.nextInt((max - min) + 1) + min;
        Game:
        while (this.getMember() > -1 && other_team.getMember() > -1) {
            if(this.getMember()>0) {
                Teama = this.getMember() - 1;
            }else {
                break;
            }if(other_team.getMember()>0) {
                Teamb = other_team.getMember() - 1;
            }else {
                break;
            }
               thisteam = rand.nextInt(( Teama- 0) + 1) +0;
               anotherteam = rand.nextInt((Teamb - 0) + 1) + 0;


            System.out.println("Player " + this.getPlayer().get(0).get(thisteam).getName() +
                    " fighting with " + other_team.getPlayer().get(0).get(anotherteam).getName());

            while (other_team.getPlayer().get(0).get(anotherteam).getHealth() > 0) {
                //condition and then other team health damage
                if(this.getPlayer().get(0).get(thisteam).getHealth() > 0) {
                        other_team.getPlayer().get(0).get(anotherteam).setHealth(other_team.getPlayer().get(0).get(anotherteam).getHealth() -
                         this.getPlayer().get(0).get(thisteam).getWeapons().get(this.getPlayer().get(0).get(thisteam).getSelected_weapon()).fire());

                         System.out.println(other_team.getPlayer().get(0).get(anotherteam).getName() + " HP = "
                            + other_team.getPlayer().get(0).get(anotherteam).getHealth());
                }
                //this team health damage
                  this.getPlayer().get(0).get(thisteam).setHealth(this.getPlayer().get(0).get(thisteam).getHealth() -
                    other_team.getPlayer().get(0).get(anotherteam).getWeapons().get(other_team.getPlayer().get(0).get(anotherteam).getSelected_weapon()).fire());

                System.out.println(this.getPlayer().get(0).get(thisteam).getName()+ " HP = "+this.getPlayer().get(0).get(thisteam).getHealth());


                //condition
                if (this.getPlayer().get(0).get(thisteam).getHealth() < 0) {
                   break ;
                }
            }//second while

            if (this.getPlayer().get(0).get(thisteam).getHealth() < 0) {
                System.out.println("Player " + this.getPlayer().get(0).get(thisteam).getName() + " Dies !!!");
                if(this.getRadius()>0) {
                    this.setRadius(this.radius - 1);}
                else {
                    this.setRadius(0); }
                this.setMember(this.getMember() - 1);
                System.out.println(this.getTeam_name()+" remaining member are "+this.getMember());
                this.getPlayer().get(0).remove(thisteam);
               } else {
                System.out.println("Player " + other_team.getPlayer().get(0).get(anotherteam).getName() + " Dies !!!");
                if(other_team.getRadius()>0) {
                    other_team.setRadius(other_team.radius - 1); }
                else {
                    other_team.setRadius(0);}
                other_team.setMember(other_team.getMember() - 1);
                System.out.println(other_team.getTeam_name() + " remaining member are " + other_team.getMember());
                other_team.getPlayer().get(0).remove(anotherteam);
            }
            if (this.getMember() < -1){
               break ;
            }else if(other_team.getMember() < -1) {
               break ;
            }else {
                continue Game;
            }

        }//first while
          if (this.getMember()==0){
              this.setLose(true);
              this.setWinner(false);
              return this;
          }else {
              other_team.setLose(true);
              other_team.setWinner(false);
               return other_team;
          }
      }//battleTeam Ends
}