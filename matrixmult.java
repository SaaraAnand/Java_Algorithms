import java.util.ArrayList;

public class matrixmult {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int sourceRow = 2;
        int sourceCol = 2;
        int destRow = 0;
        int destCol = 0;

        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        ArrayList<Integer> currentPath = new ArrayList<>();

        findPaths(matrix, sourceRow, sourceCol, destRow, destCol, paths, currentPath);

        System.out.println("All possible paths from (" + sourceRow + "," + sourceCol + ") to (" + destRow + "," + destCol + "):");
        for (ArrayList<Integer> path : paths) {
            System.out.println(path);
        }
    }

    private static void findPaths(int[][] matrix, int currentRow, int currentCol,
                                  int destRow, int destCol, ArrayList<ArrayList<Integer>> paths,
                                  ArrayList<Integer> currentPath) {
        if (currentRow < 0 || currentRow > 2 || currentCol < 0 || currentCol > 2 || matrix[currentRow][currentCol] == -1) {
            return;
        }

        currentPath.add(matrix[currentRow][currentCol]);

        if (currentRow == destRow && currentCol == destCol) {
            // Add a copy of the current path to the list of paths
            paths.add(new ArrayList<>(currentPath));
        } else {
            // Mark the current cell as visited
            int temp = matrix[currentRow][currentCol];
            matrix[currentRow][currentCol] = -1;

            // Explore all possible directions: up, down, left, right
            findPaths(matrix, currentRow - 1, currentCol, destRow, destCol, paths, currentPath); // Up
            findPaths(matrix, currentRow + 1, currentCol, destRow, destCol, paths, currentPath); // Down
            findPaths(matrix, currentRow, currentCol - 1, destRow, destCol, paths, currentPath); // Left
            findPaths(matrix, currentRow, currentCol + 1, destRow, destCol, paths, currentPath); // Right

            // Reset the cell to its original value
            matrix[currentRow][currentCol] = temp;
        }

        // Backtrack: remove the last element to explore other paths
        currentPath.remove(currentPath.size() - 1);
    }
}

