import java.util.ArrayList;
import java.util.Collections;

import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;
import components.sequence.Sequence;
import components.sequence.Sequence1L;
import components.set.Set;
import components.set.Set1L;
import components.simplewriter.SimpleWriter1L;
import components.stack.Stack;
import components.stack.Stack1L;

/**
 * Proof of concept for the universalSort class with a handful of methods, some
 * example fields and a demonstration of how it would work
 *
 * @author Dev Morker
 *
 */
public class universalSortPoCGONEWRONG {

    /*
     * Private members --------------------------------------------------------
     */

    /*
     * Variables to track states.
     */
    private Map<Integer, Boolean> isSortedAlpha;
    private Map<Integer, Boolean> isSortedNum;
    private Map<Integer, Boolean> isReversed;

    /**
     * Representation of {@code this}.
     */
    private ArrayList<String> rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.rep = new ArrayList<String>(0);
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public universalSortPoCGONEWRONG() {
        this.createNewRep();
    }

    /**
     * Constructor from {@code Sequence}.
     *
     * @param s
     *            {@code Sequence} to initialize from
     */
    public universalSortPoCGONEWRONG(Sequence<String> s) {
        this.createNewRep();
        for (int i = 0; i < s.length(); i++) {
            this.rep.add(s.entry(i).toString());
        }
    }

    /**
     * Constructor from {@code Queue}.
     *
     * @param q
     *            {@code Queue} to initialize from
     */
    public universalSortPoCGONEWRONG(Queue<String> q) {
        this.createNewRep();
        for (int i = 0; i < q.length(); i++) {
            this.rep.add(q.dequeue().toString());
        }
    }

    /**
     * Constructor from {@code Set}.
     *
     * @param s
     *            {@code Set} to initialize from
     */
    public universalSortPoCGONEWRONG(Set<String> s) {
        this.createNewRep();
        for (int i = 0; i < s.size(); i++) {
            this.rep.add(s.removeAny().toString());
        }
    }

    /**
     * Constructor from {@code Stack}.
     *
     * @param s
     *            {@code Stack} to initialize from
     */
    public universalSortPoCGONEWRONG(Stack<String> s) {
        this.createNewRep();
        for (int i = 0; i < s.length(); i++) {
            this.rep.add(s.pop().toString());
        }
    }

    /**
     * Constructor from {@code Map}.
     *
     * @param m
     *            {@code Map} to initialize from
     */
    public universalSortPoCGONEWRONG(Map<String, Integer> m) {
        this.createNewRep();
        for (int i = 0; i < m.size(); i++) {
            this.rep.add(m.removeAny().toString());
        }
    }

    // Kernel Methods

    public final boolean isSortedAlpha() {
        boolean sorted = false;
        if (this.isSortedAlpha.hasKey(this.rep.size())) {
            sorted = this.isSortedAlpha.value(this.rep.size());
        }
        return sorted;
    }

    public final boolean isSortedNum() {
        boolean sorted = false;
        if (this.isSortedNum.hasKey(this.rep.size())) {
            sorted = this.isSortedNum.value(this.rep.size());
        }
        return sorted;
    }

    public final boolean isReversed() {
        boolean reversed = false;
        if (this.isReversed.hasKey(this.rep.size())) {
            reversed = this.isReversed.value(this.rep.size());
        }
        return reversed;
    }

    public final void sortAlpha() {
        if (!this.isSortedAlpha()) {
            Collections.sort(this.rep);
            if (this.isSortedAlpha.hasKey(this.rep.size())) {
                this.isSortedAlpha.replaceValue(this.rep.size(), true);
            } else {
                this.isSortedAlpha.add(this.rep.size(), true);
            }
        }
    }

    public final void sortNum() {
        if (!this.isSortedNum()) {
            Collections.sort(this.rep);
            if (this.isSortedNum.hasKey(this.rep.size())) {
                this.isSortedNum.replaceValue(this.rep.size(), true);
            } else {
                this.isSortedNum.add(this.rep.size(), true);
            }
        }
    }

    public final void reverse() {
        ArrayList<String> temp = new ArrayList<>();
        while (this.rep.size() > 0) {
            temp.add(this.rep.removeLast());
        }
        if (this.isReversed.hasKey(this.rep.size())) {
            this.isReversed.replaceValue(this.rep.size(), true);
        } else {
            this.isReversed.add(this.rep.size(), true);
        }
    }

