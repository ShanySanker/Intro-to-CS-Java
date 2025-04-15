/** Shanny Sanker 209196468 **/

import java.util.Scanner;

public class Trapezoid {
    public static void main(String[] args) {
        /* gets 6 user input that represent 2 left points of trapezoid on XY coordinate system
         * bases are parallel to the X line
         * prints the area and perimeter of the trapezoid
         * we assume input is legal
         */

        Scanner scan = new Scanner (System.in);
        System.out.println("Please enter the left point coordinates of the base followed by its length:");
        int x1 = scan.nextInt();
        int y1 = scan.nextInt();
        int length1 = scan.nextInt();
        System.out.println("Please enter the left point coordinates of the other base followed by its length:");
        int x2 = scan.nextInt();
        int y2 = scan.nextInt();
        int length2 = scan.nextInt();

        double area, perimeter;
        double height, side1, side2; //side1->left side  side2->right side
        int point1, point2; //represents the right point of the trapezoid

        height = Math.abs(y1-y2);
        area = (length1+length2)*height/2.0;

        side1 = Math.sqrt(Math.pow((x1 - x2),2) + Math.pow((y1 - y2),2)); //distance formula
        point1 = x1 + length1;
        point2 = x2 + length2;
        side2 = Math.sqrt(Math.pow((point1 - point2),2) + Math.pow((y1 - y2),2)); //distance formula
        perimeter = length1 + length2 + side1 + side2;

        System.out.println("The area of the trapezoid is " + area);
        System.out.println("The perimeter of the trapezoid is " + perimeter);
    } // end of method main
} //end of class Trapezoid
