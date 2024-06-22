public class Pokemon extends PokemonType {
    private double critChance;

    // DEFAULT CONSTRUCTOR
    public Pokemon() {
        super();
        this.critChance = 0.1;
    }

    // NON DEFAULT CONSTRUCTOR 
    public Pokemon(String name, int health, int attack, int defense, int speed, String type, double critChance) {
        super(name, health, attack, defense, speed, type);
        this.critChance = critChance;
    }

    // GETTERS AND SETTERS
    public double getCritChance() {
        return critChance;
    }

    public void setCritChance(double critChance) {
        this.critChance = critChance;
    }

    //OVERIDE OTHER TOSTRING
    public String toString() {
        return super.toString() + " critChance=" + critChance;
    }

    //OVERIDE OTHER ATTACK
    public int attack(PokemonBase enemy) {
        int baseDamage = super.attack(enemy);
        int damage = baseDamage; //fixed !!
        // IF A RANDOM NO IS LESS THAN THE SPECIFIC POKEMONS CRIT FIELD THEN CRIT OCCURS AND DAMAGE IS DOUBLED 
        if (Math.random() < this.critChance) {
            damage *= 2;
            System.out.println(this.getName() + " has scored a critical hit! Damage increased");
        }
        enemy.damage(damage);
        return damage;
    }
}
