package Moves;

public class Feint implements Moves{
    int powerValue = 30;
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
