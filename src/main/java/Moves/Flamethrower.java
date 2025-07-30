package Moves;

public class Flamethrower implements Moves{
    int powerValue = 90;
    String type = "Fire";
    String attackType = "Special Attack";

    @Override
    public int getPowerValue() {
        return powerValue;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getAttackType() {
        return attackType;
    }
}
