package lesson16;

interface Creature {
    public void toRun(int distance);
    public void toJump(float distance);
    public void toSwim(int distance);

    public String toString();

    public void printInfo();
    public String getName();
    public int getMaxRun();
    public float getMaxJump();
    public int getMaxSwim();
}
