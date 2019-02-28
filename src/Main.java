public class Main {

    public static void main(String[] args) {
        Photo[] photos = InputReader.readFile("input/a_example.txt");
        for (Photo photo : photos) {
            System.out.println(photo);
        }


    }
}
