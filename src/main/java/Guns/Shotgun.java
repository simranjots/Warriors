package Guns;

import java.util.Random;

public class Shotgun extends Weapon {
    String weaponName = "Shotgun";
    static int damage = 25;
    static int fire_rate = 3;
    public int bullets;
    int dam ;

    public Shotgun(int bullets) {
        this.bullets = bullets;
    }

    //Objects
    Random rand_aw = new Random();

    public String getWeaponName() {
        return weaponName;
    }

    @Override
    public int fire() {
        this.setBullets(this.getBullets()-1);
        dam= damage()*fire_rate();
        if(this.getBullets()<=0)
        {
            this.reload();
        }
        return this.dam;
    }

    public int damage(){
        this.setDamage(this.rand_aw.nextInt((damage - 1) + 1) + 1);
        return  this.getDamage();
    }
    public  int fire_rate(){
        this.setFire_rate(this.rand_aw.nextInt((fire_rate - 1) + 1) + 1);

        return  this.getFire_rate();
    }
    }
