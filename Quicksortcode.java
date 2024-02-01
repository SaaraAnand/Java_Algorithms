public class Quicksortcode {

    private static int functionCalls = 0;

    public static void main(String[] args) {
        int[] myArray = {3, 6, 8, 10, 1, 2, 1, 15, 4, 7};

        System.out.println("Original Array:");
        printArray(myArray);

        quickSort(myArray, 0, myArray.length - 1);

        System.out.println("\nSorted Array:");
        printArray(myArray);

        System.out.println("\nNumber of function calls in Quick Sort: " + functionCalls);
        System.out.println("Depth of recursion tree: " + (int) (Math.log(functionCalls) / Math.log(2)));
    }

    static void quickSort(int[] arr, int low, int high) {
        functionCalls++;
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
