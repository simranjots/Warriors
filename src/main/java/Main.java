import Players.Player;
import Teams.Team;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    //Other class Objects
     Random rand = new Random();
     int member;

    protected static int max_team_members = 20;

    public static void main(String[] args) {

        Main main = new Main();
        String a="A",b="B",c="C",d="D",e="E";
        Team  A = new Team ("Black","Team A",main.createPlayer(a),main.member);
        //A.addPlayerToTeam(A);
        Team  B = new Team ("Blue","Team B",main.createPlayer(b),main.member);
       //B.addPlayerToTeam(B);
        Team  C = new Team ("Red","Team C",main.createPlayer(c),main.member);
       //C.addPlayerToTeam(C);
        Team  D = new Team ("Grey","Team D",main.createPlayer(d),main.member);
       // D.addPlayerToTeam(D);
        Team  E = new Team ("Green","Team E",main.createPlayer(e),main.member);
       // E.addPlayerToTeam(E);

        A.battleTeam(B);


    }//Main Function Ends


    // Constructor
    private  Main() { }

 public ArrayList<Player> createPlayer(String a){
     ArrayList<Player> players = new ArrayList<>();
      member = rand.nextInt((max_team_members - 1) + 1) + 1;
     //Array of Player objects
     Player []payer = new Player[member];
     for (int i = 0; i < member; i++)
     {
         //get input variables;
         payer[i] = new Player(100, "Player "+(i+1)+a, 1,1);
         players.add(payer[i]);
     }
     return players;

 }

}//Class Ends
