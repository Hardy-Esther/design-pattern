package strategy;

public class Sorter<T> {
    public void sort(T[] ints,Comparator<T> comparator){
        for (int i = 0; i < ints.length; i++) {
            int minPos = i;
            for (int j = i+1; j < ints.length;j++){
                minPos = comparator.compare(ints[j],ints[minPos]) < 0 ? j : minPos;
            }
            swap(ints,i,minPos);
        }
    }
    void swap(T[] ints,int i, int j){
        T temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }
}
