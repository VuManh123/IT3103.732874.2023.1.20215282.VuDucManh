package src;
import java.util.Scanner;

public class Ex_2_2_6 {
    public static void main(String[] args) {
        System.out.println("-----------Menu----------\n" +
                "1. The first-degree equation with one variable\n" +
                "2. The system of first-degree equations with two variables\n" +
                "3. The second-degree equation with one variable");
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("Enter your choice: ");
            int cmd = sc.nextInt();
            if (cmd == 1) {
                solveFirstDegreeEquation();
            } else if (cmd == 2) {
                solveSystemOfFirstDegreeEquations();
            } else if (cmd == 3) {
                solveSecondDegreeEquation();
            } else {
                System.out.println("Invalid choice. Finished!");
            }
        }
    }

    // Function to solve a first-degree equation
    public static void solveFirstDegreeEquation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of a: ");
        double a = sc.nextDouble();
        System.out.print("Enter the value of b: ");
        double b = sc.nextDouble();

        if (a == 0) {
            System.out.println("The equation is not of the first degree.");
        } else {
            double x = -b / a;
            System.out.println("The solution is x = " + x);
        }
    }

    // Function to solve a system of first-degree equations
    public static void solveSystemOfFirstDegreeEquations() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the coefficients a11, a12, b1, a21, a22, b2: ");
        double a11 = sc.nextDouble();
        double a12 = sc.nextDouble();
        double b1 = sc.nextDouble();
        double a21 = sc.nextDouble();
        double a22 = sc.nextDouble();
        double b2 = sc.nextDouble();

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("The solution is x1 = " + x1 + ", x2 = " + x2);
        } else {
            if (D1 == 0 && D2 == 0) {
                System.out.println("The system has infinitely many solutions.");
            } else {
                System.out.println("The system has no solution.");
            }
        }
    }

    // Function to solve a second-degree equation
    public static void solveSecondDegreeEquation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of a: ");
        double a = sc.nextDouble();
        System.out.print("Enter the value of b: ");
        double b = sc.nextDouble();
        System.out.print("Enter the value of c: ");
        double c = sc.nextDouble();

        double discriminant = b * b - 4 * a * c;

        if (a == 0) {
            System.out.println("The equation is not a second-degree equation.");
        } else if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("The solutions are x1 = " + x1 + ", x2 = " + x2);
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            System.out.println("The solution is a double root: x = " + x);
        } else {
            System.out.println("The equation has no real roots.");
        }
    }
}
