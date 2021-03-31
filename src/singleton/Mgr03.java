package singleton;
/**
 * lazy loading 懒汉式
 * 多线程加载时会有问题
 * */
public class Mgr03 {
    private static Mgr03 INSTANCE;

    private Mgr03() {

    }

    public static Mgr03 getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }
}
