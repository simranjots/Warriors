package Guns;

import java.util.Random;

public class Sniper extends Weapon {
    static int damage = 40;
    static int fire_rate = 2;
    public int bullets;

    public Sniper(int bullets) {
        this.bullets = bullets;
    }

    //Objects
    Random rand_aw = new Random();

    @Override
    public int fire() {
        System.out.println("Shooting through Sniper");
        this.setBullets(this.getBullets()-1);
        if(this.getBullets()<=0)
        {
            this.reload();
        }
        return this.getBullets();
    }
    public int damage(){
        this.setDamage(this.rand_aw.nextInt(damage));
        return  this.getDamage();
    }
    public  int fire_rate(){
        this.setFire_rate(this.rand_aw.nextInt(fire_rate));

        return  this.getFire_rate();
    }
}
