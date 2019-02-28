import java.util.Arrays;

public class Photo {

    private long id;
    private Orientation orientation;
    private String[] tags;

    public Photo(long id, Orientation orientation, String[] tags) {
        this.id = id;
        this.orientation = orientation;
        this.tags = tags;
    }

    public long getId() {
        return id;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public String[] getTags() {
        return tags;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }


    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", orientation=" + orientation +
                ", tags=" + Arrays.toString(tags) +
                '}';
    }
}

