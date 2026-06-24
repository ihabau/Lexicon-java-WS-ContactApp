package se.lexicon;
import java.util.*;

public class Print {

    public static String devider = "========================================";
    public static final int programLength = devider.length();

    public static void printLeft(String msg) {
        int rightSide = (programLength -2);
        String format = "|" + "%-" + rightSide + "s|\n";
        System.out.printf( format, msg);


    }


    public static void centerCalc(String input) {
        int inputLength = input.length();
        int leftSide = (programLength - inputLength -4) /  2;
        int rightSide = 0;


        if (inputLength % 2 == 0) {
            rightSide = leftSide;
        } else {
            rightSide = leftSide + 1;
        }
        System.out.println(devider);
        String format = "|%" + leftSide + "s %s %" + rightSide + "s|\n";
        System.out.printf( format, "" , input, "" );
        System.out.println(devider);
    }

}
