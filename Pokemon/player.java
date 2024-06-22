public class Player {
    private String name;
    private boolean human;
    private Pokemon[] pokemon;
    private int currentPokemonIndex;
    private boolean hasHealed;

    // DEFAULT CONSTRUCTOR
    public Player() {
        this.name = "Player x";
        this.human = true;
        this.pokemon = new Pokemon[3];
        this.currentPokemonIndex = 0;
        this.hasHealed = false;
    }

    // NON-DEFAULT CONSTRUCTOR
    public Player(String name, boolean human) {
        this.name = name;
        this.human = human;
        this.pokemon = new Pokemon[3];
        this.currentPokemonIndex = 0;
        this.hasHealed = false;
    }

    // GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHuman() {
        return human;
    }

    public void setHuman(boolean human) {
        this.human = human;
    }

    public Pokemon[] getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon[] pokemon) {
        this.pokemon = pokemon;
    }

    //OVERRIODES
    public String toString() {
        String result = "Player: " + name + " is human: " + human + " current pokemon: " + getCurrentPokemon() + " current pokemon id: " + currentPokemonIndex + " has healed: " + hasHealed;
        return result;
    }
    //METHOD TO ADD POKEMON TO THE PLAYER OBJECT
    public void addPokemon(Pokemon pokemon) {
        for (int i = 0; i < this.pokemon.length; i++) {
            if (this.pokemon[i] == null) {
                this.pokemon[i] = pokemon;
                break;
            }
        }
    }
    //HELPER METHOD FOR WHEN A POKEMON DIES OR IS SWAPPED
    public void removePokemon(int index) {
        if (index >= 0 && index < this.pokemon.length) {
            this.pokemon[index] = null;
        }
    }
    //METHOD TO SWAP POKEMON IF "SWAP" IS CHOSEN OR THE AI "CHOOSES" TO DO THIS
    public void selectPokemon(int index) {
        if (index >= 0 && index < this.pokemon.length && this.pokemon[index] != null) {
            this.currentPokemonIndex = index;
        }
    }
    //ESSENTIALLY ANOTHER GETTER METHOD FO RTHE INDEX
    public Pokemon getCurrentPokemon() {
        return this.pokemon[currentPokemonIndex];
    }
    //METHOD TO DETERMINE END OF GAME LOGIC: IS THERE ANY PKM LEFT...
    public boolean hasPokemonLeft() {
        for (Pokemon p : this.pokemon) {
            if (p != null && p.getHealth() > 0) {
                return true;
            }
        }
        return false;
    }
    //METHOD TO HELP THE HEAL METHOD ENSURE THEY HAVENT HEALED ALREADY
    public boolean canHeal() {
        return !hasHealed;
    }
    //USES TO HEAL METHOD WITH LOGIC SO THAT IT CAN ONLY HAPPEN ONCE
    public void healCurrentPokemon() {
        if (!hasHealed) {
            getCurrentPokemon().heal();
            hasHealed = true;
        } else {
            System.out.println(this.name + " has already healed once in this battle and cannot heal again.");
        }
    }
    //JUST BECAUSE ONE PERSON HEALED DOESNT MEAN THE OTHER PERSON, SO ADD METHOD TO RESET
    public void resetHeal() {
        hasHealed = false;
    }
}
