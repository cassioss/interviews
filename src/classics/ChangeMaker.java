package classics;

import java.util.ArrayList;

/**
 * Basic code for a change maker. Exactly as asked by DropBox. Instead of coins, the problem states for soda bottles. If
 * you have different packs of soda bottles (1 bottle, 3 bottles, 6 bottles, 7 bottles, and so on) and you want to buy a
 * certain number of bottles (say, 13 bottles), the output of this code should return all the packs you need to buy in
 * order to buy the intended number of soda bottles.
 *
 * @author Cassio
 * @version 1.1
 * @since 1.0
 */
public class ChangeMaker {

    /**
     * Hook for recursive calls of the algorithm.
     *
     * @param sodasNumber the intended number of sodas you want to buy.
     * @param packs       all possible packs of soda bottles you might buy.
     * @return an array list of lists containing all the unique combinations of packs that return sodasNumber.
     */
    public static ArrayList<ArrayList<Integer>> sodas(int sodasNumber, int[] packs) {
        ArrayList<ArrayList<Integer>> allCombos = new ArrayList<ArrayList<Integer>>();
        allCombos.addAll(checkSodas(sodasNumber, packs, new ArrayList<Integer>(), 0));
        return allCombos;
    }

    public static ArrayList<Integer> copyFrom(ArrayList<Integer> list) {
        ArrayList<Integer> newList = new ArrayList<Integer>();
        for (Integer i : list)
            newList.add(i);
        return newList;
    }

    public static ArrayList<ArrayList<Integer>> checkSodas(int sodasNumber, int[] packs, ArrayList<Integer> currentCombo, int currentIndex) {
        ArrayList<ArrayList<Integer>> partialCombos = new ArrayList<ArrayList<Integer>>();
        if (sodasNumber == 0) {
            partialCombos.add(currentCombo);
            return partialCombos;
        } else {
            if (sodasNumber < 0 || currentIndex == packs.length)
                return partialCombos; //Empty list
            else {
                // First part: picking up the current pack
                ArrayList<Integer> newCombo = copyFrom(currentCombo);
                newCombo.add(packs[currentIndex]);
                partialCombos.addAll(checkSodas(sodasNumber - packs[currentIndex], packs, newCombo, currentIndex));
                // Second part: checking if the next pack can be taken
                partialCombos.addAll(checkSodas(sodasNumber, packs, currentCombo, currentIndex + 1));
                // Third part: getting them all together
                return partialCombos;
            }
        }
    }

    /**
     * Simple function that prints all combinations of soda packs that return sodasNumber.
     *
     * @param sodasNumber the intended number of sodas you want to buy.
     * @param packs       all possible packs of soda bottles you might buy.
     */
    public static void printAllCombinations(int sodasNumber, int[] packs) {
        ArrayList<ArrayList<Integer>> sodasCombo = sodas(sodasNumber, packs);
        System.out.print("[");
        Boolean first = true;
        for (ArrayList<Integer> combo : sodasCombo) {
            if (!first)
                System.out.print(",");
            else
                first = false;
            System.out.print(combo.toString());
        }
        System.out.println("]");
    }

    /**
     * Simple main function that works as a proof-of-concept for the interviewer.
     *
     * @param args all arguments of the main function - none are required.
     */
    public static void main(String[] args) {
        int[] packs = new int[]{2, 4, 6, 9};
        printAllCombinations(13, packs);
    }
}
