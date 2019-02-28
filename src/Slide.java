import java.util.Arrays;

public class Slide {

    public String id;
    public int[] tags;

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

