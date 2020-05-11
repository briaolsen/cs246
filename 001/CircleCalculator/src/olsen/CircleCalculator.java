package olsen;

import java.util.Scanner;
import java.lang.Math.*;
import java.text.*;

public class CircleCalculator {

    private static Scanner scanner = new Scanner( System.in );

    public double getRadius() {

        System.out.println("Enter the radius: ");
        //String input = scanner.nextLine();
        //double radius = Double.parseDouble(input);
        double radius = scanner.nextDouble();
        return radius;
    }

    public void displayCircumference(double radius) {
        double circ = 2 * Math.PI * radius;
        System.out.println("Circumference: ");
        System.out.format("%.2f%n", circ);
        System.out.format("Circumference: %.2f\n", circ);
    }

    public void displayArea(double radius) {
        double area = Math.PI * radius * radius;
        System.out.println("Area: ");
        System.out.format("%.2f%n", area);
        System.out.format("Area: %.2f\n", area);
    }

    public static void main(String[] args) {
        CircleCalculator calc = new CircleCalculator();
        double radius = calc.getRadius();
        calc.displayCircumference(radius);
        calc.displayArea(radius);
    }
}
