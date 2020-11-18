package lesson16;

public class Cat extends Animal {

    /*protected int distRun, distSwim;
    protected float distJump;
    protected String name;*/

    public Cat() {
        super(Const.CAT_MAX_RUN, Const.CAT_MAX_JUMP, Const.CAT_MAX_SWIM);
    }

    public void printCatInfo() {

        System.out.println("Оперативная сводка: кошка " + getName() + " нагадила и отбежала на " + getRunDist() + "м, "
                + ((getJumpDist() < 0) ? "не смогла даже подпрыгнуть" : ("подпрыгнув на " + getJumpDist() + "м"))
                + " , поплыла и утонула, т.к. плавать не умеет");
    }

    @Override
    public void toRun(int distance){
        if(distance > Const.CAT_MAX_RUN)
            System.out.print("Пыталась, но не добежала: ");
        super.toRun(distance);
    }
    public void toRun(){
        super.toRun(getRunDist());
    }

    @Override
    public void toJump(float distance){
        if(distance > Const.CAT_MAX_JUMP)
            System.out.print("Пыталась, но не допрыгнула: ");
        super.toJump(distance);
    }
    public void toJump(){
        super.toJump(getJumpDist());
    }

    @Override
    public void toSwim(int distance){
        System.out.print("Кошки вообще не умеют плавать!");
    }
    public void toSwim(){
        super.toSwim(getSwimDist());
    }


}
