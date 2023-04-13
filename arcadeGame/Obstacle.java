package java102.arcadeGame;

public abstract class Obstacle {
    private String name;
    private int id;
    private int damage;
    private int health;
    private int headAward;
    private int orgHealth;

    public Obstacle( int id, String name, int damage, int health, int headAward)    {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.headAward = headAward;
        this.orgHealth = orgHealth;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getHeadAward() {
        return headAward;
    }

    public void setHeadAward(int headAward) {
        this.headAward = headAward;
    }

    public int getOrgHealth() {
        return orgHealth;
    }

    public void setOrgHealth(int orgHealth) {
        this.orgHealth = orgHealth;
    }
}

