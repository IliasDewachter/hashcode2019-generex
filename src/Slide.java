public class Slide {
    private int intrest;
    private Photo photo1;
    private Photo photo2;

    public Slide(Photo photo1, Photo photo2) {
        this.photo1 = photo1;
        this.photo2 = photo2;
    }

    public int getIntrest() {
        return intrest;
    }

    public void setIntrest(int intrest) {
        this.intrest = intrest;
    }

    public Photo getPhoto1() {
        return photo1;
    }

    public void setPhoto1(Photo photo1) {
        this.photo1 = photo1;
    }

    public Photo getPhoto2() {
        return photo2;
    }

    public void setPhoto2(Photo photo2) {
        this.photo2 = photo2;
    }

    @Override
    public String toString() {
        if (photo2 == null)
            return String.valueOf(getPhoto1().getId());

        return String.valueOf(getPhoto1().getId()) + " " + String.valueOf(getPhoto2().getId());
    }
}
