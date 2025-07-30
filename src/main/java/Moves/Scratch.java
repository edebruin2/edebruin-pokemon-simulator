package Moves;

public class Scratch implements Moves{
    int powerValue = 40;
    String type = "Normal";
    String attackType = "Attack";

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
