package java102.arcadeGame;

import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int orgHealth;
    private int coin;
    private String name;

    private Scanner scan = new Scanner(System.in);
    private Inventory inventory;
    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }
    public void selectChar()    {
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("\t \t \t \t \t CHARACTERS");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
        for(GameChar gameChar : charList)   {
            System.out.println(gameChar.getName()+
                    "\t ID: "+gameChar.getId()+
                    "\t Damage: "+gameChar.getDamage()+
                    "\t Health: "+gameChar.getHealth()+
                    "\t Coin: "+gameChar.getCoin());
        }


        System.out.println("Enter your character ID");
        int selectChar = scan.nextInt();
        switch (selectChar)   {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Your choice is: "+this.getName());
        System.out.println("Damage: "+this.getDamage()+"\t Health: "+this.getHealth()+"\t Coin: "+this.getCoin());
    }

    public void initPlayer(GameChar gameChar)   {
        this.setName(gameChar.getName());
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrgHealth(gameChar.getHealth());
        this.setCoin(gameChar.getCoin());
    }

    public void printInfo() {
        System.out.println("Your weapon: "+this.getInventory().getWeapons().getName()
                +", Your armor: "+this.getInventory().getArmor().getName()
                +", Your block: "+this.getInventory().getArmor().getBlock()
                +", Your damage: "+this.getTotalDamage()
                +", Your health: "+this.getHealth()
                +", Your coin: "+this.getCoin());
    }

    public int getTotalDamage() {
        return damage = this.getInventory().getWeapons().getDamage();
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrgHealth() {
        return orgHealth;
    }

    public void setOrgHealth(int orgHealth) {
        this.orgHealth = orgHealth;
    }
}
