package observer.v3;
/**
 * 加入多个观察者
* */
public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}

class Child{
    private boolean cry = false;
    private Dad d = new Dad();
    private Mum m = new Mum();
    private Dog g = new Dog();
    public boolean isCry(){
        return cry;
    }
    public void wakeUp(){
        cry = true;
        d.feed();
        m.hug();
        g.wang();
    }
}

class Dad{
    public void feed(){
        System.out.println("dad feed ...");
    }
}

class Mum{
    public void hug(){
        System.out.println("mum hug ...");
    }
}

class Dog{
    public void wang(){
        System.out.println("dog wang ...");
    }
}