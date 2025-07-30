package Moves;

public class ThunderShock implements Moves{
    int powerValue = 40;
    String type = "Electric";
    String attackType = " Special Attack";

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
