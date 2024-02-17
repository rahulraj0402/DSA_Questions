package Heaps;
import java.util.ArrayList;

// this we are making as generic type
public class  Heap<T extends Comparable<T>> {

    private ArrayList<T> list;

    public Heap() {
       list = new ArrayList<>();
    }

    private int parent(int index){
        return (index - 1) / 2;
    }
    private int left(int index){
        return index * 2 + 1;
    }
    private int right(int index){
        return index * 2 + 2;
    }

    public void insert(T value){
        // add the element at last
        // and start checking its parent according to conditions ( max heap | min heap
        list.add(value);
        // since we have to check the last value added
        // and compare till above
        upheap(list.size()-1);

    }

    private void upheap(int index){
        // if you came to index == 0 , that means program is over
        if (index == 0 ){
            return;
        }
        int p = parent(index);
        // if the current item is smaller then parent then swap
        if (list.get(index).compareTo(list.get(p)) < 0){
            // if this condition is satisfied means we have to swap the current index and parent
            swap(index , p);
            // now after swapping check for above (parent)  for that call the upheap meathod again
            upheap(p);
        }
    }


    // this can throw exception since from empty list we cant remove
    public T remove() throws Exception{
        if (list.isEmpty()){
            throw new Exception("removing from an empty Heap !!");
        }

        // remove the item at the 0th index
        // and place the last item at 0th index
        // and check down this time according ro condition
        T temp = list.get(0);

        T last = list.remove(list.size()-1);

        if (!list.isEmpty()){
            list.set(0 , last);
            downheap(0);
        }


        return temp;
    }

    private void downheap(int index){
        int min = index;
        int left = left(index);
        int right = right(index);

        // check if left exist
        // check is left > currentMIN
        if (left < list.size() && list.get(min).compareTo(list.get(left)) > 0){
            min = left;
        }
        // check for right
        if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0){
            min = right;
        }
        if (min != index){
            swap(min , index);
            // calll downheap
            downheap(min);
        }
    }

    // this is for heap sort
    public ArrayList<T> heapSort() throws Exception{
        ArrayList<T> data = new ArrayList<>();
        while (!list.isEmpty()){
            data.add(this.remove());
        }

        return data;
    }


    // make a swap function
    private void swap(int first , int second){
        T temp = list.get(first);
        list.set(first , list.get(second));
        list.set(second , temp);
    }
}
