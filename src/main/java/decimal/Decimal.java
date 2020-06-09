package decimal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Decimal {

    private final static BigDecimal errorDiff = BigDecimal.valueOf(0.000000000001);

    public static int getIndexOfMatchingRest(List<BigDecimal> rests, BigDecimal rest) {

        if (rests == null || rests.isEmpty()) return -1;

        for (int i = 0; i < rests.size(); i++) {
            if ((rests.get(i).subtract(rest)).abs().compareTo(errorDiff) == -1) {
                return i;
            }
        }

        return -1;
    }

    public static void printReverseValue() {

        System.out.println("Enter the integer to reverse");
        Scanner in = new Scanner(System.in);
        int integer = in.nextInt();


        BigDecimal input = BigDecimal.valueOf(integer);

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");


        BigDecimal inverse = new BigDecimal("1").divide(input, 1000, RoundingMode.CEILING);


        int floor = inverse.intValue();


        BigDecimal rest = inverse.subtract(BigDecimal.valueOf(floor));

        List<BigDecimal> lastRests = new ArrayList<>();
        lastRests.add(rest);

        String decimalToPrint = floor + ".";
        int indexOfMatchingRest = -1;

        while (true) {
            if (rest.compareTo(new BigDecimal("0")) == 0) {
                System.out.println(decimalToPrint);
                break;

            } else {

                rest = rest.multiply(new BigDecimal(10));

                floor = rest.intValue();
                rest = rest.subtract(new BigDecimal(floor));
                decimalToPrint += String.valueOf((int) floor);

                indexOfMatchingRest = getIndexOfMatchingRest(lastRests, rest);
                if (indexOfMatchingRest >= 0) {
                    decimalToPrint = decimalToPrint.substring(0, decimalToPrint.indexOf(".") + indexOfMatchingRest + 1) + "(" + decimalToPrint.substring(decimalToPrint.indexOf(".") + indexOfMatchingRest + 1, decimalToPrint.length()) + ")";

                    rest = new BigDecimal("0");
                } else {


                    lastRests.add(rest);
                }

            }
        }
    }

}
