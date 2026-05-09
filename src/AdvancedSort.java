import java.util.Comparator;

public class AdvancedSort {
    // bubble sort variant
    public static <E extends Comparable<E>> void sort(E[] list){
        // implement it according to your variant
        quickSort(list, 0, list.length - 1);
    }

    private static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    private static <E extends Comparable<E>> int partition(E[] list, int first, int last) {
        E pivot = list[last];
        int i = first - 1;
        for (int j = first; j < last; j++) {
            if (list[j].compareTo(pivot) <= 0) {
                i++;
                E temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }
        E temp = list[i + 1];
        list[i + 1] = list[last];
        list[last] = temp;
        return i + 1;
    }

    public static <E> void sort(E[] list, Comparator<? super E> comparator) {
        // implement it according to your variant
        quickSort(list, 0, list.length - 1, comparator);
    }

    private static <E> void quickSort(E[] list, int first, int last, Comparator<? super E> comparator) {
        if (last > first) {
            int pivotIndex = partition(list, first, last, comparator);
            quickSort(list, first, pivotIndex - 1, comparator);
            quickSort(list, pivotIndex + 1, last, comparator);
        }
    }

    private static <E> int partition(E[] list, int first, int last, Comparator<? super E> comparator) {
        E pivot = list[last];
        int i = first - 1;
        for (int j = first; j < last; j++) {
            if (comparator.compare(list[j], pivot) <= 0) {
                i++;
                E temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }
        E temp = list[i + 1];
        list[i + 1] = list[last];
        list[last] = temp;
        return i + 1;
    }

    // Example for Comparable usage
    public static <E extends Comparable<E>> E findMin(E[] list){
        int minIndex = 0;
        for (int i = 1; i < list.length; i++) {
            if  (list[i].compareTo(list[minIndex]) < 0) {
                minIndex = i;
            }
        }
        return list[minIndex];
    }

    // Example for Comparator usage
    public static <E> E findMin(E[] list, Comparator<? super E> comparator) {
        int minIndex = 0;
        for (int i = 1; i < list.length; i++) {
            if  (comparator.compare(list[i],list[minIndex]) < 0) {
                minIndex = i;
            }
        }
        return list[minIndex];
    }

    static void main() {
        String [] names = {"Bob", "John", "Alice"};

        //Comparable used
        System.out.println(findMin(names)); // Alice (smallest by alphabet, natural)

        // Comparator used
        System.out.println(findMin(names, new StringComparator())); // Bob (smallest by length, custom)
    }
}