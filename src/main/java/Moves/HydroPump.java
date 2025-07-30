package Moves;

public class HydroPump implements Moves{
    int powerValue = 110;
    String type = "Water";
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
