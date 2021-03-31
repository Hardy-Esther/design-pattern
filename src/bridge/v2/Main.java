package bridge.v2;

public class Main {
}

class GG{
    public void chase(MM mm){
        Gift g = new Book();
        give(mm,g);
    }
    public void give(MM mm,Gift g){
        System.out.println(mm.name);
    }
}

class MM{
    String name;
}

abstract class Gift{

}

class Book extends Gift{
    String name;
}

class Flower extends Gift{

}

class WildGift extends Gift{

}

class WarmGift extends Gift{

}
