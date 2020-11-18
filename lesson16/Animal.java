package lesson16;

public class Animal implements Creature {

    private String name;
    private int maxRun;
    private float maxJump, distJump;
    private int maxSwim;
    private int distRun, distSwim;

    public Animal(int maxRun, float maxJump, int maxSwim) {
//        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
        this.maxSwim = maxSwim;
//        this.distRun = distRun;
//        this.distJump = distJump;
//        this.distSwim = distSwim;
    }

    @Override
    public void toRun(int distance) {
        System.out.println(getName() + ".run(" + distance + ") = " + (distance <= getMaxRun()));
    }

    @Override
    public void toJump(float distance) {
        System.out.println(getName() + ".jump(" + distance + ") = " + (distance <= getMaxJump()));
    }

    @Override
    public void toSwim(int distance) {
        if(this instanceof Cat) {
            System.out.println(getName() + " плавать не умеет, т.к. кошка");
        } else {
            System.out.println(getName() + ".swim(" + distance + ") = " + (distance <= getMaxSwim()));
        }
    }

    @Override
    public void printInfo() {
        System.out.println(this);           // по умолчанию вызывает метод toString из этого класса, т.к. this
    }
    @Override
    public String toString() {
        return ("Карточка животного:\n-------------------\nИмя = " + name + ";\nпредел бега = " + maxRun + "м;\n" +
                "предел прыгания = " + maxJump + "м\nпредел плавания = " + maxSwim + "м");
    }

    public void setName(String name) {this.name = name;}
    public void setDistRun(int distance) {this.distRun = distance;}
    public void setDistJump(float distance) {this.distJump = distance;}
    public void setDistSwim(int distance) {this.distSwim = distance;}

    @Override
    public String getName() {return name;}

    @Override
    public int getMaxRun() {return maxRun;}
    public int getRunDist() {return distRun;}

    @Override
    public float getMaxJump() {return maxJump;}
    public float getJumpDist() {return distJump;}

    @Override
    public int getMaxSwim() {return maxSwim;}
    public int getSwimDist() {return distSwim;}
}
