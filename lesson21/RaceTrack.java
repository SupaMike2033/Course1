package lesson21;

public class RaceTrack {
    private int lenght;

    public RaceTrack(int lenght) {
        this.lenght = lenght;
    }
    public RaceTrack() {
        this(0);
    }

    public boolean isOvercome(Object racer) {
        if (racer instanceof Human) {
            return (lenght <= ((Human) racer).getDistance());
        } else if (racer instanceof Pussy) {
            return (lenght <= ((Pussy) racer).getDistance());
        } else {
            return (lenght <= ((Robot) racer).getDistance());
        }
    }

    public void Info() {
        System.out.println("Выложили Беговую дорожку = " + lenght);
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }
}
