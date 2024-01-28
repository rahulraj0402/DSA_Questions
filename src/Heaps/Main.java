package Heaps;

public class Main {

    public static void main(String[] args) throws Exception{
        Heap<Integer> heap = new Heap<>();
        heap.insert(10);
        heap.insert(90);
        heap.insert(2);
        heap.insert(57);
        heap.insert(7);

        System.out.println( heap.remove());

    }


}
