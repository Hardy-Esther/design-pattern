package iterator.v4;

public class Main {
    public static void main(String[] args) {
        Collection_ list = new LinkedList_();
        for (int i = 0; i < 15; i++) {
            list.add(new String("s"+i));
        }
        System.out.println(list.size());

        Iterator_ it = list.iterator();
        while (it.hasNext()){
            Object o = it.next();
            System.out.println(o);
        }

    }
}

interface Collection_{
    void add(Object o);
    int size();
    Iterator_ iterator();
}

interface Iterator_{
    boolean hasNext();
    Object next();
}

class ArrayList_ implements Collection_{
    Object[] objects = new Object[10];
    //objects 中下一个空的位置在哪里，或者说目前容器中有多少个元素
    private int index = 0;
    public void add(Object o){
        if (index == objects.length){
            Object[] newObjects = new Object[objects.length*2];
            System.arraycopy(objects,0,newObjects,0,objects.length);
            objects = newObjects;
        }
        objects[index] = o;
        index++;
    }
    public int size(){
        return index;
    }

    @Override
    public Iterator_ iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator_{
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            if (currentIndex >= index) return false;
            return true;
        }

        @Override
        public Object next() {
            Object o = objects[currentIndex];
            currentIndex++;
            return o;
        }
    }

}

class LinkedList_ implements Collection_{
    Node head = null;
    Node tail = null;
    //目前容器中有多少个元素
    private int size = 0;

    public void add(Object o){
        Node n = new Node(o);
        n.next = null;
        if (head ==null){
            head = n;
            tail = n;
        }
        tail.next = n;
        tail = n;
        size++;
    }

    public int size(){
        return size;
    }

    @Override
    public Iterator_ iterator() {
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator_{
        private Node cur = head;
        @Override
        public boolean hasNext() {
            if (cur == null){
                return false;
            }
            return true;
        }

        @Override
        public Object next() {
            Object o = cur.o;
            cur = cur.next;
            return o;
        }
    }

    private class Node{
        private Object o;
        Node next;
        public Node(Object o){
            this.o = o;
        }
    }
}
