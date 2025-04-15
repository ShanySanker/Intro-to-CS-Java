/** Shanny Sanker 209196468 **/

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        /* gets 4 user input that represent speed and time of 2 trains
         * prints the distance after stop
         * we assume input is legal
         */

        final double MINUTE_TO_HOUR = 60;
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter 4 integers ");
        System.out.println("Please enter the speed of train 1:");
        int v1 = scan.nextInt();
        System.out.println("Please enter the time of train 1:");
        int t1 = scan.nextInt();
        System.out.println("Please enter the speed of train 2:");
        int v2 = scan.nextInt();
        System.out.println("Please enter the time of train 2:");
        int t2 = scan.nextInt();

        double distance;
        distance = Math.abs((v1 * t1 / MINUTE_TO_HOUR) - (v2 * t2 / MINUTE_TO_HOUR));
        System.out.println("The distance between the trains is " + distance + " km.");
    }  // end of method main
} //end of class Train