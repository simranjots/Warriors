import Guns.NoMoreWeaponException;
import Players.Player;
import Teams.Team;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    //Other class Objects
    StringBuilder result = new StringBuilder();
    String temp = "";
     Random rand = new Random();
     ArrayList<Team> teams = new ArrayList<>();
     Team Loser;
      int l,m;
     static int member;
     double distance;
     protected static int max_team_members = 20;


    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.createTeam();
        main.teamDetails();
        main.teamDistance();
        System.out.println(" ");
        try {
            main.teamNearby();
        }
        catch (NoMoreWeaponException ex){
            ex.NoMoreWeaponException();
        }


    }//Main Function Ends


    // Constructor
    private  Main() { }

    public void print(){
        System.out.println(teams.size());
    }

    public void createTeam(){
        String a="A",b="B",c="C",d="D",e="E";
        teams.add(new Team ("Black","Team A",createPlayer(a),member));
        teams.add(new Team ("Blue","Team B",createPlayer(b),member));
        teams.add(new Team ("Red","Team C",createPlayer(c),member));
        teams.add(new Team ("Grey","Team D",createPlayer(d),member));
        teams.add(new Team ("Green","Team E",createPlayer(e),member));
    }

    public ArrayList<Player> createPlayer(String a){
     member = rand.nextInt((max_team_members - 6) + 1) + 6;
        ArrayList<Player> players = new ArrayList<>();
     //Array of Player objects
     Player []payer = new Player[member];
     for (int i = 0; i < payer.length; i++)
     {    //get input variables;
         payer[i] = new Player(100, "Player "+ i + a, 1,0);
         players.add(payer[i]);
     }

     return players;
     }
     //calling team details
     public void teamDetails() throws IOException {
         for(int i=0;i < teams.size();i++) {
            System.out.println("******* TOTAL TEAM MEMBERS = " + teams.get(i).getMember() + " **************");
            temp = "******* TOTAL TEAM MEMBERS = " + teams.get(i).getMember() + " **************";
            result.append(temp).append("\n");
            writeToFile(result.toString());
             System.out.println(" \tTeam Name = " + teams.get(i).getTeam_name() + "\t Team Color = " + teams.get(i).getColor() +
                     "\t Radius = " + teams.get(i).getRadius()
                     + "\t " + teams.get(i).getX_axis() + "," + teams.get(i).getY_axis() + " \tPlayers");
             for (int j = 0; j < teams.get(i).getMember() ; j++) {
                 System.out.println("\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t" + teams.get(i).getPlayer().get(0).get(j).getName());
             }
         }
     }
    public void teamDistance(){
        System.out.println("Total Teams = "+teams.size());
        for(int i=0;i < teams.size();i++) {
            for (int j = i+1; j < teams.size(); j++) {
                int x1 = teams.get(i).getX_axis();
                int y1 = teams.get(i).getY_axis();
                int x2 = teams.get(j).getX_axis();
                int y2 = teams.get(j ).getY_axis();
                distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
                System.out.println("Distance between " + teams.get(i).getTeam_name()
                        + " and " + teams.get(j).getTeam_name() + " is = " + distance);
            }
        }
    }

    //Match the Teams
   public void teamNearby() throws NoMoreWeaponException{
        while (teams.size() > 1) {
            l=0;
           for (l = 0; l < teams.size(); l++) {
               for ( m = l + 1; m < teams.size(); m++) {
                   int x1 = teams.get(l).getX_axis();
                   int y1 = teams.get(l).getY_axis();
                   int x2 = teams.get(m).getX_axis();
                   int y2 = teams.get(m).getY_axis();
                   distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
                   if (distance <= (teams.get(l).getRadius() + teams.get(m).getRadius())) {
                       System.out.println(teams.get(l).getTeam_name() + " is nearby to " + teams.get(m).getTeam_name());
                       Loser = teams.get(l).battleTeam(teams.get(m));
                       System.out.println("Defeated Team = "+teams.get(teams.indexOf(Loser)).getTeam_name());
                       teams.remove(Loser);
                   }

               }
           }
           System.out.println("  ");
           System.out.println("Teams Left = "+teams.size());
            if (teams.size() > 1) {
                System.out.println("Teams are moving and searching for the opponent Team");
            }
            for (l = 0; l < teams.size(); l++) {
                System.out.println(teams.get(l).getTeam_name());
            }

            for (l = 0; l < teams.size(); l++) {
                for ( m = l + 1; m < teams.size(); m++) {
                    teams.get(l).moveTeam();
                    teams.get(m).moveTeam();
                }
            }

           if (teams.size() < 0) {

                 break;
           }
       }
       System.out.println("Winning Team is "+teams.get(0).getTeam_name());
    }


    void writeToFile(String result) throws IOException {
        File f = new File("Hello.text");
         f.createNewFile();

        FileWriter fw = new FileWriter(f);
        fw.append(result);
        fw.flush();
    }


}//Class Ends
