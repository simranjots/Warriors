import Players.Player;
import Teams.Team;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Main {


    //Other class Objects
    Random rand = new Random();
    int member;
    protected static int max_team_members = 20;

    public static void main(String[] args) {

        Main main = new Main();





        Team  A = new Team ("Black","Team A",main.createPlayer());
        A.addPlayerToTeam(A,main.member);
        Team  B = new Team ("Blue","Team B",main.createPlayer());
        B.addPlayerToTeam(B,main.member);
        Team  C = new Team ("Red","Team C",main.createPlayer());
        C.addPlayerToTeam(C,main.member);
        Team  D = new Team ("Yellow","Team D",main.createPlayer());
        D.addPlayerToTeam(D,main.member);
        Team  E = new Team ("Green","Team E",main.createPlayer());
        E.addPlayerToTeam(E,main.member);


      /*  Iterator itr=players.iterator();
        while(itr.hasNext()){
            Player st=(Player)itr.next();
            System.out.println("Health = "+st.getName());
        }*/
    }//Main Function Ends


    // Constructor
    private  Main() { }

 public ArrayList<Player> createPlayer(){
     ArrayList<Player> players = new ArrayList<>();
      member = rand.nextInt((max_team_members - 1) + 1) + 1;
     //Array of Player objects
     Player []payer = new Player[member];
     for (int i = 0; i < member; i++)
     {
         //get input variables;
         payer[i] = new Player(100, "Player "+(i+1), 1,1);
         players.add(payer[i]);
     }
     return players;

 }

}//Class Ends
