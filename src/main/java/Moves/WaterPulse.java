package Moves;

public class WaterPulse implements Moves{
    int powerValue = 60;
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
