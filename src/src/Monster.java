import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable {

    private String name;

    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public List<String> write() {
        List<String> s = new ArrayList<>();
        s.add(name);
        s.add(String.valueOf(hitPoints));
        s.add(String.valueOf(strength));
        return s;
    }

    @Override
    public void read(List<String> s) {
        if (s == null || s.size() == 0) {
            return;
        }
        name = s.get(0);
        hitPoints = Integer.parseInt(s.get(1));
        strength = Integer.parseInt(s.get(2));
    }

    @Override
    public String toString() {
        return "Monster{name='"+name+"',hitPoints="+hitPoints+",strength"+strength+"}";
    }
}
