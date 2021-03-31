package singleton;
/**
 * 用枚举来实现单例，不公可以解决线程同步，还可以防止反序列化
 * */
public enum Mgr08 {
    INSTANCE;
    public void m(){}
}
