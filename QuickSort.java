public class QuickSort {

    public static void main(String[] args) {
        int[] myArray = {3, 6, 8, 10, 1, 2, 1};

        System.out.println("Original Array:");
        printArray(myArray);

        quickSort(myArray, 0, myArray.length - 1);

        System.out.println("\nSorted Array:");
        printArray(myArray);
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);

            System.out.println("\nPartitioning around " + arr[partitionIndex] + " at index " + partitionIndex + ":");
            printArray(arr);

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

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
