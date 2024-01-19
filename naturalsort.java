import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class naturalsort {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("file2.txt");
        list.add("file11.txt");
        list.add("file1.txt");
        list.add("file20.txt");
        list.add("file3.txt");

        System.out.println("Before natural sorting: " + list);

        // Perform natural sorting
        Collections.sort(list, new NaturalOrderComparator());

        System.out.println("After natural sorting: " + list);
    }
}

class NaturalOrderComparator implements Comparator<String> {

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private String getChunk(String s, int slength, int marker) {
        StringBuilder chunk = new StringBuilder();
        char c = s.charAt(marker);
        chunk.append(c);
        marker++;
        if (isDigit(c)) {
            while (marker < slength) {
                c = s.charAt(marker);
                if (!isDigit(c)) {
                    break;
                }
                chunk.append(c);
                marker++;
            }
        } else {
            while (marker < slength) {
                c = s.charAt(marker);
                if (isDigit(c)) {
                    break;
                }
                chunk.append(c);
                marker++;
            }
        }
        return chunk.toString();
    }

    @Override
    public int compare(String s1, String s2) {
        int thisMarker = 0;
        int thatMarker = 0;
        int s1Length = s1.length();
        int s2Length = s2.length();

        while (thisMarker < s1Length && thatMarker < s2Length) {
            String thisChunk = getChunk(s1, s1Length, thisMarker);
            thisMarker += thisChunk.length();

            String thatChunk = getChunk(s2, s2Length, thatMarker);
            thatMarker += thatChunk.length();

            // If both chunks contain numeric characters, compare them as integers
            int result;
            if (isDigit(thisChunk.charAt(0)) && isDigit(thatChunk.charAt(0))) {
                int thisChunkInt = Integer.parseInt(thisChunk);
                int thatChunkInt = Integer.parseInt(thatChunk);
                result = Integer.compare(thisChunkInt, thatChunkInt);
            } else {
                result = thisChunk.compareTo(thatChunk);
            }

            if (result != 0) {
                return result;
            }
        }

        return s1Length - s2Length;
    }
}

