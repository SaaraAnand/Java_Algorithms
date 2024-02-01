import java.util.Scanner;

public class MatrixMultiplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for the number of rows and columns for the first matrix
        System.out.print("Enter the number of rows for the first matrix: ");
        int rows1 = scanner.nextInt();
        System.out.print("Enter the number of columns for the first matrix: ");
        int cols1 = scanner.nextInt();

        // Input for the number of rows and columns for the second matrix
        System.out.print("Enter the number of rows for the second matrix: ");
        int rows2 = scanner.nextInt();
        System.out.print("Enter the number of columns for the second matrix: ");
        int cols2 = scanner.nextInt();

        // Check if the condition for matrix multiplication is satisfied
        if (cols1 != rows2) {
            System.out.println("Matrix multiplication is not possible. Number of columns in the first matrix must be equal to the number of rows in the second matrix.");
            return;
        }

        // Create the first matrix
        int[][] matrix1 = createMatrix(rows1, cols1, scanner, "first");

        // Create the second matrix
        int[][] matrix2 = createMatrix(rows2, cols2, scanner, "second");

        // Perform matrix multiplication
        int[][] resultMatrix = multiplyMatrices(matrix1, matrix2);

        // Display the result matrix
        System.out.println("Resultant Matrix after multiplication:");
        displayMatrix(resultMatrix);
    }

    private static int[][] createMatrix(int rows, int cols, Scanner scanner, String matrixName) {
        System.out.println("Enter elements for the " + matrixName + " matrix:");
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter element at position (" + (i + 1) + "," + (j + 1) + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int cols2 = matrix2[0].length;

        int[][] resultMatrix = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return resultMatrix;
    }

    private static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

