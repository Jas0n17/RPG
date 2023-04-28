//package RPG;
//Imported packages
import java.util.ArrayList;

public class Inventory {
    //Private field declared
    private int health;
    ArrayList<Pokemon> pokeDeck;
    ArrayList<Health> medKit;
    //Inventory constructor declared
    public Inventory() {
        health = 100;
        pokeDeck = new ArrayList<Pokemon>();
        medKit = new ArrayList<Health>();
    }
    //Updates health based on damage
    public void playerDamaged(int damage) {
        health -= damage;
    }
    //Updates health based on heal
    public void playerHealed(int heal) {
        health += heal;
    }
    //Returns Health's value
    public int getHealth() {
        return health;
    }
    //Returns false if health is less than 1
    public boolean hasDied() {
        if (getHealth() <= 0) {
            return false; //player ded
        }
        else {
            return true; //player liv
        }
    }
    //Adds num amount of Health objects to ArrayList medKit
    public void addHPkit(int num) {
        for (int i  = 0; i < num; i++) {
            Health bandage = new Health();
            medKit.add(bandage);
        }
    }
    //Displays inventory
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
    //Adds Pokemon object to ArrayList pokeDeck
    public void addPoke(Pokemon poke) {
        pokeDeck.add(poke);
    }
    //Adds Health object to ArrayList Health
    public ArrayList<Health> getMedKit() {
        return medKit;
    }
}
