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
                if (unsortedArray[iterLeft] > reference) {
                    while (unsortedArray[iterRight] >= reference && iterLeft < iterRight)
                        iterRight--;
                } else if (unsortedArray[iterRight] < reference) {
                    while (unsortedArray[iterLeft] <= reference && iterLeft < iterRight)
                        iterLeft++;
                }
                if (iterLeft < iterRight) {
                    if (unsortedArray[iterLeft] > unsortedArray[iterRight])
                        swap(unsortedArray, iterLeft, iterRight);
                    iterLeft++;
                }
            }
            if (unsortedArray[iterLeft] > reference)
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
        int[] unsorted = new int[]{12, 12, 12, 12};
        quickSort(unsorted);
        System.out.println(Arrays.toString(unsorted));
    }

}