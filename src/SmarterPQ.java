import java.util.Arrays;
/**
    Class to is an item of queue
 */
class entry{
    int key;
    int value;
    public entry(int key, int value){
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString(){
        return "Key: "+key+" Value: "+value;
    }
}
/**
    Class to implement Smarter Priority Queue
 */
public class SmarterPQ {
    /**
        @param heap The heap array
        @param size The size of heap
        @param isMinHeap The flag to check if min heap or max heap
     */
    private entry[] heap;
    private int size;
    private boolean isMinHeap;

    /**
        Constructor of SmarterPQ
     */
    public SmarterPQ() {
        heap = new entry[10];
        size = 0;
        this.isMinHeap = true; //Always start as min heap
    }
    /**
        Function to toggle between min heap and max heap
     */
    public void toggle(){
        isMinHeap = !isMinHeap;
        if(!isMinHeap){
            //Convert to max heap
            for(int i = size/2-1;i>=0;i--){
                maxHeapify(i);
            }
        }else{
            //Convert to min heap
            for(int i = size/2-1;i>=0;i--){
                minHeapify(i);
            }
        }
    }

    /**
        Function to remove top element
     */
    public entry removeTop(){
        if(size == 0){
            System.out.println("Heap is empty");
            return null;
        }
        entry temp = heap[0];
        heap[0] = heap[size-1];
        size--;
        if(isMinHeap){
            minHeapify(0);
        }else{
            maxHeapify(0);
        }
        return temp;
    }

    /**
        Function to insert element
        @param key The key of element
        @param value The value of element
     */
    public void insert(int key, int value){
        if(size == heap.length){
            heap = Arrays.copyOf(heap, 2* heap.length); //EXPANDING ARRAY
        }
        heap[size] = new entry(key, value);
        size++;
        int i = size-1;
        sorting(i);
    }

    /**
        Function to sort the heap
        @param i The index of element
     */
    private void sorting(int i) {
        if(isMinHeap){
            //MIN HEAP
            while(i > 0 && heap[parent(i)].key > heap[i].key){
                swap(i,parent(i));
                i = parent(i);
            }
        }else{
            //MAX HEAP
            while(i > 0 && heap[parent(i)].key < heap[i].key){
                swap(i,parent(i));
                i = parent(i);
            }
        }
    }

    /**
        Function to get top element
     */
    public entry top(){
        if(size == 0){
            System.out.println("SPQ is empty");
            return null;
        }
        return heap[0];
    }

    /**
        Function to remove specific entry
        @param key The key of element
     */
    public entry remove(int key){
        int index = -1;
        for(int i = 0;i<size;i++){
            if(heap[i].key == key){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("Key not found");
            return null;
        }
        entry temp = heap[index];
        heap[index] = heap[size-1];
        size--;
        if(isMinHeap){
            minHeapify(index);
        }else{
            maxHeapify(index);
        }
        return temp;
    }

    /**
        Function to replace key
        @param key The key of element
        @param newKey The new key of element
     */
    public void replaceKey(int key, int newKey){
        for(int i = 0;i<size;i++){
            if(heap[i].key == key){
                heap[i].key = newKey;
                sorting(i);
                break;
            }
        }
    }

    /**
        Function to replace value
        @param key The key of element
        @param newValue The new value of element
     */
    public void replaceValue(int key, int newValue){
        for(int i = 0;i<size;i++){
            if(heap[i].key == key){
                heap[i].value = newValue;
                break;
            }
        }
    }

    /**
        Function to get state of heap (Min Heap or Max Heap)
     */
    public String state(){
        return isMinHeap ? "Min Heap" : "Max Heap";
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    /**
        Function to min heapify
        @param i The index of element
     */
    private void minHeapify(int i){
        int l = leftChild(i);
        int r = rightChild(i);
        int smallest = i;
        if(l<size && heap[l].key < heap[smallest].key){
            smallest = l;
        }
        if(r<size && heap[r].key < heap[smallest].key){
            smallest = r;
        }
        if(smallest != i){
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    /**
        Function to max heapify
        @param i The index of element
     */
    private void maxHeapify(int i){
        int l = leftChild(i);
        int r = rightChild(i);
        int largest = i;
        if(l<size && heap[l].key > heap[largest].key){
            largest = l;
        }
        if(r<size && heap[r].key > heap[largest].key){
            largest = r;
        }
        if(largest != i){
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    /**
        Function to get parent
        @param i The index of element
     */
    private int parent(int i) {
        return (i - 1) / 2;
    }

    /**
        Function to get left child
        @param i The index of element
     */
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    /**
        Function to get right child
        @param i The index of element
     */
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    /**
        Function to swap elements
        @param i The index of element
        @param j The index of element
     */
    private void swap(int i, int j) {
        entry temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

}
