package java102.arcadeGame;

public class Cave extends BattleLocation{
    public Cave(Player player) {
        super(player, "Skull Cave", new Boomer(), "Water",1);
    }
}
