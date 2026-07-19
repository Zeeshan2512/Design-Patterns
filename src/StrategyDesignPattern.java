interface WalkableRobot{
    void walk();
}

class NormalWalk implements WalkableRobot{
    @Override
    public void walk(){
        System.out.println("Walking Normally..");
    }
}
class NoWalk implements WalkableRobot{
    @Override
    public void walk(){
        System.out.println("Cannot Walk.");
    }
}


interface TalkableRobot{
    void talk();
}

class NormalTalk implements TalkableRobot{
    @Override
    public void talk() {
        System.out.println("Talking Normally..");
    }
}
class NoTalk implements TalkableRobot{
    @Override
    public void talk() {
        System.out.println("Cannot talk");
    }
}

interface FlyableRobot{
    void fly();
}

class NormalFly implements FlyableRobot{
    @Override
    public void fly() {
        System.out.println("Flying normally...");
    }
}
class NoFly implements FlyableRobot{
    @Override
    public void fly() {
        System.out.println("Cannot Fly.");
    }
}

abstract class Robot{
    protected WalkableRobot walkBehavior;
    protected TalkableRobot talkBehavior;
    protected FlyableRobot flyBehavior;

    public Robot(WalkableRobot w, TalkableRobot t, FlyableRobot f){
        this.walkBehavior = w;
        this.talkBehavior = t;
        this.flyBehavior = f;
    }
    public void walk(){
        walkBehavior.walk();
    }
    public void talk(){
        talkBehavior.talk();
    }
    public void fly(){
        flyBehavior.fly();
    }

    public  abstract void projection();
}

class CompanionRobot extends Robot{
    public CompanionRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        super(w, t, f);
    }

    @Override
    public void projection() {
        System.out.println("Display friendly companion features");
    }
}

class WorkerRobot extends Robot{
    public WorkerRobot(WalkableRobot w, TalkableRobot t, FlyableRobot f) {
        super(w, t, f);
    }

    @Override
    public void projection() {
        System.out.println("Displaying worker efficiency stats...");
    }
}
public class StrategyDesignPattern {
    public static void main(String[] args){
        Robot r1 = new CompanionRobot(new NormalWalk(), new NormalTalk(), new NoFly());
        r1.talk();;
        r1.walk();
        r1.fly();

        System.out.println("-------------------------");

        Robot r2 = new WorkerRobot(new NoWalk(), new NoTalk(), new NormalFly());
        r2.talk();
        r2.walk();
        r2.fly();
    }
}
