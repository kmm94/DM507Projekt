/**
 * Created by karim møller(karmo15) and Mads Berggreen(madbe15) on 23-02-2017.
 */
public class PQHeap implements PQ {

    private Element[] elements;
    private final int oneIndex = 1;
    private int counter = oneIndex;
    /**
     * @param maxElements The amount of elements that there is room for in the que
     */
    public PQHeap(int maxElements){
        elements = new Element[maxElements + oneIndex];
    }

    @Override
    public Element extractMin() {
        Element min = elements[1];
        elements[1] = elements[elements.length-1];
        MinHeapify(1);
        return min;
    }

    @Override
    public void insert(Element e) {
        //insert
        elements[elements.length - oneIndex] = e; // insert on last place
        int heapsize = elements.length - oneIndex; // index where the element has bin inserted
        System.out.println(elements[parent(heapsize)]);

        //increase-key
        while ( heapsize > 1 && elements[parent(heapsize)].key < elements[heapsize].key){
            swap(heapsize,parent(heapsize)); //swaps the to elements
            heapsize = parent(heapsize); // sets heapsize to the half
        }
        System.out.println("insertion complete!");
    }

    private void MinHeapify(int i){
        int left = i*2;
        int right = i*2+1;
        int Smallest;
        if(left >= elements.length && elements[left+oneIndex].key < elements[i+oneIndex].key) {
            Smallest = left;
            } else {
            Smallest = i;
        }
        if(right >= elements.length && elements[right+oneIndex].key < elements[Smallest+oneIndex].key){
            Smallest = right;
        }
        if (Smallest != i){
            swap(i, Smallest);
        }
    }

    private void swap(int i, int k) {
        Element temp = elements[i];
        elements[i] = elements[k];
        elements[k] = temp;
    }

    private int parent(int i){
        return i/2;
    }

}
