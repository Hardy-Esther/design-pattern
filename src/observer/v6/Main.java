package observer.v6;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}

interface Observer{
    void actionOnWakeUp(WakeUpEvent event);
}

//事件类 fire Event
class WakeUpEvent{
    long timestamp;
    String loc;
    //观察源对象
    Child source;
    public WakeUpEvent(long timestamp,String loc,Child source){
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }
}

class Child{
    private boolean cry = false;
    //观察者的列表
    private List<Observer> observers = new ArrayList<>();
    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }
    public boolean isCry(){
        return cry;
    }
    public void wakeUp(){
        cry = true;
        WakeUpEvent event = new WakeUpEvent(System.currentTimeMillis(),"night",this);
        for (Observer o : observers){
            o.actionOnWakeUp(event);
        }
    }
}

class Dad implements Observer{
    public void feed(){
        System.out.println("dad feed ...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        feed();
    }
}

class Mum implements Observer{
    public void hug(){
        System.out.println("mum hug ...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        hug();
    }
}

class Dog implements Observer{
    public void wang(){
        System.out.println("dog wang ...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        wang();
    }
}