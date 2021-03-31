package factory.method;

public class Main {
    public static void main(String[] args) {
//        Car car = new Car();
//        car.go();
        Moveable m = new CarFactory().create();
        m.go();
    }
}
