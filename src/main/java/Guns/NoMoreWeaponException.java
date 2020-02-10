package Guns;

public class NoMoreWeaponException extends Exception {

    public void NoMoreWeaponException (String playerName){
        System.out.println(" \n \n \t "+playerName+" cannot upgrade the any more because THERE IS NO MORE WEAPONS TO UPDATE");
    }
}
