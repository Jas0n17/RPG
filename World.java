//package RPG;
import java.util.HashMap;

public class World {
    HashMap<String, Place> map;
    public World() {
        map = new HashMap<>();
    }
    public void addPlace(String name, Place place){
        map.put(name, place);
    }
    public Place getPlace(String placeName)
    {
        return map.get(placeName);
    }
}
