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

    private static void quickSort(int[] unsortedArray, int leftPivot, int rightPivot) {
        if (leftPivot < rightPivot) {
            int iterLeft = leftPivot;
            int iterRight = rightPivot - 1;
            int reference = unsortedArray[rightPivot];
            while (iterLeft < iterRight) {
                if (unsortedArray[iterRight] > reference) {
                    iterRight--;
                    continue;
                }
                if (unsortedArray[iterLeft] < reference) {
                    iterLeft++;
                    continue;
                }
                swap(unsortedArray, iterLeft, iterRight);
            }
            if (unsortedArray[iterRight] > reference)
                swap(unsortedArray, iterLeft, rightPivot);
            System.out.println("Pivot: " + reference);
            System.out.println(Arrays.toString(unsortedArray));
            quickSort(unsortedArray, leftPivot, iterLeft);
            quickSort(unsortedArray, iterRight + 1, rightPivot);

        }
    }

    private static void swap(int[] array, int leftPivot, int rightPivot) {
        if (leftPivot < rightPivot) {
            int valueToTheLeft = array[leftPivot];
            array[leftPivot] = array[rightPivot];
            array[rightPivot] = valueToTheLeft;
            System.out.println("Changed: " + array[leftPivot] + " " + array[rightPivot]);
        }
    }

    public static void main(String[] args) {
        int[] unsorted = new int[]{10, 2, 12, 34, 20, 14, 27, 90, 86, 93, 15, 120, 50, 14, 28};
        quickSort(unsorted);
        System.out.println(Arrays.toString(unsorted));
    }

}