package proxy.v6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * 记录坦克的移动时间
 * 动态代理
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
        Tank tank = new Tank();
        //反射(reflection) 通过二进制字节码分析类的属性和方法
        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Movable.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("method "+ method.getName()+" start ...");
                Object o = method.invoke(tank,args);
                System.out.println("method "+ method.getName()+" end ...");
                return o;
            }
        });
        m.move();
    }
}

interface Movable{
    void move();
}