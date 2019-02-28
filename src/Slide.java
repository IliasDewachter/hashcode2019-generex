import java.util.Arrays;

public class Slide {

    private String id;
    private int[] tags;

    public Slide(String id, int[] tags) {
        this.id = id;
        this.tags = tags;
    }

    public int[] getTags() {
        return tags;
    }

    public void setTags(int[] tags) {
        this.tags = tags;
    }


    @Override
    public String toString() {
        return "Slide{" +
                "id=" + id +
                ", tags=" + Arrays.toString(tags) +
                '}';
    }
}

