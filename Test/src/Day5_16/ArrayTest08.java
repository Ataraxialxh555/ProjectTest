package Day5_16;

public class ArrayTest08 {
    public static void main(String[] args) {
        Animals a1 = new Animals();
        Animals a2 = new Animals();
        Animals[] animals = {a1 ,a2};
        for (int i = 0; i < animals.length; i++) {
            Animals res =animals[i];
            res.move();
        }

        System.out.println("========================");
        Animals[]  animals1 = {new Animals(),new Animals()};
        for (int i = 0; i < animals1.length; i++) {
            Animals res =animals1[i];
            res.move();
        }
        System.out.println("=========================");

        Animals a3 = new Pig();
        Animals a4 = new Pig();
        Animals[] animals2 = {a3,a4};
        for (int i = 0; i < animals2.length; i++) {
            Animals res =animals2[i];
            res.move();
        }

        System.out.println("==================");
        Animals a5 = new Pig();
        Animals a6 = new Bird();
        Animals[] animals3 = {a5,a6};
        for (int i = 0; i < animals3.length; i++) {
            Animals res =animals3[i];
            res.move();

        }
        System.out.println("====================");

        Animals a7 = new Pig();
        Animals a8 = new Bird();
        Animals[] animals4 = {a7,a8};
        for (int i = 0; i < animals4.length; i++) {
            if(animals4[i] instanceof Bird){
                Bird bird = (Bird)animals4[i];
                bird.sing();
            }else if (animals4[i] instanceof Pig ){
                Pig pig = (Pig)animals4[i];
                pig.sleep();
            }
        }
        System.out.println("================");
        Pig pig1 = new Pig();
        People p1 = new People();

        //Animals 数组只能存放子类或本类的对象，不能存放其他的对象进来
//        Animals[] ans = {pig1.p1};
    }
}
class Animals{
    public void move(){
        System.out.println("animals move");
    }
}
class Bird extends Animals{
    public void move(){
        System.out.println("bird fly!!!");
    }
    public void sing(){
        System.out.println(" bird sing  sing !!!" );
    }
}
class Pig extends Animals{
    public void move(){
        System.out.println("pid run run！！！");
    }
    public void sleep(){
        System.out.println("pig sleep!!!!");
    }
}
class People{

}