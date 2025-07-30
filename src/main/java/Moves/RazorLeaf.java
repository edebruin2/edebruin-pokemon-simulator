package Moves;

public class RazorLeaf implements Moves{
    int powerValue = 55;
    String type = "Grass";
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
