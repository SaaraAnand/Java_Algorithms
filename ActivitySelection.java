import java.util.*;
class ActivitySelection {
    public static void printActivities(int[] start, int[] end, int n) {
        int i, j;
        i = 0;
        System.out.print(i + " ");
        for (j = 1; j < n; j++) {
            if (start[j] >= end[i]) {
                System.out.print(j + " ");
                i = j;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
        }
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            end[i] = sc.nextInt();
        }
        printActivities(start, end, n);
    }
}
