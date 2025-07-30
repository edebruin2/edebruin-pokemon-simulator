package PokemonClasses;

import Moves.Moves;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Pokemon {
    int level;
    int HP;
    int curHP;
    int Attack;
    int Defense;
    int SpAtk;
    int SpDef;
    int Speed;

    int BASE_HP;
    int BASE_ATTACK;
    int BASE_DEFENSE;
    int BASE_SPATK;
    int BASE_SPDEF;
    int BASE_SPEED;

    String type1;
    String type2;

    protected ArrayList<Moves> attacks;
    int EvolutionLevel;
    boolean fainted;
    protected String name;
    ArrayList<Moves> learnedMoves;

    // Can we make a constructor that is universal to all children?
    public Pokemon(String name, int level){
        this.name = name;
        this.level = level;
        this.attacks = new ArrayList<>();
        this.learnedMoves = new ArrayList<>();
    }

    public Pokemon(String name, int level, int BASE_HP, int BASE_ATTACK, int BASE_DEFENSE, int BASE_SPATK, int BASE_SPDEF, int BASE_SPEED){
        this.name = name;
        this.level = level;
        this.attacks = new ArrayList<>();
        this.learnedMoves = new ArrayList<>();
        this.BASE_HP = BASE_HP;
        this.BASE_ATTACK = BASE_ATTACK;
        this.BASE_DEFENSE = BASE_DEFENSE;
        this.BASE_SPATK = BASE_SPATK;
        this.BASE_SPDEF = BASE_SPDEF;
        this.BASE_SPEED = BASE_SPEED;
        calculateStats();
    }

    public int attack(Moves attack, Pokemon defendingPokemon){
        double multiplier = calculateMultiplier(attack, defendingPokemon);
        if(multiplier == 0.0){
            System.out.println("It had no effect!");
        }
        if(multiplier < 1.0){
            System.out.println("It wasn't very effective...");
        }
        if(multiplier > 1.5){
            System.out.println("It's super effective!!!");
        }
        if(attack.getAttackType().equals("Attack")){
            return calculateDamage(attack.getPowerValue(), this.Attack, defendingPokemon.Defense, multiplier);
        }
        else{
            return calculateDamage(attack.getPowerValue(), this.SpAtk, defendingPokemon.SpDef, multiplier);
        }
    }

    public int calculateDamage(int powerValue, int attackStat, int defenseStat, double multiplier){
        int damage = (int) Math.floor((double) ((((((2*this.level)/5) + 2) * powerValue * attackStat/defenseStat) / 50) + 2) * multiplier);
        return damage;
    }

    public double calculateMultiplier(Moves attack, Pokemon defendingPokemon){
        try {
            String json = getJSONfromFile("TypeMatchups.json");
            double multiplier1;
            double multiplier2 = 1.0;
            double overallMultipler;
            JSONParser parser = new JSONParser();
            JSONObject mainJSONObject = (JSONObject) parser.parse(json);
            JSONObject typeMatchup = (JSONObject) mainJSONObject.get(attack.getType().toLowerCase());
            if (!defendingPokemon.type2.isEmpty()) {
                multiplier2 = (double) typeMatchup.get(defendingPokemon.getType2().toLowerCase());
            }
            multiplier1 = (double) typeMatchup.get(defendingPokemon.getType1().toLowerCase());
            overallMultipler = multiplier1 * multiplier2;
            if (attack.getType().equals(this.type1) || attack.getType().equals(this.type2)) {
                overallMultipler *= 1.5;
            }
            return overallMultipler;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return 1.0;
    }

    public int defend(int startingHP, int damage){
        return startingHP - damage;
    }
  
    public abstract void updateMoves();

    public void swapMoves(Moves move, String moveName){
        learnedMoves.add(move);
        System.out.println(this.name + " wants to learn " + moveName + " (" + move.getType() + ") (" + move.getAttackType() + ") (Base Power: " + move.getPowerValue() + ")");
        System.out.println("Do you want " + this.name + " to learn " + moveName + "? (Yes/No)");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next().toLowerCase();
        if (choice.equals("yes")) {
            printAllInfo();
            System.out.println("Which attack would you like to swap?\n");
            for (int i = 0; i < attacks.size(); i++) {
                System.out.println((i + 1) + ". " + attacks.get(i).getClass().getSimpleName() + " (" + attacks.get(i).getType() + ") (" + attacks.get(i).getAttackType() + ") (Base Power: " + attacks.get(i).getPowerValue() + ")");
            }
            int moveChoice = -1;
            while (moveChoice < 1 || moveChoice > attacks.size()) {
                System.out.println("New Move: " + moveName + " (" + move.getType() + ") (" + move.getAttackType() + ") (Base Power: " + move.getPowerValue() + ")");
                System.out.println("\nEnter the number of the move to replace (1-" + attacks.size() + "): ");
                System.out.println("Or Enter 5 if you would like to keep your current moves.");
                while (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.next(); // discard non-integer input
                    System.out.print("\nEnter the number of the move to replace (1-" + attacks.size() + "): ");
                }
                moveChoice = scanner.nextInt();
                if (moveChoice == 5){
                    System.out.println(this.getClass().getSimpleName() + " did not learn " + moveName);
                    return;
                }
                if (moveChoice < 1 || moveChoice > attacks.size()) {
                    System.out.println("Invalid choice, please choose a number between 1 and " + attacks.size());
                }
            }
            Moves forgottenMoves = attacks.get(moveChoice - 1);
            attacks.set(moveChoice - 1, move);
            System.out.println(this.name + " has learned " + moveName + " and forgotten " + forgottenMoves.getClass().getSimpleName() + ".");
            return;
        }
        System.out.println(this.getClass().getSimpleName() + " did not learn " + move.getClass().getSimpleName());
    }

    public boolean hasLearnedMove(String moveName) {
        return learnedMoves.stream().anyMatch(m -> m.getClass().getSimpleName().equalsIgnoreCase(moveName));
    }

    public ArrayList<Moves> getAttacks() {
        return attacks;  // This method allows other classes to access the moves
    }

    public boolean train(int opponent) {
        boolean evolved = false;
        Pokemon currentPokemon = this;

        for (int i = 0; i < opponent; i++) {
            if (currentPokemon.level < 100) {
                levelUp();
                System.out.println("Your " + currentPokemon.getClass().getSimpleName() + " trained and is now level " + currentPokemon.level);
                currentPokemon.updateMoves();
                if (currentPokemon.level == 100) {
                    System.out.println("Your " + currentPokemon.getClass().getSimpleName() + " has reached the maximum level!");
                    break;
                }
            }

            // Evolve our Pokemon if they have reached an evolution threshold
            if (currentPokemon.level >= currentPokemon.EvolutionLevel) {
                Pokemon evolvedPokemon = currentPokemon.evolve();
                if (evolvedPokemon != currentPokemon) { // Evolution has occurred
                    System.out.println("Your " + currentPokemon.getClass().getSimpleName() + " has evolved into " + evolvedPokemon.getClass().getSimpleName() + "!");
                    evolved = true;
                    currentPokemon = evolvedPokemon;  // Update the reference to continue training the evolved Pokémon
                }
            }
        }
        return evolved;
    }

    public void levelUp(){
        this.level++;
        calculateStats();
    }

    public void calculateStats(){
        this.HP = (int) Math.floor(((double)(2*BASE_HP*level / 100) + level + 10));
        this.Attack = (int) Math.floor(((double)(2*BASE_ATTACK*level / 100) + 5));
        this.Defense = (int) Math.floor(((double)(2*BASE_DEFENSE*level / 100) + 5));
        this.SpAtk = (int) Math.floor(((double)(2*BASE_SPATK*level / 100) + 5));
        this.SpDef = (int) Math.floor(((double)(2*BASE_SPDEF*level / 100) + 5));
        this.Speed = (int) Math.floor(((double)(2*BASE_SPEED*level / 100) + 5));
        this.curHP = this.HP;
    }
    public abstract Pokemon evolve();

    public void printAllInfo(){
        System.out.println("\nCurrent Pokémon: " + this.getClass().getSimpleName() + " (" + this.getType1() + " " + this.getType2() + ")" +
                "\nCurrent Level: " + this.level +
                "\nMax HP: " + this.HP +
                "\nAttack: " + this.Attack +
                "\nDefense: " + this.Defense +
                "\nSpecial Attack: " + this.SpAtk +
                "\nSpecial Defense: " + this.SpDef +
                "\nSpeed: " + this.Speed +
                "\n------\n" +
                "Moves: ");
        for(int i = 0; i < attacks.size(); i++){
            System.out.println(attacks.get(i).getClass().getSimpleName() + " (" + attacks.get(i).getType() + ") (" + attacks.get(i).getAttackType() + ") (" + attacks.get(i).getPowerValue() + ")");
        }
        System.out.println("\n");
    }

    public void printMoves(){
        for(int i = 0; i < attacks.size(); i++){
            System.out.println((i+1) + ". " + attacks.get(i).getClass().getSimpleName() + " (" + attacks.get(i).getType() + ") (" + attacks.get(i).getAttackType() + ") (" + attacks.get(i).getPowerValue() + ")");
        }
        System.out.println("\n");
    }

    public int getLevel(){
        return this.level;
    }

    public int getHP() { return this.HP; }
    public int getAttack() { return this.Attack; }
    public int getDefense() { return this.Defense; }
    public int getSpAtk() { return this.SpAtk; }
    public int getSpDef() { return this.SpDef; }
    public int getSpeed() { return this.Speed; }
    public boolean isFainted() { return this.fainted;  }
    public void setFainted(boolean fainted) { this.fainted = fainted; }
    public void setCurHP(int curHP) { this.curHP = curHP;}
    public int getCurHP() {return this.curHP; }

    public String getType1(){ return this.type1; }
    public String getType2(){ return this.type2; }

    public String getJSONfromFile(String filename){
        String jsonText = "";
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./src/main/resources/" + filename));

            String newLine;
            while((newLine = bufferedReader.readLine()) != null){
                jsonText += newLine + "\n";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonText;
    }


}
