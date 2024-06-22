public class PokemonType extends PokemonBase {
    private String type;

    // BASIC DEFAULT CONTSTRUCTOR
    public PokemonType() {
        super();
        this.type = "Normal";
    }

    // NON-DEFAULT CONSTRUCTOR
    public PokemonType(String name, int health, int attack, int defense, int speed, String type) {
        super(name, health, attack, defense, speed);
        this.type = type;
    }

    // GETTERS AND SETTERS
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //OVERIDES
    public String toString() {
        return super.toString() + " Type='" + type + '\'';
    }
    //ADV@NTAGE METHOD WITH EVERY SINGLE TYPE COMBINATION THIS IS MY SOURCE BTW https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRts1qJKGRgX25N6dIzVTY3xklbfujMnl7bhA&s
    public double advantage(PokemonType enemy) {
        if (this.type.equals("Normal")) {
            if (enemy.getType().equals("Rock") || enemy.getType().equals("Steel")) return 0.5;
            if (enemy.getType().equals("Ghost")) return 0.0; //BY 0.0 I MEAN NO EFFECT BECAUSE NORMAL TYPES CANT HIT GHOSTS LOGICALLY, THIS IS ALSO TRUE FOR FIGHTING ATTACKS ON GHOSTS BECAUSE YOU CANT PUNCH A GHOST AND A FEW OTHERS...
        }
        if (this.type.equals("Fire")) {
            if (enemy.getType().equals("Grass") || enemy.getType().equals("Ice") || enemy.getType().equals("Bug") || enemy.getType().equals("Steel")) return 2.0;
            if (enemy.getType().equals("Fire") || enemy.getType().equals("Water") || enemy.getType().equals("Rock") || enemy.getType().equals("Dragon")) return 0.5;
        }
        if (this.type.equals("Water")) {
            if (enemy.getType().equals("Fire") || enemy.getType().equals("Ground") || enemy.getType().equals("Rock")) return 2.0;
            if (enemy.getType().equals("Water") || enemy.getType().equals("Grass") || enemy.getType().equals("Dragon")) return 0.5;
        }
        if (this.type.equals("Electric")) {
            if (enemy.getType().equals("Water") || enemy.getType().equals("Flying")) return 2.0;
            if (enemy.getType().equals("Electric") || enemy.getType().equals("Grass") || enemy.getType().equals("Dragon")) return 0.5;
            if (enemy.getType().equals("Ground")) return 0.0;
        }
        if (this.type.equals("Grass")) {
            if (enemy.getType().equals("Water") || enemy.getType().equals("Ground") || enemy.getType().equals("Rock")) return 2.0;
            if (enemy.getType().equals("Fire") || enemy.getType().equals("Grass") || enemy.getType().equals("Poison") || enemy.getType().equals("Flying") || enemy.getType().equals("Bug") || enemy.getType().equals("Dragon") || enemy.getType().equals("Steel")) return 0.5;
        }
        if (this.type.equals("Ice")) {
            if (enemy.getType().equals("Grass") || enemy.getType().equals("Ground") || enemy.getType().equals("Flying") || enemy.getType().equals("Dragon")) return 2.0;
            if (enemy.getType().equals("Fire") || enemy.getType().equals("Water") || enemy.getType().equals("Ice") || enemy.getType().equals("Steel")) return 0.5;
        }
        if (this.type.equals("Fighting")) {
            if (enemy.getType().equals("Normal") || enemy.getType().equals("Ice") || enemy.getType().equals("Rock") || enemy.getType().equals("Dark") || enemy.getType().equals("Steel")) return 2.0;
            if (enemy.getType().equals("Poison") || enemy.getType().equals("Flying") || enemy.getType().equals("Psychic") || enemy.getType().equals("Bug") || enemy.getType().equals("Fairy")) return 0.5;
            if (enemy.getType().equals("Ghost")) return 0.0;
        }
        if (this.type.equals("Poison")) {
            if (enemy.getType().equals("Grass") || enemy.getType().equals("Fairy")) return 2.0;
            if (enemy.getType().equals("Poison") || enemy.getType().equals("Ground") || enemy.getType().equals("Rock") || enemy.getType().equals("Ghost")) return 0.5;
            if (enemy.getType().equals("Steel")) return 0.0;
        }
        if (this.type.equals("Ground")) {
            if (enemy.getType().equals("Fire") || enemy.getType().equals("Electric") || enemy.getType().equals("Poison") || enemy.getType().equals("Rock") || enemy.getType().equals("Steel")) return 2.0;
            if (enemy.getType().equals("Grass") || enemy.getType().equals("Bug")) return 0.5;
            if (enemy.getType().equals("Flying")) return 0.0;
        }
        if (this.type.equals("Flying")) {
            if (enemy.getType().equals("Grass") || enemy.getType().equals("Fighting") || enemy.getType().equals("Bug")) return 2.0;
            if (enemy.getType().equals("Electric") || enemy.getType().equals("Rock") || enemy.getType().equals("Steel")) return 0.5;
        }
        if (this.type.equals("Psychic")) {
            if (enemy.getType().equals("Fighting") || enemy.getType().equals("Poison")) return 2.0;
            if (enemy.getType().equals("Psychic") || enemy.getType().equals("Steel")) return 0.5;
            if (enemy.getType().equals("Dark")) return 0.0;
        }
        if (this.type.equals("Bug")) {
            if (enemy.getType().equals("Grass") || enemy.getType().equals("Psychic") || enemy.getType().equals("Dark")) return 2.0;
            if (enemy.getType().equals("Fire") || enemy.getType().equals("Fighting") || enemy.getType().equals("Poison") || enemy.getType().equals("Flying") || enemy.getType().equals("Ghost") || enemy.getType().equals("Steel") || enemy.getType().equals("Fairy")) return 0.5;
        }
        if (this.type.equals("Rock")) {
            if (enemy.getType().equals("Fire") || enemy.getType().equals("Ice") || enemy.getType().equals("Flying") || enemy.getType().equals("Bug")) return 2.0;
            if (enemy.getType().equals("Fighting") || enemy.getType().equals("Ground") || enemy.getType().equals("Steel")) return 0.5;
        }
        if (this.type.equals("Ghost")) {
            if (enemy.getType().equals("Psychic") || enemy.getType().equals("Ghost")) return 2.0;
            if (enemy.getType().equals("Dark")) return 0.5;
            if (enemy.getType().equals("Normal")) return 0.0;
        }
        if (this.type.equals("Dragon")) {
            if (enemy.getType().equals("Dragon")) return 2.0;
            if (enemy.getType().equals("Steel")) return 0.5;
            if (enemy.getType().equals("Fairy")) return 0.0;
        }
        if (this.type.equals("Dark")) {
            if (enemy.getType().equals("Psychic") || enemy.getType().equals("Ghost")) return 2.0;
            if (enemy.getType().equals("Fighting") || enemy.getType().equals("Dark") || enemy.getType().equals("Fairy")) return 0.5;
        }
        if (this.type.equals("Steel")) {
            if (enemy.getType().equals("Ice") || enemy.getType().equals("Rock") || enemy.getType().equals("Fairy")) return 2.0;
            if (enemy.getType().equals("Fire") || enemy.getType().equals("Water") || enemy.getType().equals("Electric") || enemy.getType().equals("Steel")) return 0.5;
        }
        if (this.type.equals("Fairy")) {
            if (enemy.getType().equals("Fighting") || enemy.getType().equals("Dragon") || enemy.getType().equals("Dark")) return 2.0;
            if (enemy.getType().equals("Fire") || enemy.getType().equals("Poison") || enemy.getType().equals("Steel")) return 0.5;
        }
        return 1.0;
    }

    // public String effeciency ()


    //OVERIDES
    public int attack(PokemonBase enemy) {
        PokemonType enemyType = (PokemonType) enemy;
        double advantage = this.advantage(enemyType);
        int baseDamage = super.attack(enemy); //fixed !!! on june 16
        int damage = (int) (baseDamage * advantage);
        return damage;
    }
}
