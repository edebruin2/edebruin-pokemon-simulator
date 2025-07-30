package Moves;

public class FireSpin implements Moves{
    int powerValue = 35;
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
