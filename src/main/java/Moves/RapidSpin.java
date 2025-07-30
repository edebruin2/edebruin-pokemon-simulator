package Moves;

public class RapidSpin implements Moves{
    int powerValue = 50;
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
