package Teams;

import java.util.ArrayList;
import java.util.Random;

public class Team {
    protected String color;
    protected String name;
    protected int x ;
    protected int y;
    protected int radius;
    protected static int member;
    protected boolean Lose;
    protected boolean winner;
    protected int score;
    protected int kills;
    protected static int max_team_members=20;
    ArrayList<Team> weapons;

    public Team(String color, String name) {
        this.color = color;
        this.name = name;
    }

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public int getMax_team_members() {
        return max_team_members;
    }

    public void setMax_team_members(int max_team_members) {
        this.max_team_members = max_team_members;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getXAxis() {
        return x;
    }

    public void setXAxis(int x) {
        this.x = x;
    }

    public int getYAxis() {
        return y;
    }

    public void setYAxis(int y) {
        this.y = y;
    }

    // create the team here
    public void create_Team() {
        Random rand = new Random();
        member = rand.nextInt(max_team_members);
        System.out.println(member);
    }
    public void location(){
        
    }

}
