import java.util.Scanner;

public class BattleGround {
    private Player[] players;
    private int currentPlayerIndex;
    private Scanner scanner;

    // DEFAULT CONSTRUCTOR (ALWAYS DEFAULT FOR THIS CLASS)
    public BattleGround() {
        this.players = new Player[2]; //2 PLAYERS AUTOMATICALLY OFCOURSE
        this.currentPlayerIndex = 0;
        this.scanner = new Scanner(System.in);
    }

    // GETTERS AND SETTERS
    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    public Player getOpponent() {
        return players[1 - currentPlayerIndex];
    }

    public void setNextPlayer() {
        currentPlayerIndex = 1 - currentPlayerIndex;
    }
    

    public void fight() {
        //OPENING BATTLE QUESTIONSL
        System.out.print("Enter name for player 1: ");
        String player1Name = scanner.nextLine(); //PROMPT NAME
        Player player1 = new Player(player1Name, true);
        players[0] = player1;

        System.out.print("Enter name for player 2 (or 'CPU' for computer): ");
        String player2Name = scanner.nextLine();
        Player player2 = new Player(player2Name, !player2Name.equalsIgnoreCase("CPU"));
        players[1] = player2;


        addPokemonToPlayer(player1);
        addPokemonToPlayer(player2);

        // GAME LOOP
        while (player1.hasPokemonLeft() && player2.hasPokemonLeft()) {
            System.out.println("\n" + getCurrentPlayer().getName() + "'s turn.");
            if (getCurrentPlayer().isHuman()) {
                handleHumanTurn();
            } else { //LOGIC FO R  TURN HANDLING BETWEEN PLAYERS
                handleComputerTurn();
            }
            setNextPlayer();
        }

        if (player1.hasPokemonLeft()) {
            System.out.println(player1.getName() + " wins");
        } else {
            System.out.println(player2.getName() + " wins");
        }
    }

    private void addPokemonToPlayer(Player player) {
        // METHOD TO HARDCODE PPOKEON TO PLAYERS
        if (player.isHuman()) {
            player.addPokemon(new Pokemon("Gabite", 74, 20, 10, 10, "Dragon", 0.1));
            player.addPokemon(new Pokemon("Lokix", 59, 15, 12, 10, "Bug", 0.2));
            player.addPokemon(new Pokemon("Hitmonchan", 77, 36, 8, 10, "Fighting", 0.15));
        } else {
            player.addPokemon(new Pokemon("Klinklang", 80, 22, 8, 10, "Steel", 0.2));
            player.addPokemon(new Pokemon("Zeraora", 100, 20, 10, 10,"Electric", 0.1));
            player.addPokemon(new Pokemon("Azumarill", 90, 16, 12, 10, "Fairy", 0.25));
        } 
    }
    //HANDLES LOGIC FOR WHEN IT IS A HUMANS TURN
    private void handleHumanTurn() {
        Player player = getCurrentPlayer();
        System.out.print("Choose your action: [attack], [heal], [swap], [stats]: ");
        String action = scanner.nextLine().toLowerCase(); // DETERMINE WHAT THEY WANT TO DO 

        //THE LOGIC FOR THE CHOSEN MOVE, IF CONDITIONAL LOGIC USED
        if (action.equals("attack")) {
            player.getCurrentPokemon().attack(getOpponent().getCurrentPokemon());
        } else if (action.equals("heal")) {
            // MAKING SURE THAT HE HASNT ALREADY HEALED
            if (player.canHeal()) {
                player.healCurrentPokemon();
            } else {
                System.out.println("You have already used your heal for this battle.");
            }
        } else if (action.equals("swap")) {
            System.out.print("Select Pokemon index to swap: [0,1,2] ");
            int index = scanner.nextInt();
            scanner.nextLine(); 
            player.selectPokemon(index);
        } else if (action.equals("stats")) {
            System.out.println(player);
            handleHumanTurn(); 
            return; 
        } else {
            System.out.println("Invalid action. Try again.");
            handleHumanTurn(); 
            return; 
        }

        if (getOpponent().getCurrentPokemon().getHealth() == 0) {
            System.out.println(getOpponent().getName() + ", your Pokemon is down. Choose another.");
            System.out.print("Select Pokemon index to swap: ");
            int index = scanner.nextInt();
            scanner.nextLine(); 
            getOpponent().selectPokemon(index);
        }
    }
    //HANDLES LOGIC FOR WHEN IT IS A CPUS TURN
    private void handleComputerTurn() {
        Player player = getCurrentPlayer();
        double choice = Math.random();
        if (choice < 0.8) { //80% change to fight
            player.getCurrentPokemon().attack(getOpponent().getCurrentPokemon());
        } else if (choice < 0.9) { //10% chance to heal
            if (player.canHeal()) {
                player.healCurrentPokemon();
            } else {
                handleComputerTurn(); // IF HEAL IS NOT POSSIBLE REDO IT UNTIL IT DOES SMTH VALID
            }
        } else { // 10% chance to swap to random index
            int index = (int) (Math.random() * player.getPokemon().length);
            player.selectPokemon(index);
        }

        if (getOpponent().getCurrentPokemon().getHealth() == 0) {
            int index;
            do {
                index = (int) (Math.random() * getOpponent().getPokemon().length);
            } while (getOpponent().getPokemon()[index] == null || getOpponent().getPokemon()[index].getHealth() == 0);
            getOpponent().selectPokemon(index); // NULLIFY INDEX IF PKM IS DEAD
        }
    }
}
