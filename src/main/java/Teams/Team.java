
package Teams;
import Guns.NoMoreWeaponException;
import Players.Player;
import Warriors.Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Team {
    String temp;
    Main main = new Main();
    static  int thisteam,anotherteam;
    static  int Teama,Teamb;
    public String color;
    public String team_name;
    protected static int x = 1000;
    protected static int y = 1000;
    public int x_axis;
    public int y_axis;
    public int radius;
    public int member;
    boolean Lose;
    boolean winner ;
    //Objects
    Random rand = new Random();
    ArrayList<ArrayList<Player>> player;

    // Constructor
    public Team(String color, String team_name,ArrayList<Player> p,int mem) throws IOException {
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
             this.setX_axis(this.getX_axis() - rand.nextInt((50- 1) + 1) + 1);
         } else {
            setX_axis(0);
         }
         if (this.getY_axis() > 20) {
             this.setY_axis(this.getY_axis() - rand.nextInt((50- 1) + 1) + 1);
         } else {
             setY_axis(0);
         }
     }//moveTeam Ends


      public Team battleTeam(Team other_team) throws IOException, NoMoreWeaponException {
        temp = "\n \t "+this.getTeam_name()+ " started attacking "+other_team.getTeam_name();
        System.out.print(temp);
        main.writeToFile(temp);
        temp = "\n \t "+this.getTeam_name()+" has "+this.getMember()+ " members and "+other_team.getTeam_name()+" has "+other_team.getMember()+" members";
        System.out.println(temp);
        main.writeToFile(temp);

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
               thisteam = rand.nextInt(( Teama- 0) + 1) + 0;
               anotherteam = rand.nextInt((Teamb - 0) + 1) + 0;

               temp =" \n \t " + this.getPlayer().get(0).get(thisteam).getName() +
                       " fighting with " + other_team.getPlayer().get(0).get(anotherteam).getName();
                System.out.print(temp);
                main.writeToFile(temp);

            if(this.getPlayer().get(0).get(thisteam).getScore()>25||other_team.getPlayer().get(0).get(anotherteam).getScore()>25){
                if(this.getPlayer().get(0).get(thisteam).getScore()>25) {
                    try {
                        this.getPlayer().get(0).get(thisteam).getWeapons().get(0).upgradeWeapon(this, thisteam);
                        temp = "\n \t "+this.getPlayer().get(0).get(thisteam).getName() +" has upgraded the Weapon to "+
                                this.getPlayer().get(0).get(thisteam).getWeapons().get(this.getPlayer().get(0).get(thisteam).getSelected_weapon()).getWeaponName();
                        System.out.print(temp);
                        main.writeToFile(temp);
                       }catch (NoMoreWeaponException ex){
                        ex.NoMoreWeaponException(this.getPlayer().get(0).get(thisteam).getName());
                    }
                }else {
                    try { other_team.getPlayer().get(0).get(anotherteam).getWeapons().get(0).upgradeWeapon(other_team,anotherteam);
                        temp = "\n \t "+this.getPlayer().get(0).get(thisteam).getName() +" has upgraded the weapon to "+
                                other_team.getPlayer().get(0).get(anotherteam).getWeapons().get(other_team.getPlayer().get(0).get(anotherteam).getSelected_weapon()).getWeaponName();
                        System.out.print(temp);
                        main.writeToFile(temp);
                    }catch (NoMoreWeaponException ex){
                        ex.NoMoreWeaponException(other_team.getPlayer().get(0).get(anotherteam).getName());
                    }
                }
            }

         temp =" \n \t " + this.getPlayer().get(0).get(thisteam).getName() +" has weapon " +
                    this.getPlayer().get(0).get(thisteam).getWeapons().get(this.getPlayer().get(0).get(thisteam).getSelected_weapon()).getWeaponName()+" and "+
                other_team.getPlayer().get(0).get(anotherteam).getName() +" has weapon " +
                other_team.getPlayer().get(0).get(anotherteam).getWeapons().get(other_team.getPlayer().get(0).get(anotherteam).getSelected_weapon()).getWeaponName()+" \n";

            System.out.print(temp);
            main.writeToFile(temp);

            //Second While
               while (other_team.getPlayer().get(0).get(anotherteam).getHealth() > 1) {
                //condition and then other team health damage
                    if(this.getPlayer().get(0).get(thisteam).getHealth() > 1) {
                     try {
                        other_team.getPlayer().get(0).get(anotherteam).setHealth(other_team.getPlayer().get(0).get(anotherteam).getHealth() -
                         this.getPlayer().get(0).get(thisteam).getWeapons().get(this.getPlayer().get(0).get(thisteam).getSelected_weapon()).fire());

                         temp=" \n \t "+this.getPlayer().get(0).get(thisteam).getName()+" Attacking "+ other_team.getPlayer().get(0).get(anotherteam).getName();
                         System.out.print(temp);
                         main.writeToFile(temp);
                    }catch (NoMoreWeaponException ex){
                       ex.NoMoreWeaponException(this.getPlayer().get(0).get(thisteam).getName());
                   }
                }

                 temp = " \n \t "+other_team.getPlayer().get(0).get(anotherteam).getName() + " HP is "
                         + other_team.getPlayer().get(0).get(anotherteam).getHealth();
                   System.out.print(temp);
                   main.writeToFile(temp);
                  //this team health damage
                   if(other_team.getPlayer().get(0).get(anotherteam).getHealth() > 1) {
                       try {
                       this.getPlayer().get(0).get(thisteam).setHealth(this.getPlayer().get(0).get(thisteam).getHealth() -
                      other_team.getPlayer().get(0).get(anotherteam).getWeapons().get(other_team.getPlayer().get(0).get(anotherteam).getSelected_weapon()).fire());

                           temp = " \n \t "+other_team.getPlayer().get(0).get(anotherteam).getName()+" Attacking "+ this.getPlayer().get(0).get(thisteam).getName();
                           System.out.print(temp);
                           main.writeToFile(temp);
                   }catch (NoMoreWeaponException ex){
                       ex.NoMoreWeaponException(other_team.getPlayer().get(0).get(anotherteam).getName());
                   }
                   }

                   temp ="\n \t "+this.getPlayer().get(0).get(thisteam).getName() + " HP is "+ this.getPlayer().get(0).get(thisteam).getHealth();
                   System.out.print(temp);
                   main.writeToFile(temp);
                //condition
                if (this.getPlayer().get(0).get(thisteam).getHealth() < 0) {
                   break ;
                }
            }//second while

            //If this player Died
            if (this.getPlayer().get(0).get(thisteam).getHealth() < 0) {
                temp = "\n \n \t "+ this.getPlayer().get(0).get(thisteam).getName() + " Dies !!! \n";
                  System.out.print(temp);
                  main.writeToFile(temp);
                  //Health 0
                    this.getPlayer().get(0).get(thisteam).setHealth(0);
                 //updating the radius
                    if(this.getRadius()>0) {
                    this.setRadius(this.radius - 1);
                    }
                    else {
                    this.setRadius(0); }
                    //reducing members
                    this.setMember(this.getMember() - 1);
                  //setting the kills
                   other_team.getPlayer().get(0).get(anotherteam).setKills(other_team.getPlayer().get(0).get(anotherteam).getKills()+1);
                   temp ="\n \t "+other_team.getPlayer().get(0).get(anotherteam).getName()+
                           " Killed "+other_team.getPlayer().get(0).get(anotherteam).getKills()+" opponent player";
                   System.out.print(temp);
                   main.writeToFile(temp);
                //setting the score
                if(other_team.getPlayer().get(0).get(anotherteam).getKills()>0){
                    other_team.getPlayer().get(0).get(anotherteam).setScore(25 * other_team.getPlayer().get(0).get(anotherteam).getKills());
                    if (other_team.getPlayer().get(0).get(anotherteam).getSelected_weapon() > 1) {
                        other_team.getPlayer().get(0).get(anotherteam).setScore(200 * other_team.getPlayer().get(0).get(anotherteam).getKills());
                    } else if (other_team.getPlayer().get(0).get(anotherteam).getSelected_weapon() > 2) {
                        other_team.getPlayer().get(0).get(anotherteam).setScore(400 * other_team.getPlayer().get(0).get(anotherteam).getKills());
                    } else if (other_team.getPlayer().get(0).get(anotherteam).getSelected_weapon() > 3) {
                        other_team.getPlayer().get(0).get(anotherteam).setScore(600 * other_team.getPlayer().get(0).get(anotherteam).getKills());
                    } else if (other_team.getPlayer().get(0).get(anotherteam).getSelected_weapon() > 4) {
                        other_team.getPlayer().get(0).get(anotherteam).setScore(800 * other_team.getPlayer().get(0).get(anotherteam).getKills());
                    }
                    temp = " \n \t "+other_team.getPlayer().get(0).get(anotherteam).getName()+" Score is "+other_team.getPlayer().get(0).get(anotherteam).getScore();
                    System.out.println(temp);
                    main.writeToFile(temp);
                }
                //Showing remaining members
                temp = "\n \t "+this.getTeam_name()+" remaining members are "+this.getMember()+" \n";
                System.out.print(temp);
                main.writeToFile(temp);
                this.getPlayer().get(0).remove(thisteam);
               }
            //If other player Died
            else {
                temp = "\n \t " + other_team.getPlayer().get(0).get(anotherteam).getName() + " Dies !!! \n";
                System.out.print(temp);
                main.writeToFile(temp);
                //Health 0
                other_team.getPlayer().get(0).get(anotherteam).setHealth(0);
                //updating the radius
                if (other_team.getRadius() > 0) {
                    other_team.setRadius(other_team.radius - 1);
                } else {
                    other_team.setRadius(0);
                }
                //Reducing members
                other_team.setMember(other_team.getMember() - 1);
                //setting kills
                this.getPlayer().get(0).get(thisteam).setKills(this.getPlayer().get(0).get(thisteam).getKills() + 1);
                temp = "\n \t " + this.getPlayer().get(0).get(thisteam).getName() +
                        " Killed " + this.getPlayer().get(0).get(thisteam).getKills() + " opponent player";
                System.out.print(temp);
                main.writeToFile(temp);
                //setting the score
                if(this.getPlayer().get(0).get(thisteam).getKills()>0) {
                    this.getPlayer().get(0).get(thisteam).setScore(25 * this.getPlayer().get(0).get(thisteam).getKills());
                    if (this.getPlayer().get(0).get(thisteam).getSelected_weapon() > 1) {
                        this.getPlayer().get(0).get(thisteam).setScore(200 * this.getPlayer().get(0).get(thisteam).getKills());
                    } else if (this.getPlayer().get(0).get(thisteam).getSelected_weapon() > 2) {
                        this.getPlayer().get(0).get(thisteam).setScore(400 * this.getPlayer().get(0).get(thisteam).getKills());
                    } else if (this.getPlayer().get(0).get(thisteam).getSelected_weapon() > 3) {
                        this.getPlayer().get(0).get(thisteam).setScore(600 * this.getPlayer().get(0).get(thisteam).getKills());
                    } else if (this.getPlayer().get(0).get(thisteam).getSelected_weapon() > 4) {
                        this.getPlayer().get(0).get(thisteam).setScore(800 * this.getPlayer().get(0).get(thisteam).getKills());
                    }
                    temp = " \n \t "+this.getPlayer().get(0).get(thisteam).getName()+" Score is "+this.getPlayer().get(0).get(thisteam).getScore();
                    System.out.println(temp);
                    main.writeToFile(temp);
                }
                //Showing remaining members
                temp="\n \t "+other_team.getTeam_name() + " remaining members are " + other_team.getMember()+" \n";
                System.out.print(temp);
                main.writeToFile(temp);
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