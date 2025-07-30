package Moves;

public class Discharge implements Moves{
    int powerValue = 80;
    String type = "Electric";
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
