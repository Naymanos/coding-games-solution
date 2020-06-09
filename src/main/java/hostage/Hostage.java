package hostage;

import commun.Pair;
import commun.WrapInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static commun.MathOperations.*;

public class Hostage {

    static final String UP = "U";
    static final String UR = "UR";
    static final String UL = "UL";
    static final String RI = "R";
    static final String LE = "L";
    static final String DO = "D";
    static final String DR = "DR";
    static final String DL = "DL";

    public static WrapInteger getLastCoordinateForState(String state, List<Pair<String, WrapInteger>> states) {
        if (states != null && states.size() > 0) {
            for (int i = states.size() - 1; i >= 0; i--) {
                if (state.equals(states.get(i).getKey())) {
                    return states.get(i).getValue();
                }
            }
        }

        return null;
    }

    public static void calculateNextCoordinate(WrapInteger coordinate, Integer maximumSize, List<Pair<String, WrapInteger>> states, String opositeDirection, String sameDirection, int divisionSize) {
        WrapInteger lastCoordinate = new WrapInteger(getLastCoordinateForState(opositeDirection, states));
        WrapInteger localCoordinate = new WrapInteger(coordinate);
        Pair<String, WrapInteger> pair = new Pair<>(sameDirection, localCoordinate);

        if (lastCoordinate.getInteger() != null) {
            coordinate.setInteger(ceil(coordinate.getInteger() + lastCoordinate.getInteger(), divisionSize));

        } else {
            lastCoordinate = new WrapInteger(getLastCoordinateForState(sameDirection, states));

            if (DO.equals(sameDirection) || RI.equals(sameDirection)) {
                coordinate.setInteger(floor(maximumSize + max(coordinate.getInteger(), lastCoordinate.getInteger() == null ? (Integer) 0 : lastCoordinate.getInteger()), divisionSize));

            } else {
                coordinate.setInteger(floor(min(coordinate.getInteger(), lastCoordinate.getInteger() == null ? (Integer) maximumSize : lastCoordinate.getInteger()), divisionSize));
            }
        }

        states.add(pair);

    }

    public static void findHostage() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the width of the building (number of horizontal windows)");

        int W = in.nextInt(); // width of the building.

        System.out.println("Enter the height of the building (number of vertical windows)");

        int H = in.nextInt(); // height of the building.

        System.out.println("Enter maximum number of turns before game over");

        int N = in.nextInt(); // maximum number of turns before game over.


        System.out.println("Enter the X0 position where is batman the windows start at 0 and ends at the width");

        int X0 = in.nextInt();

        System.out.println("Enter the Y0 position where is batman the windows start at 0 and ends at the height");

        int Y0 = in.nextInt();

        WrapInteger X = new WrapInteger(Integer.valueOf(X0));
        WrapInteger Y = new WrapInteger(Integer.valueOf(Y0));

        List<Pair<String, WrapInteger>> statesX = new ArrayList<>();
        List<Pair<String, WrapInteger>> statesY = new ArrayList<>();

        // game loop
        while (true) {
            System.out.println("Direct batman to find hostages, possible values UR = UP, RIGHT), UL = (UP, LEFT), UP, D, DL = (Down, left), DR = (Down, RIGHT)");

            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)


            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            if (UR.equals(bombDir) || UP.equals(bombDir) || UL.equals(bombDir)) {

                calculateNextCoordinate(Y, H, statesY, DO, UP, 2);


            } else {
                calculateNextCoordinate(Y, H, statesY, UP, DO, 2);

            }


            if (UR.equals(bombDir) || RI.equals(bombDir) || DR.equals(bombDir)) {
                calculateNextCoordinate(X, W, statesX, LE, RI, 2);


            } else {
                calculateNextCoordinate(X, W, statesX, RI, LE, 2);
            }


            // the location of the next window Batman should jump to.
            System.out.println(X.getInteger() + " " + Y.getInteger());
        }
    }
}


