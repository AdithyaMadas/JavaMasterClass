import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    public static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) {
       /* try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("loc.dat")))) {
            for (Location location : locations.values()) {
                locFile.writeInt(location.getLocationID());
                locFile.writeUTF(location.getDescription());
                locFile.writeInt(location.getExits().size() - 1);
                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("q")) {
                        locFile.writeUTF(direction);
                        locFile.writeInt(location.getExits().get(direction));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try (ObjectOutputStream loc = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("locSerial.dat")))) {
            for (Location location : locations.values()) {
                loc.writeObject(location);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {

        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locSerial.dat")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Location location = (Location) locFile.readObject();
//                    System.out.println("LocationID " + location.getLocationID() + "\t Desc: " + location.getDescription());
                    locations.put(location.getLocationID(), location);
                } catch (EOFException e) {
                    eof = true;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /*try (DataInputStream locFile = new DataInputStream(new BufferedInputStream(new FileInputStream("loc.dat")))) {
            boolean eof = false;
            while (!eof) {
                try{

                    int locID = locFile.readInt();
                    String desc = locFile.readUTF();
                    Location location = new Location(locID, desc);
                    int nExits = locFile.readInt();
                    while (nExits-- > 0) {
                        String direction = locFile.readUTF();
                        int exit = locFile.readInt();
                        location.addExit(direction, exit);
                    }
                    locations.put(locID, location);
                } catch (IOException e) {
                    eof=true;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try (Scanner sc = new Scanner(new BufferedReader(new FileReader("locations_big.txt")))) {
            sc.useDelimiter(",");
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] blocks = line.split(",");
                int loc = Integer.parseInt(blocks[0]);
                String desc = blocks[1];
                locations.put(loc, new Location(loc, desc));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader("directions_big.txt")))) {
            scanner.useDelimiter(",");
            while(scanner.hasNextLine()) {
                String input = scanner.nextLine();
                if (input.equals("")) {
                    continue;
                }
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
    }


    @Override
    public int size() {

        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
