//package RPG;
import java.util.ArrayList;

public class Place {
    String name;
    String description;
    ArrayList<String> exits = new ArrayList<String>();


    public Place(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public void getInfo() {
        System.out.println(name + "\n" + description);
    }
    public void addExit(String exit) {
        exits.add(exit);
    }
    public String listExits() {
        String listExitsString = "Exits: ";
        for (String room : exits) {
            listExitsString += room + " | ";
        }
        return listExitsString;
    }
    public String toString() {
        return listExits();
    }
}
