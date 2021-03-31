package singleton;

public class Mgr05 {
    private static Mgr05 INSTANCE;
    private Mgr05(){}

    public static Mgr05 getInstance(){
        if (INSTANCE == null){
            synchronized (Mgr05.class){
                INSTANCE = new Mgr05();
            }
        }
        return INSTANCE;
    }
}
