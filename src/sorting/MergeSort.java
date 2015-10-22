package sorting;

import java.util.Arrays;

/**
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class MergeSort {

    public static int[] mergeSort(int[] unsortedArray) {
        int length = unsortedArray.length;
        if (length == 1)
            return unsortedArray;
        else {
            if (length == 2) {
                int[] sortedArray = new int[unsortedArray.length];
                if (unsortedArray[0] > unsortedArray[1]) {
                    sortedArray[0] = unsortedArray[1];
                    sortedArray[1] = unsortedArray[0];
                } else {
                    sortedArray[0] = unsortedArray[0];
                    sortedArray[1] = unsortedArray[1];
                }
                return sortedArray;
            } else {
                int[] firstHalf = Arrays.copyOfRange(unsortedArray, 0, length / 2);
                int[] secondHalf = Arrays.copyOfRange(unsortedArray, length / 2, length);
                int[] firstSorted = mergeSort(firstHalf);
                int[] secondSorted = mergeSort(secondHalf);
                if (firstHalf[firstHalf.length - 1] < secondHalf[0])
                    return merge(firstHalf, secondHalf);
                else
                    return merge(secondHalf, firstHalf);
            }
        }
    }

    public static int[] merge(int[] firstHalf, int[] secondHalf) {
        int firstLength = firstHalf.length;
        int secondLength = secondHalf.length;
        int[] merged = new int[firstLength + secondLength];
        int i;
        for (i = 0; i < firstLength; i++)
            merged[i] = firstHalf[i];

        for (int j = 0; j < secondLength; j++)
            merged[i++] = secondHalf[j];
        return merged;
    }

    public static void main(String[] args) {
        int[] unsorted = new int[]{10, 2, 12, 34, 20, 14, 27, 90};
        int[] sorted = mergeSort(unsorted);
        System.out.println(Arrays.toString(sorted));
    }
}
