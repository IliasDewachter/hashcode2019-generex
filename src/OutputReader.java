import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputReader {
    public static void writeFile(Slide[] slides) {
        String filename = "output/output.txt";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.append(String.valueOf(slides.length));
            for (Slide slide : slides) {
                writer.newLine();
                writer.append(slide.toString());
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
