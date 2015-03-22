package classics;

import java.util.ArrayList;

/**
 * @author Cassio
 * @version 1.0
 */
public class ChangeMaker {

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

    public static void main(String[] args) {
        int[] packs = new int[]{2, 4, 6, 9};
        printAllCombinations(13, packs);
    }
}
