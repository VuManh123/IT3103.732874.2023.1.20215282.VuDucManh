package src;
import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows for the matrices: ");
        int numRows = scanner.nextInt();
        System.out.print("Enter the number of columns for the matrices: ");
        int numCols = scanner.nextInt();

        int[][] matrix1 = inputMatrix(scanner, numRows, numCols, "first");
        int[][] matrix2 = inputMatrix(scanner, numRows, numCols, "second");

        int[][] resultMatrix = addMatrices(matrix1, matrix2);

        System.out.println("Resultant Matrix (Matrix1 + Matrix2):");
        displayMatrix(resultMatrix);

        scanner.close();
    }

    public static int[][] inputMatrix(Scanner scanner, int numRows, int numCols, String matrixName) {
        System.out.println("Enter elements for the " + matrixName + " matrix:");
        int[][] matrix = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int numRows = matrix1.length;
        int numCols = matrix1[0].length;

        int[][] resultMatrix = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return resultMatrix;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}