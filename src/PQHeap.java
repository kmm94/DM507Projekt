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
        Element[] elements = new Element[maxElements+oneIndex];
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
        elements[elements.length-oneIndex] = e;
        int i = elements.length-oneIndex;
        while (i> 1 && elements[parent(i)].key < elements[i].key){
            swap(i,parent(i));
            i=parent(i);
        }
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
        Element temp = elements[i+oneIndex];
        elements[i+oneIndex] = elements[k+oneIndex];
        elements[k+oneIndex] = temp;
    }

    private int parent(int i){
        return i/2;
    }

}
