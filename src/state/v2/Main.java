package state.v2;

public class Main {
    public static void main(String[] args) {
        MM m = new MM("MM",new MMHappyState());
        m.smile();
    }
}
//把状态抽象出来
abstract class MMState{
    abstract public void smile();
    abstract public void cry();
    abstract public void say();
}

class MM{
    String name;
    MMState state;

    public MM(String name, MMState state) {
        this.name = name;
        this.state = state;
    }

    public void smile(){
        state.smile();
    }
    public void cry(){
        state.cry();
    }
    public void say(){
        state.say();
    }
}

class MMHappyState extends MMState{

    @Override
    public void smile() {
        System.out.println("happy smile");
    }

    @Override
    public void cry() {
        System.out.println("happy cry");
    }

    @Override
    public void say() {
        System.out.println("happy say");
    }
}

