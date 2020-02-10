package Guns;

import Teams.Team;

public abstract class Weapon {
    protected int damage ;
    protected int fire_rate;
    protected int bullets;
    private static final int MAX_NUM_BULLETS = 30;  //is the maximum number of bullets

    public int getBullets() {
        return bullets;
    }

    public void setBullets(int bullets) {
        this.bullets = bullets;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getFire_rate() {
        return fire_rate;
    }

    public void setFire_rate(int fire_rate) {
        this.fire_rate = fire_rate;
    }

    public abstract String getWeaponName();
    public abstract int fire();
    public abstract int damage();
    public abstract int fire_rate();

    public int reload(){
        this.setBullets(this.MAX_NUM_BULLETS);
        return this.getBullets();
    }
    public void upgradeWeapon(Team team,int this_team) throws NoMoreWeaponException{
        //updating the weapon

        team.getPlayer().get(0).get(this_team).setSelected_weapon(team.getPlayer().get(0).get(this_team).getSelected_weapon() + 1);
        team.getPlayer().get(0).get(this_team).setScore(team.getPlayer().get(0).get(this_team).getScore() - 10);

    }
}
