import java.util.*;

public class DSAProject {

    static Scanner sc = new Scanner(System.in);

    // ================= SEARCHING =================

    static int linearSearch(int arr[], int key) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == key)
                return i;
        return -1;
    }

    static int binarySearch(int arr[], int key) {
        int l = 0, h = arr.length - 1;
        while (l <= h) {
            int m = (l + h) / 2;
            if (arr[m] == key) return m;
            else if (arr[m] < key) l = m + 1;
            else h = m - 1;
        }
        return -1;
    }

    // ================= SORTING =================

    static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
    }

    static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i], j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[min]) min = j;

            int t = arr[i];
            arr[i] = arr[min];
            arr[min] = t;
        }
    }

    // ================= MERGE SORT =================

    static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[l + i];
        for (int j = 0; j < n2; j++) R[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2)
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // ================= QUICK SORT =================

    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++)
            if (arr[j] < pivot) {
                i++;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }

        int t = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = t;
        return i + 1;
    }

    // ================= STACK =================

    static void stackDemo() {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        System.out.println("Stack Pop: " + stack.pop());
    }

    // ================= QUEUE =================

    static void queueDemo() {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        System.out.println("Queue Remove: " + q.remove());
    }

    // ================= LINKED LIST =================

    static void linkedListDemo() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.addFirst(5);
        System.out.println("LinkedList: " + list);
    }

    // ================= HASHING =================

    static void hashingDemo() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "Python");
        System.out.println("HashMap: " + map);
    }

    // ================= HEAP =================

    static void heapDemo() {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(50);
        heap.add(10);
        heap.add(30);
        System.out.println("Min Heap Remove: " + heap.poll());
    }

    // ================= MAIN MENU =================

    public static void main(String[] args) {

        System.out.println("===== DSA PROJECT =====");

        int arr[] = {5, 2, 8, 1, 3};

        bubbleSort(arr);
        System.out.println("Bubble Sorted: " + Arrays.toString(arr));

        insertionSort(arr);
        selectionSort(arr);
        mergeSort(arr, 0, arr.length - 1);
        quickSort(arr, 0, arr.length - 1);

        System.out.println("Linear Search (3): " + linearSearch(arr, 3));
        System.out.println("Binary Search (3): " + binarySearch(arr, 3));

        stackDemo();
        queueDemo();
        linkedListDemo();
        hashingDemo();
        heapDemo();

        System.out.println("=== All Topics Demonstrated Successfully ===");
    }
}