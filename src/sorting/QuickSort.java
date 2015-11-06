package sorting;

import java.util.Arrays;

/**
 * QuickSort algorithm.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class QuickSort {

    public static void quickSort(int[] unsortedArray) {
        quickSort(unsortedArray, 0, unsortedArray.length - 1);
    }

    private static void quickSort(int[] unsorted, int left, int right) {
        if (left < right) {
            int partition = partition(unsorted, left, right);
            quickSort(unsorted, left, partition - 1);
            quickSort(unsorted, partition + 1, right);
        }
    }

    /**
     * Returns the correct position of the pivot, swapping intermediate values if needed.
     */
    private static int partition(int[] unsorted, int low, int high) {
        int i = low;
        int j = high - 1;
        int pivot = unsorted[high];
        while (i < j) {
            if (unsorted[i] < pivot) {
                i++;
                continue;
            }
            if (unsorted[j] > pivot) {
                j--;
                continue;
            }
            swap(unsorted, i, j);
        }
        if (unsorted[i] >= pivot) {
            swap(unsorted, i, high);
            return i;
        } else return high;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] unsorted = new int[]{10, 2, 12, 34, 20, 14, 27, 14, 90, 86, 93, 15, 120, 50, 28, 15};
        quickSort(unsorted);
        System.out.println(Arrays.toString(unsorted));
    }

}