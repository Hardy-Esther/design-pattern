package factory.method;
/**
 * 简单工厂方法,可扩展性不好
 * */
public class SimpleVehicleFactory {
    public Car CreateCar(){
        //before processing
        return new Car();
    }
    public Plane CreatePlane(){
        return new Plane();
    }
}
