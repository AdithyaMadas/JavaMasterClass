import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by dev on 8/12/2015.
 */
public class Location implements Serializable {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    private static final long serialVersionUID = 1l;

    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new LinkedHashMap<String, Integer>();
        this.exits.put("Q", 0);
    }

    public void addExit(String direction, int location) {
        exits.put(direction, location);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new LinkedHashMap<String, Integer>(exits);
    }

    @Override
    public String toString() {
        return description + "\n" + exits;
    }
}
