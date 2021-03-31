package singleton;
/**
 * 双重判断检查
 * */
public class Mgr06 {
    private static Mgr06 INSTANCE;
    private Mgr06(){}
    public static Mgr06 getInstance(){
        if (INSTANCE == null){
            synchronized (Mgr06.class){
                if (INSTANCE == null){
                    INSTANCE = new Mgr06();
                }
            }
        }
        return INSTANCE;
    }
}
