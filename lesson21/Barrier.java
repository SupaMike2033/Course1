package lesson21;

public class Barrier {

    private int height;

    public Barrier(int height) {
        this.height = height;
    }

    public Barrier() {
        this(0);
    }

    public boolean isOvercome(Object racer) {
        if (racer instanceof Human) {
            return (height <= ((Human) racer).getHeight());
        } else if (racer instanceof Pussy) {
            return (height <= ((Pussy) racer).getHeight());
        } else {
            return (height <= ((Robot) racer).getHeight());
        }
    }

    public void Info() {
        System.out.println("Выставили Барьер = " + height);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
