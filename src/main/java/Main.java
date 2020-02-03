import Teams.Team;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.create_Team();

    }
     private  Main() {
    }

    public void create_Team(){
        Team A = new Team ("Black","Team A");
        Team B = new Team ("Blue","Team B");
        Team C = new Team ("Red","Team C");
        Team D = new Team ("Yellow","Team D");
        Team E = new Team ("Green","Team E");
        A.create_Team();
        B.create_Team();
        C.create_Team();
        D.create_Team();
        E.create_Team();
    }

}
