package classics;

/**
 * Exponential function between two integers.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class Exponential {

    private static boolean isEdgeCase(int baseOrPower) {
        return baseOrPower == 0 || baseOrPower == 1;
    }

    private static double edgeCaseForBaseWhere(boolean isBaseZero) {
        if (isBaseZero)
            return 0.0;
        else
            return 1.0;
    }

    private static double edgeCaseForPowerWhere(boolean isPowerZero, int base) {
        if (isPowerZero)
            return 1.0;
        else
            return 1.0 * base;
    }

    public static double exponential(int base, int power) {

        // Checking edge cases, assuming 0^0 = 0

        if (isEdgeCase(base))
            return edgeCaseForBaseWhere(base == 0);

        // Edge cases for power comes after

        if (isEdgeCase(power))
            return edgeCaseForPowerWhere(power == 0, base);

        // Variable to check whether it should multiply or divide

        boolean isPowerPositive = power >= 0;

        // Get positive power as variable

        int positivePower = power;
        if (!isPowerPositive)
            positivePower *= -1;

        // Implementation

        double currentPowerOf2 = base * 1.0;
        double oddBitProduct = 1.0;

        while (positivePower > 1) {
            if (positivePower % 2 != 0)
                oddBitProduct *= currentPowerOf2;
            currentPowerOf2 *= currentPowerOf2;
            positivePower /= 2;
        }

        double integerResult = oddBitProduct * currentPowerOf2;

        if (!isPowerPositive)
            integerResult = 1.0 / integerResult;

        return integerResult;
    }

    private static void printExponential(int base, int power) {
        if (power >= 0)
            System.out.printf("(%d) ^ (%d) = %d\n", base, power, (int) exponential(base, power));
        else
            System.out.printf("(%d) ^ (%d) = %f\n", base, power, exponential(base, power));
    }

    public static void main(String[] args) {
        printExponential(2, 5);
        printExponential(2, 4);
        printExponential(2, 3);
        printExponential(2, 2);
        printExponential(2, 1);
        printExponential(2, 0);
        printExponential(2, -1);
        printExponential(2, -2);
        printExponential(2, -3);
        printExponential(2, -4);
    }

}
