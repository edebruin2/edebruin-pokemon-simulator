package Moves;

public class WaveCrash implements Moves{
    int powerValue = 120;
    String type = "Water";
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
