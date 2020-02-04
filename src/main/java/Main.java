import Players.Player;
import Teams.Team;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Main {

    protected static int max_team_members = 20;

    public static void main(String[] args) {

        Main main = new Main();
        //Object
        Random rand = new Random();
        int member = rand.nextInt(max_team_members);
        //Array of Player objects
        Player []payer = new Player[member];
        for (int i = 0; i < member; i++)
        {
            //get input variables;
            payer[i] = new Player(100, "Player "+(i+1), 1,1);
        }

        ArrayList<Player> players = new ArrayList<>();
        for(int i =0;i<member;i++){
            players.add(payer[i]);
        }

        Team  A = new Team ("Black","Team A",players);
        A.addPlayerToTeam(A);

      /*  Iterator itr=players.iterator();

        while(itr.hasNext()){
            Player st=(Player)itr.next();
            System.out.println("Health = "+st.getName());
        }*/
        //Team  B = new Team ("Blue","Team B");
        // Team  C = new Team ("Red","Team C");
        //Team  D = new Team ("Yellow","Team D");
        //Team  E = new Team ("Green","Team E");


    }//Main Function Ends


    // Constructor
    private  Main() { }



}//Class Ends

