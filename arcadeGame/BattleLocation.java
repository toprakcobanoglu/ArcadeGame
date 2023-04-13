package java102.arcadeGame;

import java.util.Random;

public abstract class BattleLocation extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    public BattleLocation(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }
    @Override
    public boolean onLocation() {
        int obsNumber = randomObstacleNumber();

        System.out.println("Your current location: "+this.getName());
        System.out.println("Be careful, "+obsNumber+" units "+this.getObstacle().getName()+" lives here!!");
        System.out.println("Fight   or   Run");
        String selectBattleCase = scan.next();
        selectBattleCase = selectBattleCase.toUpperCase();
        if (selectBattleCase.equals("F") && (combat(obsNumber)))  {
            System.out.println("Prepare to fight");
            System.out.println(this.getName()+" all the obstacles are defeated!! ");
            System.out.println();
            return true;

        }
        if (this.getPlayer().getHealth() <= 0)   {
            System.out.println("You are DEAD.");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber) {
        for (int i = 1; i<=obsNumber; i++)    {
            this.getObstacle().setHealth(this.getObstacle().getOrgHealth());
            playerStats();
            obstacleStats(i);
            while ((this.getPlayer().getHealth() > 0) && (this.getObstacle().getHealth() > 0))    {
                System.out.println("<H>it  or  <R>un");
                String selectCase = scan.next().toUpperCase();
                if (selectCase.equals("H")) {
                    afterHit();
                    this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                    if (this.getObstacle().getHealth() > 0) {
                        System.out.println();
                        int obsDmg = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obsDmg<0)   {
                            obsDmg = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obsDmg);
                        afterHit();
                    }
                }else {
                    return false;
                }
            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth())  {
                System.out.println("Enemy defeated !");
                System.out.println(this.getObstacle().getHeadAward()+" coin earned.");
                this.getPlayer().setCoin(this.getPlayer().getCoin() + this.getObstacle().getHeadAward());
                System.out.println("Your current coin: "+this.getPlayer().getCoin());
            }else {
                return false;
            }
        }
        return false;
    }

    public void afterHit()  {
        System.out.println("Your Health: "+this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName()+" Health: "+this.getObstacle().getHealth());
        System.out.println();
    }

    public void playerStats()   {
        System.out.println("Player Values");
        System.out.println("- - - - - - - - - - -");
        System.out.println("Health: "+this.getPlayer().getHealth());
        System.out.println("Weapon: "+this.getPlayer().getInventory().getWeapons().getName());
        System.out.println("Damage: "+this.getPlayer().getTotalDamage());
        System.out.println("Armor: "+this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block: "+this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Coin: "+this.getPlayer().getCoin());
    }

    public void obstacleStats(int i) {
        System.out.println(i+". "+this.getObstacle().getName()+" values");
        System.out.println("- - - - - - - - - - -");
        System.out.println("Health: "+this.getObstacle().getHealth());
        System.out.println("Damage: "+this.getObstacle().getDamage());
        System.out.println("Award: "+this.getObstacle().getHeadAward());

    }

    public int randomObstacleNumber()   {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }
    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
