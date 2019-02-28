import java.util.Arrays;

public class Slide {

    public String id;
    public int[] tags;
    public double percentage = 0.0;

    public Slide(String id, int[] tags) {
        this.id = id;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Slide{" +
                "id='" + id + '\'' +
                ", tags=" + Arrays.toString(tags) +
                '}';
    }
}

