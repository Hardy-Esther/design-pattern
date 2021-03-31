package proxy.v2;

import java.util.Random;
/**
 * 记录坦克的移动时间
* */
public class Tank implements Movable{
    /**
     * 模拟坦克移动了一段时间
     * */
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("Tank move ...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void main(String[] args) {
        new Tank().move();
    }
}

interface Movable{
    void move();
}