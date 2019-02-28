import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {

    public static Photo[] readFile(String filename) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Photo[] photos = new Photo[scanner.nextInt()];

        int id = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            Orientation orientation = split[0].equals("H") ? Orientation.HORIZONTAL : Orientation.VERTICAL;

            String[] tags = new String[Integer.parseInt(split[1])];
            for (int i = 0; i < tags.length; i++) {
                tags[i] = split[i + 2];
            }

            photos[id] = new Photo(id, orientation, tags);
            id++;
        }
        scanner.close();

        return photos;
    }
}
