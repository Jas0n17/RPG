//package RPG;

public class Health {
    //private field declared
    private String name;
    private int bandage;
    //Contructor Health created
    public Health() {
        bandage = 20;
        name = "Bandage";
    }
    //Returns name
    public String getName() {
        return name;
    }
    //Returns value assigned to Bandage
    public int getBandage() {
        return bandage;
    }

}
