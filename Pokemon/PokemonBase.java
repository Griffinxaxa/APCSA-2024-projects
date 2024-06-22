public class PokemonBase {
    private String name;
    private int health;
    private int attack;
    private int defense;
    private int speed;
    private boolean hasHealed; //added this on june 16th

    // BASIC DEFAULT CONSTRUCTOR 
    public PokemonBase() {
        this.name = "Pikachu";
        this.health = 10;
        this.attack = 10;
        this.defense = 10;
        this.speed = 10;
        this.hasHealed = false; //added this on june 16th
    }

    // NON-DEFAULT CONSTRIUCTOR
    public PokemonBase(String name, int health, int attack, int defense, int speed) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.hasHealed = false;
    }

    // GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed() {
        this.speed = speed;
    }

    //TOSTRING METHOD OVERIDES
    public String toString() {
        return "Pokemon " +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", defense=" + defense +
                ", speed=" + speed;
    }

    public int attack(PokemonBase enemy) {
        int damage = (int) (Math.random() * (this.attack - enemy.getDefense())) + 1;
        if (damage < 0) damage = 1;
        System.out.println(this.name + " attacks " + enemy.getName() + " doing an initial " + damage + " damage."); // fixed ! !! ! on june 16
        return damage;
    }

    public void damage(int damageAmt) {
        this.health -= damageAmt;
        if (this.health < 0) {
            this.health = 0;
        }
        if (this.health == 0) {
            System.out.println(this.name + " is down!");
        } else {
            System.out.println(this.name + " has " + this.health + " health left.");
        }
    }

    public int heal() {
        if (hasHealed) {
            System.out.println(this.name + " cannot heal again");
            return 0;
        }
        int healAmount = Math.min(20, 100 - this.health);
        this.health += healAmount;
        this.hasHealed = true;
        System.out.println(this.name + " has healed " + healAmount + " points.");
        System.out.println(this.name + " has " + this.health + " health left.");
        return healAmount;
    }
}
