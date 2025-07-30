package Moves;

public class PetalDance implements Moves{
    int powerValue = 120;
    String type = "Grass";
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
