import java.util.Scanner;

import static java.lang.Math.PI;

public class CircleCalculator {

    public static void main(String[] args) {
        double radius;

        CircleCalculator circleCalculator = new CircleCalculator();

        radius = circleCalculator.getRadius();
        circleCalculator.displayCircumference(radius);
        circleCalculator.displayArea(radius);


    }

    private static Scanner scanner = new Scanner(System.in);

    private double getRadius(){
        double radius;

        System.out.println("Please enter a radius: ");
        radius = scanner.nextDouble();
        return radius;
    }

    private void displayCircumference(double radius){
        double circumference = (PI * (radius * 2));
        System.out.printf("The circumference is: %.2f%n", circumference);
    }

    private void displayArea(double radius){
        double area = PI * (radius * radius);
        System.out.printf("The area is: %.2f%n", area);
    }


}
