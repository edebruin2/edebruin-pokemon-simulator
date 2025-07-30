package Moves;

public class AquaTail implements Moves{
    int powerValue = 90;
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
