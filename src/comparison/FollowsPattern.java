package comparison;

import java.util.HashMap;

/**
 * @author Cassio
 * @version 1.0
 */
public class FollowsPattern {

    /**
     * Tells if a string follows the same pattern as a given array.
     */
    public static boolean follows(String beingChecked, String[] pattern) {

        // If the string has a different number of words, the method might bring false positives.
        String[] split = beingChecked.split("\\s+");
        return split.length == pattern.length && _follows(split, pattern);
    }

    public static boolean _follows(String[] splitChecked, String[] pattern) {
        HashMap<String, String> association = new HashMap<>();
        for (int i = 0; i < splitChecked.length; i++) {
            if (!association.containsKey(pattern[i]))
                association.put(pattern[i], splitChecked[i]);
            else if (!association.get(pattern[i]).equals(splitChecked[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] pattern = {"a", "b", "b", "a"};
        String checkFirst = "dog cat cat dog";
        String checkSecond = "dog cat dog cat";
        System.out.println(follows(checkFirst, pattern));
        System.out.println(!follows(checkSecond, pattern));
    }
}
