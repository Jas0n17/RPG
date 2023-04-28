//package RPG;

public class Pokemon {
    //private field declared
    private String name;
    private int hp;
    private int bAttack;
    private int sAttack;
    //Contructor created
    public Pokemon(String name, int hp, int bAttack, int sAttack) {
        this.name = name;
        this.hp = hp;
        this.bAttack = bAttack;
        this.sAttack = sAttack;
    }
    //Updates bAttack based on increase
    public void incbAttack(int increase) {
        bAttack += increase;
    }
    //Updates sAttack based on increase
    public void incsAttack(int increase) {
        sAttack += increase;
    }
    //Updates hp based on increase
    public void incHp(int increase) {
        hp += increase;
    }
    //Getters
    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }
    public int getbAttack() {
        return bAttack;
    }
    public int getsAttack() {
        return sAttack;
    }
    //Updates hp based on damage
    public void isAttacked(int damage) {
        hp -= damage;
    }
    //Returns Pokemon's status
    public void pokeStatus() {
        System.out.print("HP: ");
        System.out.print(getHp() + " | ");
        System.out.print("Base Attack: ");
        System.out.print(getbAttack() + " | ");
        System.out.print("Special Attack: ");
        System.out.println(getsAttack());
    }
    //Returns Pokemon's image
    public void getPokemon() {
        if (getName().equalsIgnoreCase("charmander")) {
            System.out.println(" ℺ ");
            System.out.println("⌜⌺⌺⎰");
            System.out.println(" ⌋⌋");
        }
        else if (getName().equalsIgnoreCase("squirtle")) {
            System.out.println(" ℺");
            System.out.println("⌜⃀⃀⎝⎝");
            System.out.println(" ⌡⌡");
        }
        else if (getName().equalsIgnoreCase("bulbasaur")) {
            System.out.println(" ⊟⊟⊟⊟");
            System.out.println("℺⊟⊟⊟⊟⊟⎯");
            System.out.println(" ⏌⏌");
        }
        else if (getName().equalsIgnoreCase("mewtwo")) {
            System.out.println("   ∐℺∐");
            System.out.println("◈◈◈ↂↂ ◉◉◉");
            System.out.println("   ↂↂ ⌡");
            System.out.println("   ▟ ▟");
        }

    }
}
