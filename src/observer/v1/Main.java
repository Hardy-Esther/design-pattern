package observer.v1;
/**
 * 面向对象的傻等
 * */
public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        while (!child.isCry()){
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("observer ....");
        }
    }
}

class Child{
    private boolean cry = false;
    public boolean isCry(){
        return cry;
    }
    public void wakeUp(){
        System.out.println("wake Up!");
        cry = true;
    }
}