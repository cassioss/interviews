package comparison;

import java.util.HashMap;

/**
 * @author Cassio
 * @version 1.0
 */
public class FollowsPattern {

    /**
     * Tells if a string follows the same pattern as a given array.
     * <p/>
     * As an interview question: consider making the following questions::
     * <p/>
     * (1) Do I need to check if the input String has an invalid substring? (e.g. am I going to check if there is a
     * double space in the original string or similar?)
     *
     * @param beingChecked a string being checked, parsed by blank spaces.
     * @param pattern      an array that contains a certain pattern.
     * @return <em>true</em> if the string follows the same pattern (e.g.: beingChecked = "cat dog dog cat", pattern =
     * [a, b, b, a]).
     */
    public static boolean follows(String beingChecked, String[] pattern) {
        String[] split = beingChecked.split(" ");
        if (split.length != pattern.length)
            return false;
        HashMap<String, String> patternAssociation = new HashMap<String, String>();
        for (int i = 0; i < split.length; i++) {
            if (!patternAssociation.containsKey(pattern[i]))
                patternAssociation.put(pattern[i], split[i]);
            else if (!patternAssociation.get(pattern[i]).equals(split[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] pattern = {"a", "b", "b", "a"};
        String beingCheckedFirst = "dog cat cat dog";
        String beingCheckedSecond = "dog cat dog cat";
        System.out.println(follows(beingCheckedFirst, pattern));
        System.out.println(follows(beingCheckedSecond, pattern));
    }
}
