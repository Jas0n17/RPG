//package RPG;

public class Pokemon {
    private String name;
    private int hp;
    private int bAttack;
    private int sAttack;
  
    public Pokemon(String name, int hp, int bAttack, int sAttack) {
        this.name = name;
        this.hp = hp;
        this.bAttack = bAttack;
        this.sAttack = sAttack;
    }

    public void incbAttack(int increase) {
        bAttack += increase;
    }
    public void incsAttack(int increase) {
        sAttack += increase;
    }
    public void incHp(int increase) {
        hp += increase;
    }
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

    public void isAttacked(int damage) {
        hp -= damage;
    }
    
    public void pokeStatus() {
        System.out.print("HP: ");
        System.out.print(getHp() + " | ");
        System.out.print("Base Attack: ");
        System.out.print(getbAttack() + " | ");
        System.out.print("Special Attack: ");
        System.out.println(getsAttack());
    }
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
