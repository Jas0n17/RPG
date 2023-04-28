//package RPG;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import javax.swing.text.html.StyleSheet;

import java.util.Random;

public class Battle {
   private boolean winner;
   private String battleName;
   Pokemon userPoke;
   Pokemon npcPoke;
   Inventory inv;
   Scanner scnr;
   

   public Battle(Pokemon userPoke, Pokemon npcPoke, Inventory inv, Scanner scnr, String battleName) {
      this.userPoke = userPoke;
      this.npcPoke = npcPoke;
      this.inv = inv;
      this.scnr = scnr;
      this.battleName = battleName;
   }
   public void battleGround(Scanner scnr) {
      String fileName = String.format("%s_BattleLog.txt", battleName);
      FileOutputStream fileStream = null;
      try {
         fileStream = new FileOutputStream(fileName);
      } catch (FileNotFoundException e){
         System.out.println("Cannot find " + fileName);
      }
      PrintWriter outFS = new PrintWriter(fileStream);

      boolean battleEnd = false;
      int count = 0;
      while(!battleEnd) {
         outFS.println("Wild " + npcPoke.getName() + " VS user's" + userPoke.getName());
         displayPoke(npcPoke);
         displayPoke(userPoke);
         System.out.println("1 for basic attack | 2 for special attack");
         int attack = scnr.nextInt();
         if (attack == 1) {
            System.out.println(userPoke.getName() + " uses a basic attack!");
            System.out.println("Wild " + npcPoke.getName() + " -" + userPoke.getbAttack() + "HP.");
            outFS.println(userPoke.getName() + " uses basic attack!");
            outFS.println("Wild " + npcPoke.getName() + " -" + userPoke.getbAttack() + "HP.");
            npcPoke.isAttacked(userPoke.getbAttack());
         } else {
            if(genRan()) {
               System.out.println(userPoke.getName() + " lands a special attack!");
               System.out.println("Wild " + npcPoke.getName() + " -" + userPoke.getsAttack() + "HP.");
               outFS.println(userPoke.getName() + " lands special attack!");
               outFS.println("Wild " + npcPoke.getName() + " -" + userPoke.getsAttack() + "HP.");
               npcPoke.isAttacked(userPoke.getsAttack());
            } else {
               System.out.println(userPoke.getName() + " attacks missed!");
               outFS.println(userPoke.getName() + " missed its attack!");
            }
         }

         //npc's turn to attack

         if (isEven(count)) {
            System.out.println("Wild " + npcPoke.getName() + " uses a basic attack!");
            System.out.println(userPoke.getName() + " -" + npcPoke.getbAttack() + "HP.");
            outFS.println("Wild " + npcPoke.getName() + " uses a basic attack!");
            outFS.println(userPoke.getName() + " -" + npcPoke.getbAttack() + "HP.");
            userPoke.isAttacked(npcPoke.getbAttack());
         } else {
            if (genRan()) {
               System.out.println("Wild " + npcPoke.getName() + " lands a special attack!");
               System.out.println(userPoke.getName() + " -" + npcPoke.getsAttack() + "HP.");
               outFS.println("Wild " + npcPoke.getName() + " lands a special attack!");
               outFS.println(userPoke.getName() + " -" + npcPoke.getsAttack() + "HP.");
               userPoke.isAttacked(npcPoke.getsAttack());
            } else {
               System.out.println("Wild " + npcPoke.getName() + " attacks missed!");
               outFS.println("Wild " + npcPoke.getName() + " missed its attack!");
            }
         }
         outFS.println("______________________________________");

         //Checks for winners
         
         if (userPoke.getHp() <= 0 || npcPoke.getHp() <= 0) {
            battleEnd = true;
            if (npcPoke.getHp() <= 0) {
               System.out.println("Wild " + npcPoke.getName() + " was defeated. You won!");
               winner = true;
               outFS.println("User has won!");
            } else {
               System.out.println(userPoke.getName() + " fainted!");
               winner = false;
               outFS.println(userPoke.getName() + " fainted!");
            }
         } 
      }
      outFS.close();
   }
   public boolean getWinner() {
      return winner;
   }
   public void displayPoke(Pokemon poke) {
      poke.getPokemon();
      poke.pokeStatus();
   }
   public boolean genRan() {
      Random random = new Random();
      return random.nextBoolean();
   }
   public boolean isEven(int number) {
      return Math.floorMod(number, 2) == 0;
  }

}

