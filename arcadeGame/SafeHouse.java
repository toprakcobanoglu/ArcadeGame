package java102.arcadeGame;

public class SafeHouse extends NormalLocation{
    public SafeHouse(Player player) {
        super(player, "Base");
    }
    @Override
    public boolean onLocation()    {
        System.out.println("Now your are in safe area.");
        System.out.println("Your health is refilled.");
        this.getPlayer().setHealth(this.getPlayer().getOrgHealth());
        return true;
    }
}
