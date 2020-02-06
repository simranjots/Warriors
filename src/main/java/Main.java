import Players.Player;
import Teams.Team;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    //Other class Objects
     Random rand = new Random();
     static int member;
     protected static int max_team_members = 20;

    public static void main(String[] args) {

        Main main = new Main();
        String a="A",b="B",c="C",d="D",e="E";
        Team  A = new Team ("Black","Team A",main.createPlayer(a),member);
        A.addPlayerToTeam(A);
        Team  B = new Team ("Blue","Team B",main.createPlayer(b),member);
       B.addPlayerToTeam(B);
        Team  C = new Team ("Red","Team C",main.createPlayer(c),member);
       //C.addPlayerToTeam(C);
        Team  D = new Team ("Grey","Team D",main.createPlayer(d),member);
       // D.addPlayerToTeam(D);
        Team  E = new Team ("Green","Team E",main.createPlayer(e),member);
       // E.addPlayerToTeam(E);

       // A.battleTeam(B);
       if(A.conflict(B)==true){

           A.battleTeam(B) ;

       }
       else {
           System.out.println("NO FIGHT GHAR KO JAO ");
       }


    }//Main Function Ends


    // Constructor
    private  Main() { }

 public ArrayList<Player> createPlayer(String a){
     member = rand.nextInt((max_team_members - 1) + 1) + 1;
     ArrayList<Player> players = new ArrayList<>();
     //Array of Player objects
     Player []payer = new Player[member];
     for (int i = 0; i < member; i++)
     {
         //get input variables;
         payer[i] = new Player(100, "Player "+ i + a, 1,0);
         players.add(payer[i]);
     }
     return players;

 }

}//Class Ends
