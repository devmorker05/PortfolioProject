import java.util.ArrayList;
import java.util.Collections;

import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.simplewriter.SimpleWriter1L;

/**
 * Proof of concept for the universalSort class with a handful of methods, some
 * example fields and a demonstration of how it would work
 *
 * @author Dev Morker
 *
 */
public class universalSortPoCSequence {

    public static boolean isSorted = false;
    public static boolean isReversed = false;

    public universalSortPoCSequence() {

    }

    public static void bubbleSort(ArrayList<String> arr) {
        int n = arr.size();
        boolean swap = true;

        for (int i = 0; i < n - 1 && swap; i++) {
            swap = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j).compareTo(arr.get(j + 1)) < 0) {
                    Collections.swap(arr, j, j + 1);
                    swap = true;
                }
            }
        }
    }

    // Kernel Methods

    public static void sortAlpha(Sequence<String> s) {
        ArrayList<String> tempList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            tempList.add(s.entry(i));
        }
        s.clear();
        bubbleSort(tempList);
        while (!tempList.isEmpty()) {
            s.add(0, tempList.removeFirst());
        }
        isSorted = true;
    }

    public static void sortNums(Sequence<String> s) {
        ArrayList<String> tempList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            tempList.add(s.entry(i));
        }
        s.clear();
        bubbleSort(tempList);
        while (!tempList.isEmpty()) {
            s.add(0, tempList.removeFirst());
        }
        isSorted = true;
    }

    public static void reverse(Sequence<String> s) {
        ArrayList<String> tempList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            tempList.add(s.entry(i));
        }
        s.clear();
        while (!tempList.isEmpty()) {
            s.add(0, tempList.removeFirst());
        }
        isReversed = !isReversed;
    }

    public static int indexSize(Sequence<String> s, int i) {
        String tempEntry = s.entry(i);
        return tempEntry.length();
    }

    /**
     * A demonstration of various implementations of the kernel and secondary
     * methods
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter1L out = new SimpleWriter1L();
        final int sampleLength = 5;
        String[] sampleAlpha = { "b", "s", "d", "h", "w" };
        String[] sampleWords = { "ball", "dog", "empty", "application",
                "calculator" };
        String[] sampleNums = { "4", "2", "5", "7", "9" };

        Sequence<String> testSequenceAlpha = new Sequence1L<String>();
        Sequence<String> testSequenceWords = new Sequence1L<String>();
        Sequence<String> testSequenceNums = new Sequence1L<String>();

        for (int i = 0; i < sampleLength; i++) {
            testSequenceAlpha.add(0, sampleAlpha[i]);
            testSequenceWords.add(0, sampleWords[i]);
            testSequenceNums.add(0, sampleNums[i]);
        }

        out.println("Before Sorting :");
        out.println("--------------------------");
        out.println(testSequenceAlpha);
        out.println(testSequenceWords);
        out.println(testSequenceNums);
        out.println("Sorted? : " + isSorted);
        out.println("Reversed? : " + isReversed);
        out.println("--------------------------");

        sortAlpha(testSequenceAlpha);
        sortAlpha(testSequenceWords);
        sortNums(testSequenceNums);

        out.println("After Sorting :");
        out.println("--------------------------");
        out.println(testSequenceAlpha);
        out.println(testSequenceWords);
        out.println(testSequenceNums);
        out.println("Sorted? : " + isSorted);
        out.println("Reversed? : " + isReversed);
        out.println("--------------------------");

        reverse(testSequenceAlpha);
        reverse(testSequenceWords);
        reverse(testSequenceNums);

        out.println("After Reverse :");
        out.println("--------------------------");
        out.println(testSequenceAlpha);
        out.println(testSequenceWords);
        out.println(testSequenceNums);
        out.println("Sorted? : " + isSorted);
        out.println("Reversed? : " + isReversed);
        out.println("--------------------------");

        out.println("Index lengths :");
        out.println("--------------------------");
        out.println("Sequence with letters :");
        for (int i = 0; i < testSequenceAlpha.length(); i++) {
            out.print(indexSize(testSequenceAlpha, i) + ", ");
        }
        out.println();
        out.println("Sequence with words :");
        for (int i = 0; i < testSequenceWords.length(); i++) {
            out.print(indexSize(testSequenceWords, i) + ", ");
        }
        out.println();
        out.println("Sequence with numbers :");
        for (int i = 0; i < testSequenceNums.length(); i++) {
            out.print(indexSize(testSequenceNums, i) + ", ");
        }
        out.println();
        out.println("--------------------------");

        out.close();
    }
}