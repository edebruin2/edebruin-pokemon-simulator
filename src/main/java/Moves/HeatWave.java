package Moves;

public class HeatWave implements Moves{
    int powerValue = 95;
    String type = "Fire";
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
