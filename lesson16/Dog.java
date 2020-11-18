package lesson16;

public class Dog extends Animal {

    /*protected int distRun, distSwim;
    protected float distJump;
    protected String name;*/

    public Dog() {
        super(Const.DOG_MAX_RUN, Const.DOG_MAX_JUMP, Const.DOG_MAX_SWIM);
    }

    public void printDogInfo() {

        System.out.println("Оперативная сводка: собака " + getName() + " облаяла и отбежала на " + getRunDist() + "м, "
                + ((getJumpDist() < 0) ? "не смогла даже подпрыгнуть" : ("подпрыгнув на " + getJumpDist() + "м"))
                + " и уплыла на " + getSwimDist() + "м");
    }

    @Override
    public void toRun(int distance){
        if(distance > Const.DOG_MAX_RUN)
            System.out.print("Пыталась, но не добежала: ");
        super.toRun(distance);
    }
    public void toRun(){
        super.toRun(getRunDist());

    }

    @Override
    public void toJump(float distance){
        if(distance > Const.DOG_MAX_JUMP)
            System.out.print("Пыталась, но не допрыгнула: ");
        super.toJump(distance);
    }
    public void toJump(){
        super.toJump(getJumpDist());
    }

    @Override
    public void toSwim(int distance){
        if(distance > Const.DOG_MAX_SWIM)
            System.out.print("Пыталась, но утонула: ");
        super.toSwim(distance);
    }
    public void toSwim(){
        super.toSwim(getSwimDist());
    }


}
