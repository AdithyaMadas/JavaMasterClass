import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {

    private String name;
    private String weapon;

    private int hitPoints;
    private int strength;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
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
        s.add(weapon);
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
        weapon = s.get(3);
    }

    @Override
    public String toString() {
        return "Player{name='"+name+"',hitPoints="+hitPoints+",strength"+strength+",weapon='"+weapon+"'}";
    }
}
