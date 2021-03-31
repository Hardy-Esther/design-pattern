package observer.v4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        child.wakeUp();
    }
}

interface Observer{
    void actionOnWakeUp();
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
        for (Observer o : observers){
            o.actionOnWakeUp();
        }
    }
}

class Dad implements Observer{
    public void feed(){
        System.out.println("dad feed ...");
    }

    @Override
    public void actionOnWakeUp() {
        feed();
    }
}

class Mum implements Observer{
    public void hug(){
        System.out.println("mum hug ...");
    }

    @Override
    public void actionOnWakeUp() {
        hug();
    }
}

class Dog implements Observer{
    public void wang(){
        System.out.println("dog wang ...");
    }

    @Override
    public void actionOnWakeUp() {
        wang();
    }
}