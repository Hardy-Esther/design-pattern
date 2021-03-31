package state.v1;

public class Main {
}
//根据状态不同，做出不同的反应就可以用state模式
class MM{
    String name;
    private enum MMState{HAPPY,SAD}

    MMState state;

    public void smile(){
        //switch case
    }

    public void cry(){
        //switch case
    }
    public void say(){
        //switch case
    }
}