package classics;

import java.util.Random;

/**
 * Exponential function between two integers.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class Exponential {

    public static double exponential(int base, int power) {

        // Base = 0, power < 0 will bring division by zero.
        if (base == 0)
            return 0.0;

        if (power < 0)
            return 1.0 / _exponential(base, -power);
        else
            return _exponential(base, power);
    }


    /**
     * Calculates exponential in O(log(|power|)), since, after k iterations, the iterator will be |power|/2^k.
     */
    private static double _exponential(int base, int positivePower) {
        double currentPowerOf2 = base * 1.0;
        double oddBitProduct = 1.0;

        while (positivePower > 0) {
            if (positivePower % 2 != 0)
                oddBitProduct *= currentPowerOf2;
            currentPowerOf2 *= currentPowerOf2;
            positivePower /= 2;
        }

        return oddBitProduct;
    }

    private static void checkExponential(int base, int power, double expected) {
        if (Math.abs(exponential(base, power) - expected) < 0.0001)
            System.out.println("true");
        else
            System.out.printf("false: exponential(%d, %d) = %f, expected = %f\n",
                    base, power, exponential(base, power), expected);
    }

    public static void main(String[] args) {

        // Sanity checks

        checkExponential(2, 5, 32.0);
        checkExponential(2, -2, 0.25);

        // Check edge cases

        checkExponential(0, 0, 0.0);
        checkExponential(0, -1, 0.0);
        checkExponential(0, 1, 0.0);
        checkExponential(1, 0, 1.0);

        // Check if it works like Math.pow(base, power) with random values

        Random random = new Random();
        random.setSeed(3);

        for (int i = 0; i < 30; i++) {
            int base = random.nextInt(20);
            int exponent = random.nextInt(10);
            checkExponential(base, exponent, Math.pow(base, exponent));
        }

    }

}
