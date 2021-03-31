package proxy.v3;

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
        System.out.println("Tank move ...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Tank2().move();
    }
}
//用继承来记录时间
class Tank2 extends Tank{
    @Override
    public void move(){
        long start = System.currentTimeMillis();
        super.move();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}

interface Movable{
    void move();
}