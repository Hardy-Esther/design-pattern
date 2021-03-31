package singleton;

public class Mgr04 {
    private static Mgr04 INSTANCE;

    private Mgr04(){}

    public static synchronized Mgr04 getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Mgr04();
        }
        return INSTANCE;
    }
}
