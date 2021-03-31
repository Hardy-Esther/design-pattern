package factory.abstract1;
/**
 * 抽象工厂方法：主要是用来生产一族产品
 * */
public class Main {
    public static void main(String[] args) {
        AbstractFactory f = new ModernFactory();

        Vehicle c = f.createVehicle();
        c.go();
        Weapon w = f.createWeapon();
        w.shoot();
        Food b = f.createFood();
        b.eat();
    }
}
