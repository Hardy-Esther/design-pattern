package proxy.v5;

import java.util.Random;

/**
 * 记录坦克的移动时间
 * 使用代理来实现
 * 静态代理
* */
public class Tank implements Movable{
    /**
     * 模拟坦克移动了一段时间
     * */
    @Override
    public void move() {
        System.out.println("Tank move ...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new TankTimeProxy(new TankLogProxy(new Tank())).move();
    }
}

class TankTimeProxy implements Movable{
    Movable m;

    public TankTimeProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        m.move();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}

class TankLogProxy implements Movable{
    Movable m;

    public TankLogProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("start moving ...");
        m.move();
        System.out.println("end moving ...");
    }
}

interface Movable{
    void move();
}