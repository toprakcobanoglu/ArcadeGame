package java102.arcadeGame;

public class Forest extends BattleLocation{
    public Forest(Player player) {
        super(player, "Deep Forest", new Zombie(), "Food",3);
    }
}
