package iterator.v5;

public class Main {
    public static void main(String[] args) {
        Collection_<String> list = new LinkedList_<String>();
        for (int i = 0; i < 15; i++) {
            list.add(new String("s"+i));
        }
        System.out.println(list.size());

        Iterator_<String> it = list.iterator();
        while (it.hasNext()){
            Object o = it.next();
            System.out.println(o);
        }

    }
}

interface Collection_<E>{
    void add(E o);
    int size();
    Iterator_<E> iterator();
}

interface Iterator_<E>{
    boolean hasNext();
    E next();
}

class ArrayList_<E> implements Collection_<E>{
    E[] objects = (E[]) new Object[10];
    //objects 中下一个空的位置在哪里，或者说目前容器中有多少个元素
    private int index = 0;
    public void add(E o){
        if (index == objects.length){
            E[] newObjects = (E[])new Object[objects.length*2];
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
    public Iterator_<E> iterator() {
        return new ArrayListIterator<E>();
    }

    private class ArrayListIterator<E> implements Iterator_<E>{
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            if (currentIndex >= index) return false;
            return true;
        }

        @Override
        public E next() {
            E o = (E)objects[currentIndex];
            currentIndex++;
            return o;
        }
    }

}

class LinkedList_<E> implements Collection_<E>{
    Node<E> head = null;
    Node<E> tail = null;
    //目前容器中有多少个元素
    private int size = 0;

    public void add(E o){
        Node<E> n = new Node<E>(o);
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
    public Iterator_<E> iterator() {
        return new LinkedIterator<E>();
    }

    private class LinkedIterator<E> implements Iterator_<E>{
        private Node<E> cur = (Node<E>)head;
        @Override
        public boolean hasNext() {
            if (cur == null){
                return false;
            }
            return true;
        }

        @Override
        public E next() {
            E o = cur.o;
            cur = cur.next;
            return o;
        }
    }

    private class Node<E>{
        private E o;
        Node next;
        public Node(E o){
            this.o = o;
        }
    }
}
