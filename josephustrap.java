import java.util.ArrayList;

public class josephustrap {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            a.add(i);
        }

        int result = trap(a, 3, 0);
        System.out.println("The last remaining element is: " + result);
    }

    static int trap(ArrayList<Integer> a, int k, int index) {
        if (a.size() == 1) {
            return a.get(0);
        }

        index = (index + k) % a.size();
        a.remove(index);

        // Add a return statement for the recursive call
        return trap(a, k, index);
    }
}
