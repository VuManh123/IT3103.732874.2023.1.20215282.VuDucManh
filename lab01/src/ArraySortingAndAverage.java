package src;
import java.util.Arrays;
import java.util.Scanner;

public class ArraySortingAndAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers;

        System.out.print("Ban muon nhap day khong (Y/N)? ");
        String choice = scanner.next();

        if (choice.equalsIgnoreCase("Y")) {
            System.out.print("Nhap so phan tu cua mang: ");
            int n = scanner.nextInt();
            numbers = new double[n];
            System.out.print("Nhap phan tu: ");
            for (int i = 0; i < n; i++) {
                numbers[i] = scanner.nextDouble();
            }
        } else {
            numbers = new double[]{1789, 2035, 1899, 1456, 2013};
        }

        scanner.close();
        Arrays.sort(numbers);

        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        double average = sum / numbers.length;

        System.out.println("Sorted Array:");
        for (double num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("\nSum of Array Elements: " + sum);
        System.out.println("Average of Array Elements: " + average);
    }
}

