import PokemonClasses.Pokemon;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Trainer {
    String name;
    ArrayList<Pokemon> pokemonInParty = new ArrayList<>();
    ArrayList<Pokemon> pokemonInPC = new ArrayList<>();
    public abstract boolean battle() throws InterruptedException, IOException, ParseException;
    public  abstract boolean catchPokemon();
    public abstract void train(int opponents);
    public abstract boolean SwapParty();

    public boolean checkIfPartyAlive() {
        for (Pokemon pokemon : pokemonInParty) {
            if (!pokemon.isFainted()) {
                return true;
            }
        }
        return false;
    }

    public void printParty() {
    }

    public void printPC() {
    }
}
