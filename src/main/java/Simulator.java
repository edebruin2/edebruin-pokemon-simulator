import PokemonClasses.*;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Simulator {
    public static void main(String[] args) throws InterruptedException, IOException, ParseException {
        boolean playing = true;
        Scanner scanner = new Scanner(System.in);
        User_Trainer user = becomeTrainer(scanner);

        while(playing) {
            System.out.println("------------------");
            user.printParty();
            user.printPC();

            System.out.println("""
                    What would you like to do:
                    (1) Train your Pokémon
                    (2) Catch new Pokémon
                    (3) Swap party members from your PC
                    (4) Battle a trainer
                    (5) Get info on a Pokémon in your party.
                    (6) Quit the game""");
            int userOption = scanner.nextInt();
            switch (userOption) {
                case 1:
                    System.out.println("How many Pokémon do you want to fight?");
                    int levelIncrease = scanner.nextInt();
                    user.train(levelIncrease);
                    break;
                case 2:
                    user.catchPokemon();
                    break;
                case 3:
                    user.SwapParty();
                    break;
                case 4:
                    user.battle();
                    resetTeam(user);
                    break;
                case 5:
                    System.out.println("Which Pokémon would you like more info on?");
                    user.printParty();
                    int pokemonSelection = scanner.nextInt();
                    if (pokemonSelection > 0 && pokemonSelection <= user.pokemonInParty.size()) {
                        Pokemon curPokemon = user.pokemonInParty.get(pokemonSelection - 1);
                        curPokemon.printAllInfo();
                    } else {
                        System.out.println("The input you provided is not one of the available Pokémon");
                    }
                    break;
                case 6:
                    System.out.println("Your progress will NOT be saved, do you still want to exit? (y/n)");
                    String exitGame = scanner.next();
                    if (exitGame.equalsIgnoreCase("y")) {
                        playing = false;
                        break;
                    } else if (exitGame.equalsIgnoreCase("n")) {
                        break;
                    }
                default:
                    System.out.println("Please make sure you are inputting valid responses.");
            }
        }
    }

    static User_Trainer becomeTrainer(Scanner scanner) throws InterruptedException {

        System.out.println("""
                             -=+=-
                Welcome to your Pokémon adventure!
                             -=+=-
                             
                """);
        TimeUnit.SECONDS.sleep(3);

        System.out.println("Please start by telling us your name! \n");
        String trainerName = scanner.next();
        User_Trainer user = new User_Trainer(trainerName);
        System.out.println("We're so excited for you to start your Pokémon journey, " + trainerName + "!\n");
        TimeUnit.SECONDS.sleep(2);

        System.out.println("""
                Now for the fun part: Picking your first Pokémon!
                
                Please select one of the following Pokémon:
                (1) Pikachu, the Mouse Pokémon. Electric Type.
                (2) Bulbasaur, the Seed Pokémon. Grass/Poison Type.
                (3) Charmander, the Lizard Pokémon. Fire Type.
                (4) Squirtle, the Tiny Turtle Pokémon. Water Type.
                """);
        boolean validSelection = false;
        while (!validSelection) {
            int pokemonChoice = scanner.nextInt();
            switch (pokemonChoice) {
                case 1:
                    System.out.println("\nYou picked Pikachu! An electrifying choice!");
                    TimeUnit.SECONDS.sleep(2);
                    validSelection = true;
                    user.pokemonInParty.add(new Pikachu(5, new ArrayList<>(), new ArrayList<>()));
                    break;
                case 2:
                    System.out.println("\nYou picked Bulbasaur! Let's see how you grow!");
                    TimeUnit.SECONDS.sleep(2);
                    validSelection = true;
                    user.pokemonInParty.add(new Bulbasaur(5, new ArrayList<>(), new ArrayList<>()));
                    break;
                case 3:
                    System.out.println("\nYou picked Charmander! Things are heating up!");
                    TimeUnit.SECONDS.sleep(2);
                    user.pokemonInParty.add(new Charmander(5, new ArrayList<>(), new ArrayList<>()));
                    validSelection = true;
                    break;
                case 4:
                    System.out.println("\nYou picked Squirtle! This is going swimmingly already!");
                    TimeUnit.SECONDS.sleep(2);
                    user.pokemonInParty.add(new Squirtle(5, new ArrayList<>(), new ArrayList<>()));
                    validSelection = true;
                    break;
                default:
                    System.out.println("Uh-oh. Looks like that wasn't a valid choice" +
                            "\nPlease make a valid Pokémon selection using the numbers next to the name of the Pokémon.");
            }
            TimeUnit.SECONDS.sleep(2);
        }
        System.out.println("""

                Get ready. Your Pokémon journey has just begun. You are now free to\s
                - Catch new Pokémon,\s
                - Train up your team,\s
                - And Battle your way to the top...\s
                to become the very best!
                
                """);
        TimeUnit.SECONDS.sleep(5);
        return user;
    }
    public static void resetTeam(Trainer trainer) {
        for(int i = 0; i < trainer.pokemonInParty.size(); i++){
            Pokemon pokemon = trainer.pokemonInParty.get(i);
            pokemon.calculateStats();
        }
    }
}
