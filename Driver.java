// package RPG;
import java.util.Scanner;
import java.util.HashMap;
import java.util.InputMismatchException;

import javax.swing.plaf.TreeUI;
import javax.xml.crypto.Data;

import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("You and your best friend are playing pokemon on the Nintendo DS (Enter to continue)");
        scnr.nextLine();
        System.out.println("Friend: Bro I wish we could enter the Pokemon world, that would be so awesome. What do you think?");
        scnr.nextLine();
        System.out.println("(Yes) to agree with friend | (No) to disagree with friend");
        String enter = scnr.next();
        if (enter.equalsIgnoreCase("yes")){
            System.out.println("You: Yea man that sounds like a rad idea! But what starter pokemon would you choose?");
            scnr.nextLine();
            System.out.println("Friend: I would totally go for a fire type! Charmander of course!");
            scnr.nextLine();
        } else {
            System.out.println("You: Naw bro, that sounds so stupid. You should touch grass sometimes. But what starter pokemon would you choose tho?");
            scnr.nextLine();
            System.out.println("Friend: That was kinda mean. But I would choose a fire type, probably Charmander");
            scnr.nextLine();
        }
        System.out.println("Friend: Anyways what pokemon would you choose?");
        Pokemon poke  = chooseStarterPokemon(scnr);
    
        System.out.println("Mom: Hey boys dinner is ready!!! (Enter to continue)");
        scnr.nextLine();
        System.out.println("(You and your friend have dinner and he goes home.)");
        scnr.nextLine();
        System.out.println("(Now it is just you and your thoughts...)");
        scnr.nextLine();
        System.out.println("(Your eyelid feels heavy, and you begin to drift into the darkness.)");
        scnr.nextLine();
        System.out.println(".....\n.....\n.....\n");
        scnr.nextLine();
        System.out.println("You're falling...");
        scnr.nextLine();
        System.out.println("You feel like you're falling.\n.....\n....\n...\n..\n.");
        scnr.nextLine();
        makeText("*THUD*", scnr);
        makeText("Strange man: Woah, hello there fellow traveler!\nDo you happen to be lost?", scnr);
        profOak();
        makeText("Welcome to the world of pokemons!", scnr);
        if(enter.equalsIgnoreCase("yes")) {
            makeText("You were talking about pokemons earlier, you seemed very enthusiastic!\nMy name is professor Oak.", scnr);
        } else {
            makeText("You were talking about pokemons eariler you didn't seem to like pokemons very much, well, I am here to prove you wrong!\nMy name is professor Oak.", scnr);
        }

        //______//
        World hash = new World();
        Place spawnPoint = new Place(">SpawnPoint<", "This is a place of home. You'll be safe here. For now-");
        spawnPoint.addExit("n");
        Place jungle = new Place("{Jungle}", "Lookout! Unexpected things happen here! It is also damp and warm and full of pretators. The thick air fills your lungs.");
        jungle.addExit("n");
        jungle.addExit("e");
        jungle.addExit("s");
        jungle.addExit("w");
        Place arctic = new Place("*Arctic*", "Brrr its cold here, did anyone bring a jacket? The stinging wind and ice whips your body ferociously!");
        arctic.addExit("e");
        Place desert = new Place("#Desert#", "The scorching sun blazes across your forehead, you would kill for some water.");
        desert.addExit("w");
        Place bossRoom = new Place("|~| Mysterious Dungeon |~|", "You here psychic screams robotic growls inside. Your spine tremors at the thought of entering. Your lungs feel sharp and your breath gets shorter...");
        bossRoom.addExit("s");
        hash.addPlace("SpawnPoint", spawnPoint);
        hash.addPlace("Jungle", jungle);
        hash.addPlace("Arctic", arctic);
        hash.addPlace("Desert", desert);
        hash.addPlace("Dungeon", bossRoom);
        //______//
        
        String choice = "";
        Inventory inv = new Inventory();
        
        System.out.println("Professor Oak: Here is your starter pokemon, " + poke.getName() + ", don't ask me how I knew.");
        poke.getPokemon();
        scnr.nextLine();
        inv.addPoke(poke);
        System.out.println("Well traveler, you are one your own. Goodluck!");
        scnr.nextLine();
        

        //-------//
        hash.getPlace("SpawnPoint").getInfo();
        printMenu();
        choice = scnr.next();
        printMenuv2(choice, inv);
        choice = scnr.next();
        while (!choice.equals("n")) {
            System.out.println("You can only go North from here!");
            choice = scnr.next();
        }
        while (!choice.equals("q")) {
            if (choice.equals("n")) {
                hash.getPlace("Jungle").getInfo();
                makeText("You take -10Hp.", scnr);
                inv.playerDamaged(10);
                if(!inv.hasDied()) {
                    System.out.println("You Died.");
                    System.exit(0);
                }
                System.out.println("You hear rustling under some bushes...Check it out(Yes/No)");
                String bushesCheck = scnr.next();
                if (bushesCheck.equalsIgnoreCase("No")) {
                    System.out.println("You go towards another direction and continue through the jungle. " + poke.getName() + " gets hungry and you feed him some berries found along the trees.");
                    scnr.nextLine();
                    System.out.println("Coming across an abandoned hut, you find 2 bandages in a nearby table. (Bandages heal 20HP.)");
                    inv.addHPkit(2);
                    scnr.nextLine();
                }
                else {
                    Pokemon npcBulb = new Pokemon("Bulbasaur", 80, 20, 50);
                    makeText("A wild Bulbasaur appeared!\nRunning is not an option >:)", scnr);
                    makeText("Bulbasaur: Bulba-Bul-Bulbasaur!!!", scnr);
                    System.out.println("Your pokeball twitches. It seems like " + poke.getName() + " is iching for a battle!\nA Battle In The Jungle Commences!");
                    scnr.nextLine();
                    Battle jungleBattle = new Battle(poke, npcBulb, inv, scnr, "JungleBattle");
                    jungleBattle.battleGround(scnr);
                    if (jungleBattle.getWinner()) {
                        System.out.println(poke.getName() + " leveled up!\n+50 HP\n+5 BaseAttack\n+10 SpecialAttack");
                        poke.incHp(50);
                        poke.incbAttack(5);
                        poke.incsAttack(10);
                        System.out.print("You obtained 3 bandages!\nHow many bandages would you like to use on your pokemon? (Bandages heal 20hp)\n");
                        int bandage = scnr.nextInt();
                        while (bandage < 0 || bandage > 3) {
                            System.out.println("Input a number between 0 and 3 dummy.");
                        }
                        for (int i = 0; i < bandage; i++) {
                            poke.incHp(20);
                        }
                        inv.addHPkit(3 - bandage);
                    } else {
                        makeText("You Died.", scnr);
                        choice = "q";
                    }
                }
                makeText("While wandering around you try to find a way out, however, you contantly feel like you are being watched", scnr);
                System.out.println("You feel an ominous presence around you. Every cell of your body is screaming escape.");
                scnr.nextLine();
                System.out.println(hash.getPlace("Jungle").listExits());
                choice = scnr.next();
                while(!choice.equals("n") && !choice.equals("e") && !choice.equals("s") && !choice.equals("w")) {
                    System.out.println("Enter a valid input!");
                    System.out.println(hash.getPlace("Jungle").listExits());
                    choice = scnr.next();
                }
                if (choice.equals("n")) {
                    choice = "death";
                }

            }
            else if (choice.equals("e")) {
                hash.getPlace("Desert").getInfo();
                makeText("You take -10Hp.", scnr);
                inv.playerDamaged(10);
                if(!inv.hasDied()) {
                    System.out.println("You Died.");
                    System.exit(0);
                }
                makeText("In the distance you see a large dragon-like creature. Upon a closer look, it is a Charizard, the ruler of the desert.", scnr);
                makeText("You: It has a strange stone on the end of its tail, it looks valuable, maybe if I defeat it. I can use that stone.", scnr);
                Pokemon charizard = new Pokemon("Charmander", 200, 30, 70);
                System.out.println("Battle Charizard?(Yes/No)");
                String charbattle = scnr.next();
                if (charbattle.equalsIgnoreCase("no")) {
                    makeText("You decide to go the other way, back towards the jungle.", scnr);
                    makeText("Along the way, you find 2 bandages.", scnr);
                    inv.addHPkit(2);
                    choice = "n";
                } else {
                    makeText("You approach the Charizard, it notices you and goes airborne into the sky. *WHOOSH*", scnr);
                    makeText("The giant lizard lands infront of you. *THUUD*", scnr);
                    charizard.getPokemon();
                    makeText("Charizard: *ROOOAARRRR*", scnr);
                    makeText("You alright big guy, lets do this!\nA Showdown Under the Sun!", scnr);
                    Battle desertBattle = new Battle(poke, charizard, inv, scnr, "DesertBattle");
                    desertBattle.battleGround(scnr);
                    if (desertBattle.getWinner()) {
                        makeText("The lifeless lizard lay motionless on the sand.", scnr);
                        makeText("Charizard: rrrhrrrh", scnr);
                        makeText("You grab the strange stone from the end of its stiff tail.\nSuddenly, your pokemon leaps from your side and swallows the stone.", scnr);
                        System.out.println("The stone seems to have given " + poke.getName() + " a powerup!\n" + poke.getName() + " leveled up!\n+125 HP\n+10 BaseAttack\n+15 SpecialAttack");
                        poke.incHp(125);
                        poke.incbAttack(10);
                        poke.incsAttack(15);
                        makeText("You make your way back to the jungle.", scnr);
                        choice = "n";
                    } else {
                        makeText("You Died", scnr);
                        choice = "q";
                    }
                }
            }
            else if (choice.equals("w")){
                hash.getPlace("Arctic").getInfo();
                makeText("You take -10Hp.", scnr);
                inv.playerDamaged(10);
                if(!inv.hasDied()) {
                    System.out.println("You Died.");
                    System.exit(0);
                }
                makeText("In the icy wind you can see a large black rectangular building in the distance. It appears to be an area.", scnr);
                makeText("You approach and enter the area, the room is well lit with empty stadiums.\nIn the middle occupies a open field, it appears to be a Pokemon battle field. A man stands on the opposite end of the field.", scnr);
                makeText("Trainer: You must be here to test your abilities, step to the plate. We shall battle.", scnr);
                System.out.println("You: Bring it! " + poke.getName() + " I choose you!");
                scnr.nextLine();
                System.out.println("Trainer: Squirtle, I choose you!");
                Pokemon squirtle = new Pokemon("Squirtle", 150, 25, 35);
                System.out.println("An Arctic Faceoff Ensues!");
                Battle arcticBattle = new Battle(poke, squirtle, inv, scnr, "ArcticBattle");
                arcticBattle.battleGround(scnr);
                if (arcticBattle.getWinner()) {
                    System.out.println(poke.getName() + " leveled up!\n+60 HP\n+5 BaseAttack\n+5 Special Attack");
                    poke.incHp(60);
                    poke.incbAttack(5);
                    poke.incsAttack(5);
                    makeText("Trainer: You've defeated me...", scnr);
                    makeText("Trainer: I want to help you on your journey. Here is a potion that will make your Pokemon a bit stronger", scnr);
                    makeText("You thank the trainer and you shake hands.", scnr);
                    poke.getPokemon();
                    System.out.println("~~~~~\n ~~~ \n  ~   \n" + poke.getName() + " consumed the potion!\n+30 HP\n+5 SpecialAttack");
                    poke.incHp(30);
                    poke.incsAttack(5);
                    makeText("You turn back to the jungle. Wondering what await you.", scnr);
                    choice = "n";
                } else {
                    System.out.println(poke.getName() + " lies flat before you, on the verge of death. You run up to it and hold it in your arms.");
                    scnr.nextLine();
                    System.out.println("You: NOOOO, don't die on me buddy!");
                    scnr.nextLine();
                    System.out.println("The trainer walks up to you and your pokemon.");
                    scnr.nextLine();
                    System.out.println("Trainer: Here are some herbs, you can revive " + poke.getName() + " and bring it back to full capacity.\n+100 HP");
                    scnr.nextLine();
                    poke.incHp(100);
                    makeText("You: Thank you! How can I repay you for this?", scnr);
                    makeText("Trainer: Well I got a few chores around here...", scnr);
                    System.out.println("You and " + poke.getName() + " swept the arena, dusted the benches, and cleaned the bathroom toilets made of ice.");
                    scnr.nextLine();
                    System.out.println("You: Hmm, I wonder how they he poops.");
                    scnr.nextLine();
                    makeText("You: Anyways, I'm all done!", scnr);
                    makeText("The trainer is no where to be found, so you head back to the jungle.", scnr);
                    choice = "n";
                }
            }
            else if (choice.equalsIgnoreCase("death")) {
                makeText("You choose to go north...", scnr);
                makeText("The air thickens...", scnr);
                makeText("You can't help but feel like something is watching you.", scnr);
                hash.getPlace("Dungeon").getInfo();
                makeText("It's not too late to turn back...", scnr);
                System.out.println("Turnback?(Yes/No)");
                choice = scnr.next();
                if (choice.equalsIgnoreCase("Yes")) {
                    choice = "n";
                } else {
                    makeText("/As you get closer to the gate, loud stomping and echoed screams can be heard./", scnr);
                    makeText("/You hands shake as you attempt to open the large steel doors./", scnr);
                    makeText("The scream and stomping suddenly stops.\nYou peer inside the large room and see torches line the walls of the dungeon and a giant circle occupying the center of the room.", scnr);
                    makeText("You step closer...", scnr);
                    makeText("Closer...", scnr);
                    makeText("\n\n      ...\n   ...\n...       \n\n", scnr);
                    makeText("* BLING *\n\n* WHOOSH *\n\n* BOOOOM *", scnr);
                    makeText("Chains break loose from above and a giant humunoid creature surrounded by a purple arua stand before you.", scnr);
                    Pokemon mewtwo = new Pokemon("Mewtwo", 300, 80, 150);
                    mewtwo.getPokemon();
                    System.out.println("Mewtwo: ~Those steel doors stay SHUT for a reason. Prepare to die!~\nHow should you respond?\nSarcastic(1)\nApologetic(2)\nDefensive(3)");
                    int dAnswer = scnr.nextInt();
                    while(dAnswer != 1 && dAnswer != 2 && dAnswer != 3) {
                        System.out.println("Mewtwo: ~You have to enter a number between 1 and 3.~ *Faceplam*\nEnter your choice (1/2/3)");
                        dAnswer = scnr.nextInt();
                    }
                    if(dAnswer == 1) {
                        makeText("You: Oh no, I'm shaking in my pants...I could totally make a rug out you! ", scnr);
                        makeText("Mewtwo: *Raises hand readying an attack*", scnr);
                    }
                    else if (dAnswer == 2) {
                        makeText("You: Please don't hurt me! I was only here out of curiosity!", scnr);
                        makeText("Mewtwo: *Raises hand readying an attack*", scnr);

                    }
                    else {
                        makeText("You: I'm here to kill you. Nothing more. Nothing less.", scnr);
                        makeText("Mewtwo: *Raises hand readying an attack*", scnr);
                    }
                    System.out.println("You quickly leap backwards. " + poke.getName() + " I choose you!");
                    poke.getPokemon();
                    scnr.nextLine();
                    System.out.println("The Final Showdown! Who will win?");
                    scnr.nextLine();
                    Battle finalBattle = new Battle(poke, mewtwo, inv, scnr, "FinalBattle");
                    finalBattle.battleGround(scnr);
                    if (finalBattle.getWinner()) {
                        //user wins
                    } else {
                        makeText("You Died.", scnr);
                        choice = "q";
                    }
                   
                    
                }
            }
            else if(choice.equals("s")) {
                hash.getPlace("SpawnPoint").getInfo();
                printMenuv3();
                choice = scnr.next();
                while(!choice.equals("i") && !choice.equals("c") && !choice.equals("q")) {
                    System.out.println("Select i/c/q");
                    choice = scnr.next();
                }
                if (choice.equals("i")) {
                    while(choice.equals("i")) {
                        inv.showInventory();
                        System.out.println("_______________________\nHeal yourself(1)\nHeal " + poke.getName() + "(2)");
                        int heal = scnr.nextInt();
                        if (heal == 1) {
                            makeText("You decided to heal youself.", scnr);
                            System.out.println("How many bandages would you like to use?\n(You have " + inv.getMedKit().size() + " bandages.)");
                            heal = scnr.nextInt();
                            while (heal > inv.getMedKit().size()) {
                                System.out.println("You have " + inv.getMedKit().size() + " bandages.\nChoose a correct input.");
                                heal = scnr.nextInt();
                            }
                            for (int i = 0; i < inv.getMedKit().size(); i++) {
                                inv.playerHealed(20);
                                inv.getMedKit().remove(0);
                            }
                        } else {
                            makeText("You decided to heal your pokemon.", scnr);
                            System.out.println("How many bandages would you like to use?\n(You have " + inv.getMedKit().size() + " bandages.)");
                            heal = scnr.nextInt();
                            while (heal > inv.getMedKit().size()) {
                                System.out.println("You have " + inv.getMedKit().size() + " bandages.\nChoose a correct input.");
                                heal = scnr.nextInt();
                            }
                            for (int i = 0; i < inv.getMedKit().size(); i++) {
                                poke.incHp(20);
                                inv.getMedKit().remove(0);
                            }
                        }
                        printMenuv3();
                        choice = scnr.next();
                    }
                }
                else if (choice.equals("c")) {
                    makeText("You have decided to continue your journey back to the jungle.", scnr);
                    choice = "n";
                }
                else {
                    choice = "q";
                }
            }
            else {
                choice = "q";
            }
        }
        makeText("*Ring* \n      *Ring*\n            *Ring*", scnr);
        makeText("You turn your alarm off and sit up on your bed.", scnr);
        makeText("You: That was a pretty weird dream.", scnr);
        makeText("You: Anyways, I got school today.", scnr);
        makeText("You forgot about the dream and continued on with life.", scnr);
        makeText("The End. Thanks for playing.\nBy: Jason L", scnr);
        scnr.close();
    }
    



    public static int genRanNum() {
        Random rand = new Random();
        return rand.nextInt(10) + 1;
    }
    public static void profOak() {
        System.out.println("   ,#####,");
        System.out.println(" _||_____||_");
        System.out.println("(|  O   O  |)");
        System.out.println(" (|   <   |)");
        System.out.println("   \\_~~~_/ ");
    }
    public static void makeText(String text, Scanner scnr) {
        System.out.println(text);
        scnr.nextLine();
    }
    public static Pokemon chooseStarterPokemon(Scanner scanner) {
        System.out.println("Choose your starter Pokemon (1/2/3/)");
        System.out.println("1. Charmander");
        System.out.println("2. Squirtle");
        System.out.println("3. Bulbasaur");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        switch (choice) {
            case 1:
                return new Pokemon("Charmander", 100, 25, 35);
            case 2:
                return new Pokemon("Squirtle", 110, 15, 45);
            case 3:
                return new Pokemon("Bulbasaur", 90, 8, 55);
            default:
                System.out.println("Invalid choice. Please try again.");
                return chooseStarterPokemon(scanner); // Recursively call the method until a valid choice is made
        }
    }
    public static void printMenu() {
        System.out.println("i - Inventory");
        System.out.println("a - Action");
        System.out.println("q - Wakeup");
    }
    public static void printMenuv2(String choice, Inventory inv) {
        System.out.println("__________________________");
        if (choice.equalsIgnoreCase("i")) {
            System.out.println(">Inventory<");
            System.out.println(" _________ ");
            inv.showInventory();
            printMenu();
        }
        else if (choice.equalsIgnoreCase("a")) {
            System.out.println("m - Move");
        }
        else if (choice.equalsIgnoreCase("q")) {
            System.out.println("You have decided to wake up.");
        }
        else {
            System.out.println("Invalid input buddy. ");
        }
    }
    public static void printMenuv3() {
        System.out.println("i - Inventory");
        System.out.println("c - Continue journey (Jungle)");
        System.out.println("q - Wakeup");
    }
}

