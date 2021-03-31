package factory.method;

public class CarFactory {
    public Moveable create(){
        System.out.println("创建一个Car类");
        return new Car();
    }
}
