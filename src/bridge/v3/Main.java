package bridge.v3;
/**
 * 用聚合代替继承
 * */
public class Main {
}

class GG{
    public void chase(MM mm){
        Gift g = new WarmGift(new Flower());
        give(mm,g);
    }
    public void give(MM mm,Gift g){
        System.out.println(mm.name);
    }
}

class MM{
    String name;
}


class Book extends GiftImpl{
    String name;
}

class Flower extends GiftImpl{

}

abstract class Gift{
    GiftImpl impl;
}

class GiftImpl{

}

class WildGift extends Gift{
    public WildGift(GiftImpl impl){
        this.impl = impl;
    }
}

class WarmGift extends Gift{
    public WarmGift(GiftImpl impl){
        this.impl = impl;
    }
}
