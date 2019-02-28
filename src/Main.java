import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Data data = InputReader.readFile("input/a_example.txt");

        for (Slide slide : data.slides) {
            System.out.println(slide);
        }

        System.out.println("===========");

        for (Slide verticalPhoto : data.verticalPhotos) {
            System.out.println(verticalPhoto);
        }
    }
}
