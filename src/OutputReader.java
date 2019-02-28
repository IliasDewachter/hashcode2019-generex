import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputReader {
    public static void writeFile(List<Slide> slides) {
        String filename = "output/output.txt";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.append(String.valueOf(slides.size()));
            for (Slide slide : slides) {
                writer.newLine();
                writer.append(slide.id);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
