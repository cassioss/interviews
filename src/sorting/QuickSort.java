package sorting;

import java.util.Arrays;

/**
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class QuickSort {

    public static void quickSort(int[] unsortedArray) {
        quickSort(unsortedArray, 0, unsortedArray.length - 1);
    }

    private static void quickSort(int[] unsortedArray, int leftPivot, int rightPivot) {
        int reference = unsortedArray[rightPivot];
        if (leftPivot != rightPivot) {
            int leftIterator = leftPivot;
            int rightIterator = rightPivot - 1;
            if (leftIterator == rightIterator) {
                if (unsortedArray[leftIterator] > unsortedArray[rightPivot])
                    swap(unsortedArray, leftIterator, rightPivot);
            } else {
                while (leftIterator < rightIterator) {
                    while (unsortedArray[leftIterator] < reference)
                        leftIterator++;
                    while (unsortedArray[rightIterator] > reference)
                        rightIterator--;
                    if (leftIterator < rightIterator)
                        swap(unsortedArray, leftIterator, rightIterator);
                }
                if (reference < unsortedArray[leftIterator])
                    swap(unsortedArray, leftIterator, rightPivot);
                quickSort(unsortedArray, leftPivot, leftIterator);
                quickSort(unsortedArray, rightIterator, rightPivot);
            }
        }
    }

    private static void swap(int[] array, int leftPivot, int rightPivot) {
        int valueToTheLeft = array[leftPivot];
        array[leftPivot] = array[rightPivot];
        array[rightPivot] = valueToTheLeft;
    }

    public static void main(String[] args) {
        int[] unsorted = new int[]{10, 2, 12, 34, 20, 14, 27, 90, 86, 10, 93, 14};
        quickSort(unsorted);
        System.out.println(Arrays.toString(unsorted));
    }

}