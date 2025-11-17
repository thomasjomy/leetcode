package my.test.leetcode.ds.heap;

public class HeapApp {
    public static void main(String[] args) {
        Heap theHeap = new Heap(31);
        theHeap.insert(70);
        theHeap.insert(40);
        theHeap.insert(50);
        theHeap.insert(20);
        theHeap.insert(60);
        theHeap.insert(100);
        theHeap.insert(80);
        theHeap.insert(30);
        theHeap.insert(10);
        theHeap.insert(90);

        theHeap.print();
    }

    private static void removeAllKeys(Heap theHeap) {
        while (!theHeap.isEmpty()) {
            Node node = theHeap.remove();
            System.out.println(node);
        }
    }
}