    public final int indexSize(int i) {
        String index = this.rep.get(i);
        return index.length();
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
        String[] sampleWords = { "ball", "dog", "empty", "apple", "cat" };
        String[] sampleNums = { "4", "2", "5", "7", "15" };

        Sequence<String> testSequenceAlpha = new Sequence1L<String>();
        Sequence<String> testSequenceWords = new Sequence1L<String>();
        Sequence<String> testSequenceNums = new Sequence1L<String>();

        Queue<String> testQueueAlpha = new Queue1L<String>();
        Queue<String> testQueueWords = new Queue1L<String>();
        Queue<String> testQueueNums = new Queue1L<String>();

        Set<String> testSetAlpha = new Set1L<String>();
        Set<String> testSetWords = new Set1L<String>();
        Set<String> testSetNums = new Set1L<String>();

        Stack<String> testStackAlpha = new Stack1L<String>();
        Stack<String> testStackWords = new Stack1L<String>();
        Stack<String> testStackNums = new Stack1L<String>();

        Map<String, Integer> testMapAlpha = new Map1L<String, Integer>();
        Map<String, Integer> testMapWords = new Map1L<String, Integer>();
        Map<String, Integer> testMapNums = new Map1L<String, Integer>();

        for (int i = 0; i < sampleLength; i++) {
            testSequenceAlpha.add(0, sampleAlpha[i]);
            testSequenceWords.add(0, sampleWords[i]);
            testSequenceNums.add(0, sampleNums[i]);

            testQueueAlpha.enqueue(sampleAlpha[i]);
            testQueueWords.enqueue(sampleWords[i]);
            testQueueNums.enqueue(sampleNums[i]);

            testSetAlpha.add(sampleAlpha[i]);
            testSetWords.add(sampleWords[i]);
            testSetNums.add(sampleNums[i]);

            testStackAlpha.push(sampleAlpha[i]);
            testStackWords.push(sampleWords[i]);
            testStackNums.push(sampleWords[i]);

            testMapAlpha.add(sampleAlpha[i], i);
            testMapWords.add(sampleWords[i], i);
            testMapNums.add(sampleNums[i], i);
        }
        universalSortPoCGONEWRONG sortSequenceAlpha = new universalSortPoCGONEWRONG(
                testSequenceAlpha);
        universalSortPoCGONEWRONG sortSequenceWords = new universalSortPoCGONEWRONG(
                testSequenceWords);
        universalSortPoCGONEWRONG sortSequenceNums = new universalSortPoCGONEWRONG(
                testSequenceNums);

        universalSortPoCGONEWRONG sortQueueAlpha = new universalSortPoCGONEWRONG(
                testQueueAlpha);
        universalSortPoCGONEWRONG sortQueueWords = new universalSortPoCGONEWRONG(
                testQueueWords);
        universalSortPoCGONEWRONG sortQueueNums = new universalSortPoCGONEWRONG(
                testQueueNums);

        universalSortPoCGONEWRONG sortSetAlpha = new universalSortPoCGONEWRONG(
                testSetAlpha);
        universalSortPoCGONEWRONG sortSetWords = new universalSortPoCGONEWRONG(
                testSetWords);
        universalSortPoCGONEWRONG sortSetNums = new universalSortPoCGONEWRONG(
                testSetNums);

        universalSortPoCGONEWRONG sortStackAlpha = new universalSortPoCGONEWRONG(
                testStackAlpha);
        universalSortPoCGONEWRONG sortStackWords = new universalSortPoCGONEWRONG(
                testStackWords);
        universalSortPoCGONEWRONG sortStackNums = new universalSortPoCGONEWRONG(
                testStackNums);

        universalSortPoCGONEWRONG sortMapAlpha = new universalSortPoCGONEWRONG(
                testMapAlpha);
        universalSortPoCGONEWRONG sortMapWords = new universalSortPoCGONEWRONG(
                testMapWords);
        universalSortPoCGONEWRONG sortMapNums = new universalSortPoCGONEWRONG(
                testMapNums);

        out.println(sortSequenceAlpha);
        out.println(sortSequenceWords);
        out.println(sortSequenceNums);

        out.println(sortQueueAlpha);
        out.println(sortQueueWords);
        out.println(sortQueueNums);

        out.println(sortSetAlpha);
        out.println(sortSetWords);
        out.println(sortSetNums);

        out.println(sortStackAlpha);
        out.println(sortStackWords);
        out.println(sortStackNums);

        out.println(sortMapAlpha);
        out.println(sortMapWords);
        out.println(sortMapNums);

        out.close();
    }

}