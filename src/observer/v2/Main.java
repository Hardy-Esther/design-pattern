package observer.v2;

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}

class Child{
    private boolean cry = false;
    private Dad d = new Dad();
    public boolean isCry(){
        return cry;
    }
    public void wakeUp(){
        cry = true;
        d.feed();
    }
}

class Dad{
    public void feed(){
        System.out.println("dad feed ...");
    }
}