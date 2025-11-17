package my.test.leetcode.ds.heap;

public class HeapSortApp {
    public static void main(String[] args) {
        int numberOfItems = 100;

        Heap theHeap = new Heap(numberOfItems);
        for (int i = 0; i < numberOfItems; i++) {
            int random = (int) (Math.random() * 100);
            theHeap.insert(random);
        }

        while (!theHeap.isEmpty()) {
            System.out.print(theHeap.remove() + " ");
        }
    }
}
