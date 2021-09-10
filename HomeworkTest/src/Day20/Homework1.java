package Day20;

public class Homework1 {
    public static void main(String[] args) {
        Weapon tank = new Tank(); //多态
        tank.attack();
        tank.move();

        Weapon flighter = new Flighter();
        flighter.attack();
        flighter.move();

        Weapon warship = new WarShip();
        warship.attack();
        warship.move();
//        System.out.println(warship.toString());
    }
}
abstract class Weapon{
    public abstract void attack();

    public abstract void move();
}

class Tank extends Weapon{
    public void attack(){
        System.out.println("发射炮弹！！！");
    }
    public void move(){
        System.out.println("坦克移动！！！");
    }
}
class Flighter extends Weapon{
    public void attack(){
        System.out.println("发射飞行炮弹！！！");
    }
    public void move(){
        System.out.println("飞行移动！！！");
    }
}
class WarShip extends Weapon{

    public void attack(){
        System.out.println("军阀发射炮弹！！！");
    }
    public void move(){
        System.out.println("军舰移动！！！");
    }
}