package Warriors;

import Guns.NoMoreWeaponException;
import Players.Player;
import Teams.Team;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    //Other class Objects
     Random rand = new Random();
     ArrayList<Team> teams = new ArrayList<>();
      Team Loser;
      private String temp = "";
      int l,m;
     static int member;
     double distance;
     protected static int max_team_members = 20;

    public Main() throws IOException {
        checkFile();

    }

    public static void main(String[] args) throws IOException, NoMoreWeaponException {

        Main main = new Main();
        main.createTeam();
        main.teamDetails();
        main.teamDistance();
        System.out.println(" ");
        main.teamNearby();



    }//Warriors.Main Function Ends

    public void print(){
        System.out.println(teams.size());
    }

    public void createTeam() throws IOException {
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
             temp = "\n \tTeam Name = " + teams.get(i).getTeam_name() + "\t Team Color = " + teams.get(i).getColor()+
                    "\t Team Members = "+ teams.get(i).getMember()  +
                     "\t Location = " + teams.get(i).getX_axis() + "," + teams.get(i).getY_axis()+
                     "\t Territory Radius = " + teams.get(i).getRadius();
             System.out.print(temp);
             writeToFile(temp);
             for (int j = 0; j < teams.get(i).getMember() ; j++) {
                 System.out.print("\n \t "+ teams.get(i).getPlayer().get(0).get(j).getName());
             }

         }

     }
    public void teamDistance() throws IOException {
        temp = " \n ";
        System.out.print(temp);
        writeToFile(temp);
        for(int i=0;i < teams.size();i++) {
            for (int j = i+1; j < teams.size(); j++) {
                int x1 = teams.get(i).getX_axis();
                int y1 = teams.get(i).getY_axis();
                int x2 = teams.get(j).getX_axis();
                int y2 = teams.get(j ).getY_axis();
                distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
                temp = "\n  \t Distance between " + teams.get(i).getTeam_name()
                        + " and " + teams.get(j).getTeam_name() + " is = " + distance;
                System.out.print(temp);
                writeToFile(temp);
            }
        }
    }

    //Match the Teams
   public void teamNearby() throws IOException, NoMoreWeaponException {
        while (teams.size() > 1) {
            l=0;
            temp = " \n ";
            System.out.print(temp);
            writeToFile(temp);
           for (l = 0; l < teams.size(); l++) {
               for ( m = l + 1; m < teams.size(); m++) {
                   int x1 = teams.get(l).getX_axis();
                   int y1 = teams.get(l).getY_axis();
                   int x2 = teams.get(m).getX_axis();
                   int y2 = teams.get(m).getY_axis();
                   distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
                   if (distance <= (teams.get(l).getRadius() + teams.get(m).getRadius())) {

                       temp = " \n \t " +teams.get(l).getTeam_name() + " is nearby to " + teams.get(m).getTeam_name()+" \n ";
                       System.out.print(temp);
                       writeToFile(temp);
                       Loser = teams.get(l).battleTeam(teams.get(m));
                       temp =" \n \t "+teams.get(teams.indexOf(Loser)).getTeam_name()+" got Defeated. ";
                       System.out.print(temp);
                       writeToFile(temp);
                       teams.remove(Loser);
                   }

               }
           }
           temp = " ";
           System.out.print(temp);
           writeToFile(temp);
           if(teams.size()>1) {
               temp = "\n \t Remaining Teams are " + teams.size();
               System.out.print(temp);
               writeToFile(temp);
           }
            if (teams.size() > 1) {
                temp ="\n \t Teams are moving and searching for the other Teams";
                System.out.print(temp);
                writeToFile(temp);
            }
            for (l = 0; l < teams.size(); l++) {
                if(teams.size()>1) {
                    temp = "\n \t " + teams.get(l).getTeam_name();
                    System.out.print(temp);
                    writeToFile(temp);
                }
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
        temp = "\n \n \t !!!!!!!!!!!!!!! Winning Team is "+teams.get(0).getTeam_name()+" !!!!!!!!!!!!!!!!!!!! \n";
       System.out.println(temp);
       writeToFile(temp);

    }

 public  void checkFile() {

     boolean success = (new File("battle.txt")).exists();
     if (success) {
         (new File("battle.txt")).delete();
     }
 }
   public void writeToFile(String result) throws IOException {

           FileWriter fw = new FileWriter("battle.txt", true);
           BufferedWriter buff = new BufferedWriter(fw);
           PrintWriter printWriter = new PrintWriter(buff);

           printWriter.append(result);
           printWriter.flush();
           printWriter.close();

    }


}//Class Ends
