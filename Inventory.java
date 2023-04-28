//package RPG;
import java.util.ArrayList;

public class Inventory {
    private int health;
    ArrayList<Pokemon> pokeDeck;
    ArrayList<Health> medKit;
   

    public Inventory() {
        health = 100;
        pokeDeck = new ArrayList<Pokemon>();
        medKit = new ArrayList<Health>();
        
    }
    public void playerDamaged(int damage) {
        health -= damage;
    }
    public void playerHealed(int heal) {
        health += heal;
    }
    public int getHealth() {
        return health;
    }
    
    public boolean hasDied() {
        if (getHealth() <= 0) {
            return false; //player ded
        }
        else {
            return true; //player liv
        }
    }
    public void addHPkit(int num) {
        for (int i  = 0; i < num; i++) {
            Health bandage = new Health();
            medKit.add(bandage);
        }
    }
    public void showInventory() {
        System.out.println("HP: " + health);
        System.out.print("Pokemon: ");
        for (int i = 0; i < pokeDeck.size(); i++) {
            System.out.print(pokeDeck.get(i).getName() + " ");
            System.out.print("HP: " + pokeDeck.get(i).getHp());
            System.out.print(" BaseAttack: " + pokeDeck.get(i).getbAttack());
            System.out.println(" SpecialAttack: " + pokeDeck.get(i).getbAttack());
        }
        System.out.print("Backpack: ");
        for (int j = 0; j < medKit.size(); j++) {
            System.out.print(medKit.get(j).getName() + " ");
        }
        System.out.println();
    } 
    public void addPoke(Pokemon poke) {
        pokeDeck.add(poke);
    }
    public ArrayList<Health> getMedKit() {
        return medKit;
    }
}
