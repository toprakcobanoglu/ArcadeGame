package java102.arcadeGame;

public class Inventory {
    private Weapons weapons;
    private Armor armor;

    public Inventory() {
        this.weapons = new Weapons("Punch", -1,0, 0);
        this.armor = new Armor("Woven Armor",-1,0,0);
    }

    public Weapons getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapons weapons) {
        this.weapons = weapons;
    }


    public Armor getArmor() {
        return armor;
    }
    public void setArmor(Armor armor)  {
        this.armor = armor;
    }
}
