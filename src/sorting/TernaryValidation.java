package sorting;

/**
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class TernaryValidation {

    public static boolean isTernary(String expression) {
        return notEdgeCase(expression) && _isTernary(expression.replaceAll("\\s+", ""));
    }

    /**
     * Null strings cannot be checked, and empty strings are false positives.
     */
    private static boolean notEdgeCase(String expression) {
        return expression != null && !expression.equals("");
    }

    private static boolean _isTernary(String expression) {
        int intMinusColons = 0;
        int lengthOfPrevious = 0;
        for (int i = 0; i < expression.length(); i++) {
            char beingChecked = expression.charAt(i);
            if (notColonOrInt(beingChecked))
                lengthOfPrevious++;
            else {
                // Colons and interrogations should not be together
                if (lengthOfPrevious == 0)
                    return false;
                else {
                    lengthOfPrevious = 0;
                    if (beingChecked == '?')
                        intMinusColons++;
                    else {
                        // Colons go after the interrogations
                        intMinusColons--;
                        if (intMinusColons < 0)
                            return false;
                    }
                }
            }
        }
        // In the end, colons and interrogations should balance each other, ending in a non-empty string.
        return intMinusColons == 0 && lengthOfPrevious > 0;
    }

    private static boolean notColonOrInt(char someChar) {
        return someChar != ':' && someChar != '?';
    }

    public static void confirmIf(String expression, boolean expected) {
        System.out.println(isTernary(expression) == expected);
    }

    public static void main(String[] args) {
        confirmIf(null, false);
        confirmIf("a?b:c", true);
        confirmIf("a?b?c:d:e", true);
        confirmIf("a?b:c?d:e", true);
        confirmIf("true ? maybe ? yes : no : no", true);
        confirmIf("a?b", false);
        confirmIf("a:b", false);
        confirmIf("a?:b", false);
        confirmIf("a:b?c", false);
        confirmIf("a?b:", false);
        confirmIf("a ? b : ", false);
    }

}
