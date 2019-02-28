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
        scanner.nextLine();

        int id = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            Orientation orientation = split[0].equals("H") ? Orientation.HORIZONTAL : Orientation.VERTICAL;

            String[] tags = new String[Integer.parseInt(split[1])];
            if (tags.length >= 0) System.arraycopy(split, 2, tags, 0, tags.length);

            photos[id] = new Photo(id, orientation, tags);
            id++;
        }
        scanner.close();

        return photos;
    }
}
