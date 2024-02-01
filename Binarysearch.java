public class Binarysearch {

    // Returns the index of x if it is present in the array, else returns -1
    static int binarySearch(int[] arr, int low, int high, int x) {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            // If the element is present at the middle itself
            if (arr[mid] == x)
                return mid;

            // If the element is smaller than the middle element, then it can only be present in the left subarray
            if (arr[mid] > x)
                return binarySearch(arr, low, mid - 1, x);

            // Else the element can only be present in the right subarray
            return binarySearch(arr, mid + 1, high, x);
        }

        // Element is not present in array
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int x = 10;

        int result = binarySearch(arr, 0, arr.length - 1, x);

        if (result == -1)
            System.out.println("Element not present in array");
        else
            System.out.println("Element found at index " + result);
    }
}
