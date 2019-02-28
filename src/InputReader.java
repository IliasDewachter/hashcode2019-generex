import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class InputReader {

    public static Data readFile(String filename) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Data data = new Data();

        int tagId = 0;

        data.slides = new ArrayList<>();

        scanner.nextLine();

        int id = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");

            int[] tags = new int[Integer.parseInt(split[1])];
            for (int i = 0; i < tags.length; i++) {
                String tag = split[i+2];
                int t = data.tagHashMap.getOrDefault(tag, -1);
                if (t == -1) t = tagId++;
                tags[i] = t;
                data.tagHashMap.put(tag, t);

                int tagCountt = data.tagCount.getOrDefault(t, 0);
                data.tagCount.put(t, ++tagCountt);
            }

            if (split[0].equals("V")) {
                data.verticalPhotos.add(new Slide("" + id, tags));
            } else {
                data.slides.add(new Slide("" + id, tags));
            }
            id++;
        }
        scanner.close();

        return data;
    }
}
