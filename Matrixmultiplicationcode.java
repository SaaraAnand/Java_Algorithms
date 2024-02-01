public class Matrixmultiplicationcode {

    static int matrixChainOrder(int[] p) {
        int n = p.length - 1; // Number of matrices

        // Create a table to store the minimum number of multiplications needed for each subproblem
        int[][] dp = new int[n][n];

        // Cost is 0 when multiplying one matrix
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // L is the chain length
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }

        // The result is stored at the top-right cell of the table
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        // Example matrix dimensions: A1(10x30), A2(30x5), A3(5x60)
        int[] matrixDimensions = {10, 30, 5, 60};

        int minMultiplications = matrixChainOrder(matrixDimensions);

        System.out.println("Minimum number of multiplications: " + minMultiplications);
    }
}

