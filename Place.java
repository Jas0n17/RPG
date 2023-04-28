//package RPG;
//Packages imported
import java.util.ArrayList;

public class Place {
    //Private field declared
    String name;
    String description;
    ArrayList<String> exits = new ArrayList<String>();
    //Constructor created
    public Place(String name, String description) {
        this.name = name;
        this.description = description;
    }
    //Returns name and its description
    public void getInfo() {
        System.out.println(name + "\n" + description);
    }
    //Adds exit to ArrayList exits
    public void addExit(String exit) {
        exits.add(exit);
    }
    //Returns string type of exit contents
    public String listExits() {
        String listExitsString = "Exits: ";
        for (String room : exits) {
            listExitsString += room + " | ";
        }
        return listExitsString;
    }
    //Converts to String
    public String toString() {
        return listExits();
    }
}
