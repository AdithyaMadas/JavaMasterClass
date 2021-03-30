import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {

    public static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new FileReader("locations.txt"))) {
            sc.useDelimiter(",");
            while (sc.hasNextLine()) {
                int loc = sc.nextInt();
                sc.skip(sc.delimiter());
                String desc = sc.nextLine();
                locations.put(loc, new Location(loc, desc));
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("directions.txt")));
            scanner.useDelimiter(",");
            while(scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String direction = scanner.next();
//                scanner.skip(scanner.delimiter());
//                String dest = scanner.nextLine();
//                int destination = Integer.parseInt(dest);
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
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(scanner != null) {
                scanner.close();
            }
        }


        System.out.println(locations);
    }
}
