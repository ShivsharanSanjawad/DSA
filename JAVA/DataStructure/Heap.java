// the class Heap<T extends Comparable<T>> is what enables us to use Heap<Integer> . . . in code
// this is a part of OOPS. If you do not know this, then go and check this out first:-
// url:- https://youtu.be/OY2lPr8h93U?si=6VNpwN16-uUaz_xp&t=1050

// we are creating Heaps as our own Data Structure here. Although it is there in Java, we are learning
// thus, this is the best way to understand what all is even going on in the background

import java.util.*;

public class Heap<T extends Comparable<T>>
{
    private ArrayList<T> list;

    public Heap(){
        list=new ArrayList<>();
    }

    private void swap(int first, int second){
        T temp=list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int parent(int index){
        return (index-1)/2;
    }

    private int left(int index){
        return (2*index)+1;
    }

    private int right(int index){
        return (2*index)+2;
    }

    public void insert(int num){
        list.add(list.get(num));
        upheap(list.size()-1);
    }

    private void upheap(int index) {
        if(index == 0) {
            return;
        }
        int p = parent(index);
        if(list.get(index).compareTo(list.get(p)) < 0) {
            swap(index, p);
            upheap(p);
        }
    }

    public T remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from an empty heap!");
        }

        T temp = list.get(0);

        T last = list.remove(list.size() - 1);
        if (!list.isEmpty()) {
            list.set(0, last);
            downheap(0);
        }

        return temp;
    }
    private void downheap(int index) {
        int min = index;
        int left = left(index);
        int right = right(index);

        if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min = left;
        }

        if(right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }

        if(min != index) {
            swap(min, index);
            downheap(min);
        }
    }

    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data = new ArrayList<>();
        while(!list.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }
}
