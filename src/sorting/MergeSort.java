package sorting;

import java.util.Arrays;

/**
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class MergeSort {

    /**
     * MergeSort algorithm. Since the total time T(n) is twice the time of the algorithm for two arrays (T(n/2)) plus the merging operation of all the n elements, the algorithm is O(n log(n)).
     */
    public static int[] mergeSort(int[] unsortedArray) {
        int length = unsortedArray.length;
        if (length == 1)
            return unsortedArray;
        int[] firstHalf = Arrays.copyOfRange(unsortedArray, 0, length / 2);
        int[] secondHalf = Arrays.copyOfRange(unsortedArray, length / 2, length);
        int[] firstOrdered = mergeSort(firstHalf);
        int[] secondOrdered = mergeSort(secondHalf);
        return merge(firstOrdered, secondOrdered);
    }

    /**
     * Merges two arrays into one such that the resulting one picks up the smallest values first. This algorithm is O(n), being n the total number of elements in both arrays.
     */
    private static int[] merge(int[] firstHalf, int[] secondHalf) {
        int firstLength = firstHalf.length;
        int secondLength = secondHalf.length;
        int[] merged = new int[firstLength + secondLength];
        int i = 0, j = 0;

        while (i != firstLength && j != secondLength) {
            if (firstHalf[i] <= secondHalf[j])
                merged[i + j] = firstHalf[i++];
            else
                merged[i + j] = secondHalf[j++];
        }

        if (i == firstLength) {
            while (j != secondLength)
                merged[i + j] = secondHalf[j++];
        } else {
            while (i != firstLength)
                merged[i + j] = firstHalf[i++];
        }

        return merged;
    }

    public static void main(String[] args) {
        int[] unsorted = new int[]{10, 2, 12, 34, 20, 14, 27, 90, 86, 10, 93, 14};
        int[] sorted = mergeSort(unsorted);
        System.out.println(Arrays.toString(sorted));
    }
}
