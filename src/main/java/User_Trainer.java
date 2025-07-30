import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Moves.Moves;
import PokemonClasses.*;

import java.util.concurrent.TimeUnit;

public class User_Trainer extends Trainer{
    String name;

    public User_Trainer(String name) {
        this.name = name;
    }

    public boolean battle() throws InterruptedException{
        boolean isBattling = true;
        System.out.println("You have initiated a Pokemon Battle!");
        TimeUnit.SECONDS.sleep(2);

        NPC_Trainer enemyTrainer = new NPC_Trainer();
        int curPokemonIdx = 0;
        Pokemon enemyLead = enemyTrainer.pokemonInParty.get(curPokemonIdx);
        enemyLead.setCurHP(enemyLead.getHP());

        Pokemon userLead = this.pokemonInParty.get(0);
        System.out.println("Go! " + userLead.getClass().getSimpleName() + "!\n");
        TimeUnit.SECONDS.sleep(2);
        userLead.setCurHP(userLead.getHP());

        while (isBattling) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enemy Pokemon: " + enemyLead.getClass().getSimpleName() + " (" + enemyLead.getCurHP() + " / " + enemyLead.getHP() + ") HP\n");
            System.out.println("Your Pokemon: " + userLead.getClass().getSimpleName() + " (" + userLead.getCurHP() + " / " + userLead.getHP() + ") HP\n");
            System.out.println("""
                    -----------------
                    Choose what to do:
                    (1) Select a Move to Attack with
                    (2) Swap your Pokemon with another in your Party
                    (3) Get info on your Pokémon
                    (4) Forfeit the Battle
                    -----------------
                    """);
            int userChoice = scanner.nextInt();
            int userDamage;
            int enemyDamage;
            Moves enemyMove;
            switch (userChoice) {
                case 1:
                    Moves userMove = pickMove(userLead, scanner);
                    enemyMove = enemyTrainer.pickOptimalMove(userLead, enemyLead);
                    /*

                    If User is Faster or Equal Speed with Enemy

                     */
                    if (userLead.getSpeed() >= enemyLead.getSpeed()) {
                        System.out.println(userLead.getClass().getSimpleName() + " used " + userMove.getClass().getSimpleName());
                        TimeUnit.SECONDS.sleep(1);
                        userDamage = userLead.attack(userMove, enemyLead);
                        enemyLead.setCurHP(enemyLead.defend(enemyLead.getCurHP(), userDamage));
                        if (enemyLead.getCurHP() <= 0) {
                            enemyLead.setFainted(true);
                            System.out.println(enemyLead.getClass().getSimpleName() + " has fainted!");
                            TimeUnit.SECONDS.sleep(2);
                            if (!enemyTrainer.checkIfPartyAlive()) {
                                System.out.println("You have defeated the trainer!");
                                TimeUnit.SECONDS.sleep(2);
                                return true;
                            }
                            curPokemonIdx++;
                            enemyLead = enemyTrainer.pokemonInParty.get(curPokemonIdx);
                            System.out.println("The enemy trainer sent out " + enemyLead.getClass().getSimpleName());
                            TimeUnit.SECONDS.sleep(2);
                            break;
                        }
                        System.out.println("Enemy " + enemyLead.getClass().getSimpleName() + " used " + enemyMove.getClass().getSimpleName());
                        TimeUnit.SECONDS.sleep(1);
                        enemyDamage = enemyLead.attack(enemyMove, userLead);
                        userLead.setCurHP(userLead.defend(userLead.getCurHP(), enemyDamage));
                        if (userLead.getCurHP() <= 0) {
                            userLead.setFainted(true);
                            System.out.println(userLead.getClass().getSimpleName() + " has fainted!");
                            TimeUnit.SECONDS.sleep(2);
                            if (!checkIfPartyAlive()) {
                                System.out.println("You have been defeated by the trainer...");
                                TimeUnit.SECONDS.sleep(2);
                                return false;
                            }
                            userLead = selectNewLead(scanner);
                            System.out.println("Go! " + userLead.getClass().getSimpleName() + "!");
                            TimeUnit.SECONDS.sleep(2);
                            break;
                        }
                    }
                    /*

                    If User is Slower Speed than Enemy

                     */
                    else{
                        System.out.println("Enemy " + enemyLead.getClass().getSimpleName() + " used " + enemyMove.getClass().getSimpleName());
                        TimeUnit.SECONDS.sleep(1);
                        enemyDamage = enemyLead.attack(enemyMove, userLead);
                        userLead.setCurHP(userLead.defend(userLead.getCurHP(), enemyDamage));
                        if (userLead.getCurHP() <= 0) {
                            userLead.setFainted(true);
                            System.out.println(userLead.getClass().getSimpleName() + " has fainted!");
                            TimeUnit.SECONDS.sleep(2);
                            if (!checkIfPartyAlive()) {
                                System.out.println("You have been defeated by the trainer...");
                                TimeUnit.SECONDS.sleep(2);
                                return false;
                            }
                            System.out.println("Go! " + userLead.getClass().getSimpleName() + "!");
                            TimeUnit.SECONDS.sleep(2);
                            break;
                        }
                        System.out.println(userLead.getClass().getSimpleName() + " used " + userMove.getClass().getSimpleName());
                        TimeUnit.SECONDS.sleep(1);
                        userDamage = userLead.attack(userMove, enemyLead);
                        enemyLead.setCurHP(enemyLead.defend(enemyLead.getCurHP(), userDamage));
                        if (enemyLead.getCurHP() <= 0) {
                            enemyLead.setFainted(true);
                            System.out.println(enemyLead.getClass().getSimpleName() + " has fainted!");
                            TimeUnit.SECONDS.sleep(2);
                            if (!enemyTrainer.checkIfPartyAlive()) {
                                System.out.println("You have defeated the trainer!");
                                TimeUnit.SECONDS.sleep(2);
                                return true;
                            }
                            curPokemonIdx++;
                            enemyLead = enemyTrainer.pokemonInParty.get(curPokemonIdx);
                            System.out.println("The enemy trainer sent out " + enemyLead.getClass().getSimpleName());
                            TimeUnit.SECONDS.sleep(2);
                            break;
                        }
                    }
                    break;
                case 2:
                    enemyMove = enemyTrainer.pickOptimalMove(userLead, enemyLead);
                    Pokemon oldLead = userLead;
                    userLead = selectNewLead(scanner);
                    if(userLead.equals(oldLead)){
                        System.out.println(userLead.getClass().getSimpleName() + " is already in Battle!");
                        break;
                    }
                    else{
                        System.out.println("Go! " + userLead.getClass().getSimpleName() + "!");
                        System.out.println("Enemy " + enemyLead.getClass().getSimpleName() + " used " + enemyMove.getClass().getSimpleName());
                        TimeUnit.SECONDS.sleep(1);
                        enemyDamage = enemyLead.attack(enemyMove, userLead);
                        userLead.setCurHP(userLead.defend(userLead.getCurHP(), enemyDamage));
                        if (userLead.getCurHP() <= 0) {
                            userLead.setFainted(true);
                            System.out.println(userLead.getClass().getSimpleName() + " has fainted!");
                            TimeUnit.SECONDS.sleep(2);
                            if (!checkIfPartyAlive()) {
                                System.out.println("You have been defeated by the trainer...");
                                TimeUnit.SECONDS.sleep(2);
                                return false;
                            }
                            System.out.println("Go! " + userLead.getClass().getSimpleName() + "!");
                            TimeUnit.SECONDS.sleep(2);
                            break;
                        }
                    }
                    break;
                case 3:
                    printParty();
                    System.out.println("Which Pokémon do you want more info on?");
                    userChoice = scanner.nextInt();
                    if(userChoice > 0 && userChoice < this.pokemonInParty.size()-1){
                        pokemonInParty.get(userChoice-1).printAllInfo();
                    }
                    break;
                case 4:
                    System.out.println("Are you sure you want to forfeit the battle? (Yes/No)");
                    String userForfeit = scanner.next();
                    if(userForfeit.equalsIgnoreCase("yes")){
                        System.out.println("You have forfeited the battle.");
                        return false;
                    }
                    break;
                default:
                    System.out.println("Please make a valid selection.");
            }


        }
        return false;
    }

    public Moves pickMove(Pokemon userLead, Scanner scanner) {
        while (true) {
            System.out.println("Which move would you like to use?");
            userLead.printMoves();
            int userSelection = scanner.nextInt();
            ArrayList<Moves> attacks = userLead.getAttacks();
            if (userSelection > 0 && userSelection - 1 <= attacks.size()) {
                return attacks.get(userSelection-1);
            }
        }
    }

    public Pokemon selectNewLead(Scanner scanner){
        while (true) {
            printParty();
            System.out.println("Please select a Pokemon to swap into battle!");
            int userSelection = scanner.nextInt();
            if(userSelection > 0 && userSelection-1 < pokemonInParty.size()) {
                if (pokemonInParty.get(userSelection - 1).isFainted()) {
                    System.out.println(pokemonInParty.get(userSelection - 1).getClass().getSimpleName() + " is unable to battle.");
                } else {
                    return pokemonInParty.get(userSelection - 1);
                }
            }
        }
    }
    public boolean catchPokemon(){
        ArrayList<Pokemon> wildPokemon = new ArrayList<>();
        wildPokemon.add(new Pikachu(5, new ArrayList<>(), new ArrayList<>()));
        wildPokemon.add(new Charmander(5, new ArrayList<>(), new ArrayList<>()));
        wildPokemon.add(new Bulbasaur(5, new ArrayList<>(), new ArrayList<>()));
        wildPokemon.add(new Squirtle(5, new ArrayList<>(), new ArrayList<>()));

        Random rng = new Random();
        int index = rng.nextInt(wildPokemon.size());
        Pokemon newPokemon = wildPokemon.get(index);

        return wildEncounter(newPokemon, rng);

    }

    public boolean wildEncounter(Pokemon pokemon, Random rng){
        // Initialize flags to manage the encounter process
        boolean requestMade = false;
        boolean success = false;
        Scanner scanner = new Scanner(System.in);
        String pokemonSpecies = pokemon.getClass().getSimpleName();

        // Loop until a valid response is received from the user
        while(!requestMade){
            System.out.println("\nYou found a new " + pokemonSpecies + "! Would you like to catch it? \n" +
                    "Type 'Yes' to try and catch it.\n" +
                    "Type 'No' to skip.");

            String trainerRequest = scanner.nextLine().toLowerCase();
            if(trainerRequest.equals("yes")){
                requestMade = true;
                int chance = rng.nextInt(100);
                // Check if the random chance to catch the Pokémon is successful
                if(chance > 20){
                    System.out.println("Congrats! You caught the " + pokemonSpecies + "!");
                    if(this.pokemonInParty.size() >= 6){
                        this.pokemonInPC.add(pokemon);
                        System.out.println("Your party was full, so your new " + pokemonSpecies + " was sent to the PC.");
                        success = true;
                    }
                    else{
                        this.pokemonInParty.add(pokemon);
                        System.out.println("Your new " + pokemonSpecies + " was added to the Party.");
                        success = true;
                    }
                }
                else{
                    System.out.println("Darn! The " + pokemonSpecies + " escaped!");
                }
            }
            else if(trainerRequest.equals("no")){
                requestMade = true;
            }
            // Handle invalid inputs by requesting another attempt
            else{
                System.out.println("Invalid Response.");
            }
        }
        return success;
    }
    public void train (int opponents){
        // Initialize flag to control the loop for selecting a Pokémon to train.
        boolean selectionMade = false;
        Pokemon curPokemon = null;
        int userNumber = -1;
        // Loop until a valid Pokémon selection is made by the user.
        while(!selectionMade){
            System.out.println("Which Pokémon do you want to train?");
            printParty();
            Scanner scanner = new Scanner(System.in);
            userNumber = scanner.nextInt();
            if (userNumber > 0 && userNumber <= pokemonInParty.size()) {
                selectionMade = true;
                curPokemon = pokemonInParty.get(userNumber - 1);
            }
            else{
                System.out.println("The input you provided is not one of the available Pokémon");
            }
        }
        // Engage the selected Pokémon in the specified number of battles.
        for (int i = 0; i < opponents; i++) {
            boolean evolved = curPokemon.train(1); // Train with one opponent at a time
            if (evolved) {
                // Evolve and immediately continue training the new evolution with the remaining opponents
                curPokemon = curPokemon.evolve();
            }
        }
        // Set the potentially evolved Pokemon back to the party
        pokemonInParty.set(userNumber - 1, curPokemon);
    }

    public boolean SwapParty () {
        Scanner scanner = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            printParty();
            printPC();

            // Prompt user for action to perform on the Pokemon party
            System.out.println("Choose an action:\n1. Drop off a Pokémon to PC\n2. Pick up a Pokémon from PC\n3. Swap Pokémon between Party and PC");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // case for drop off
                    initializeDropOff(scanner);
                    break;
                case 2: // case for pickup
                    initializePickUp(scanner);
                    break;
                case 3: // case for swap
                    initializeSwap(scanner);
                    break;
                default:
                    System.out.println("Invalid action selected.");
                    continue;
            }
            System.out.println("Do you want to continue swapping? (yes/no)");
            String cont = scanner.next().toLowerCase();
            if (cont.equals("no")) {
                done = true;
            }
        }
        return true;
    }

    void initializeDropOff(Scanner scanner){
        System.out.println("Select a Pokémon to drop off:");
        int dropIndex = scanner.nextInt() - 1;
        // Validate the user's selection and perform the drop-off
        if (dropIndex >= 0 && dropIndex < pokemonInParty.size()) {
            String pokemon = pokemonInParty.get(dropIndex).getClass().getSimpleName();
            pokemonInPC.add(pokemonInParty.remove(dropIndex));
            System.out.println(pokemon + " was moved to PC.");
        } else {
            System.out.println("Invalid selection.");
        }
    }
    void initializePickUp(Scanner scanner){
        // Check if the party is full before picking up a new Pokémon
        if(pokemonInParty.size() == 6){
            System.out.println("Your team is at max capacity! Drop off a Pokémon before trying to Add one from the PC.");
        }
        System.out.println("Select a Pokémon to pick up:");
        int pickIndex = scanner.nextInt() - 1;
        if (pickIndex >= 0 && pickIndex < pokemonInPC.size()) {
            String pokemon = pokemonInPC.get(pickIndex).getClass().getSimpleName();
            pokemonInParty.add(pokemonInPC.remove(pickIndex));
            System.out.println(pokemon + " was added to Party.");
        } else {
            System.out.println("Invalid selection.");
        }
    }
    void initializeSwap(Scanner scanner){
        // Prompt user to select a Pokémon from the party to swap
        System.out.println("Select a Pokémon from Party to swap:");
        int partyIndex = scanner.nextInt() - 1;
        System.out.println("Select a Pokémon from PC to swap:");
        int pcIndex = scanner.nextInt() - 1;
        if (partyIndex >= 0 && partyIndex < pokemonInParty.size() && pcIndex >= 0 && pcIndex < pokemonInPC.size()) {
            Pokemon temp = pokemonInParty.get(partyIndex);
            pokemonInParty.set(partyIndex, pokemonInPC.get(pcIndex));
            pokemonInPC.set(pcIndex, temp);
            System.out.println("Pokémon swapped.");
        } else {
            System.out.println("Invalid selection.");
        }
    }

    public void printParty(){
        // Build and print the current party list with details
        StringBuilder partyString = new StringBuilder();
        partyString.append(name).append("'s Party: \n");
        int idx = 1;
        for (Pokemon nextPokemon : pokemonInParty) {
            partyString.append(idx)
                    .append(". ")
                    .append(nextPokemon.getClass().getSimpleName())
                    .append(" (Lvl ")
                    .append(nextPokemon.getLevel())
                    .append(")  \n");
            idx++;
        }
        System.out.println(partyString);
    }

    public void printPC(){
        StringBuilder pcString = new StringBuilder();
        pcString.append("Pokémon in PC: \n ");
        int idx = 1;
        for (Pokemon nextPokemon : pokemonInPC) {
            pcString.append(idx)
                    .append(". ")
                    .append(nextPokemon.getClass().getSimpleName())
                    .append(" (Lvl ")
                    .append(nextPokemon.getLevel())
                    .append(")  \n");
            idx++;
        }
        System.out.println(pcString);
    }
}

