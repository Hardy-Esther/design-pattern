package strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cat[] a = {new Cat(1, 2), new Cat(2, 3)};
        Sorter<Cat> sorter = new Sorter<Cat>();
        //Dog[] a = {new Dog(7),new Dog(3),new Dog(5)};
        //Sorter<Dog> sorter = new Sorter<Dog>();
        sorter.sort(a, (o1, o2) -> {
            if (o1.weight > o2.weight) return 1;
            else if(o1.weight < o2.weight) return -1;
            return 0;
        });
        System.out.println(Arrays.toString(a));
    }
}
