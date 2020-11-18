package lesson21;

public class Human {

    private String name;
    private int distance;
    private int height;

    public Human(String name, int distance, int height) {
        this.name = name;
        this.distance = distance;
        this.height = height;
    }

    public Human() {
        this("", 0, 0);
    }

    public void Info() {
        System.out.println(name + " сумеет:");
        System.out.println("пробежать: " + distance);
        System.out.println("подпрыгнуть: " + height);
        System.out.println("---------------------------");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public int getHeight() {
        return height;
    }
}
