package java102.arcadeGame;

public class Weapons<weapon> {
    private String name;
    private int id;
    private int damage;
    private int cost;

    public Weapons(String name, int id, int damage, int cost)    {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.cost = cost;
    }
    public static Weapons[] weapons()    {
        Weapons[] weaponList = new Weapons[3];
        weaponList[0] = new Weapons("Knife",1,2,15);
        weaponList[1] = new Weapons("Pistol",2,3,35);
        weaponList[2] = new Weapons("Rifle",3,7,45);
        return weaponList;

    }

    public static Weapons getWeaponObjByID(int id)  {
        for(Weapons w : Weapons.weapons())  {
            if (w.getId() == id)    {
                return w;
            }
        }
        return null;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
