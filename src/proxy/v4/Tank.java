package proxy.v4;

import java.util.Random;

/**
 * 记录坦克的移动时间
 * 使用代理来实现
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
        new TankTimeProxy(new Tank()).move();
    }
}

class TankTimeProxy implements Movable{
    Tank tank;

    public TankTimeProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}

interface Movable{
    void move();
}