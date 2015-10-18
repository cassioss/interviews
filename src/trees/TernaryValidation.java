package trees;

/**
 * Follow-up: see if the expression needs to be ternary (to have interrogation and colon) to be valid. In this case,
 * having neither of them but having at least an atom is considered to be valid.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class TernaryValidation {

    public static boolean isTernary(String expression) {
        return expression != null && _isTernary(expression.replaceAll("\\s+", ""));
    }

    private static boolean _isTernary(String expression) {
        int intMinusColons = 0;
        int lengthOfPrevious = 0;
        for (int i = 0; i < expression.length(); i++) {
            char beingChecked = expression.charAt(i);
            if (beingChecked != ':' && beingChecked != '?')
                lengthOfPrevious++;
            else {
                // Colons and interrogations should not be together
                if (lengthOfPrevious == 0)
                    return false;
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
        // In the end, colons and interrogations should balance each other, ending in a non-empty string.
        return intMinusColons == 0 && lengthOfPrevious > 0;
    }


    public static void confirmIf(String expression, boolean expected) {
        System.out.println(isTernary(expression) == expected);
    }

    public static void main(String[] args) {
        confirmIf(null, false);
        confirmIf("", false);
        confirmIf("a", true);
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
