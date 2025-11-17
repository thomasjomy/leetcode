package my.test.leetcode.ds.heap;

public class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        currentSize = 0;
        this.heapArray = new Node[maxSize];
    }

    public boolean insert(int key) {
        if (currentSize == maxSize) {
            return false;
        }

        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    private void trickleUp(int index) {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];

        while (index > 0 && heapArray[parent].data < bottom.data) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }

        heapArray[index] = bottom;
    }

    private void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index];
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < currentSize && heapArray[leftChild].data < heapArray[rightChild].data) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }

            if (top.data >= heapArray[largerChild].data) {
                break;
            }

            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }

        heapArray[index] = top;
    }


    public boolean isEmpty() {
        return currentSize == 0;
    }


    public void print() {
        System.out.println("HeapArray: ");

        for (int i = 0; i < currentSize; i++) {
            if (heapArray[i] != null) {
                System.out.print(heapArray[i].data + " ");
            } else {
                System.out.print("--");
            }
        }

        System.out.println();
        printHeapFormat();

    }

    private void printHeapFormat() {
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = ".......................................";
        System.out.println(dots + dots);

        while (currentSize > 0) {
            if (column == 0) {
                printBlanks(nBlanks);
            }

            System.out.print(heapArray[j].data);

            if (++j == currentSize) {
                break;
            }

            if (++column == itemsPerRow) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else {
                printBlanks(nBlanks * 2 - 2);
            }
        }

        System.out.println("\n" + dots + dots);
    }

    private void printBlanks(int nBlanks) {
        for (int k = 0; k < nBlanks; k++)
            System.out.print(" ");
    }
}
