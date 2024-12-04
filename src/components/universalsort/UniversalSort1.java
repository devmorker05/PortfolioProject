package components.universalsort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Kernel implementation of UniversalSort. Representation: An
 * {@code ArrayList<String>} storing non-null strings.
 */
public class UniversalSort1 implements UniversalSort {

    /**
     * Concrete representation of the list.
     */
    public ArrayList<String> list;

    /**
     * Constructor. Initializes an empty representation.
     */
    public UniversalSort1() {
        this.createNewRep();
    }

    /**
     * Creates a new, empty representation.
     */
    private void createNewRep() {
        this.list = new ArrayList<>();
    }

    /**
     * Convention: All elements in {@code list} are non-null strings.
     * Correspondence: The abstract list {@code this} is represented as the
     * concrete {@code ArrayList<String>} list.
     */

    // Standard Methods

    @Override
    public void clear() {
        this.createNewRep();
    }

    @Override
    public UniversalSort1 newInstance() {
        return new UniversalSort1();
    }

    @Override
    public void transferFrom(UniversalSort source) {
        assert source instanceof UniversalSort1 : "Violation of: source is UniversalSortArrayList";
        UniversalSort1 localSource = (UniversalSort1) source;
        this.list = localSource.list;
        localSource.createNewRep();
    }

    // Kernel Methods

    @Override
    public void sortAlpha() {
        Collections.sort(this.list);
    }

    @Override
    public void sortNums() {
        this.list.sort((s1, s2) -> {
            int num1 = Integer.parseInt(s1);
            int num2 = Integer.parseInt(s2);
            return Integer.compare(num1, num2);
        });
    }

    @Override
    public void reverse() {
        Collections.reverse(this.list);
    }

    @Override
    public int indexSize(int i) {
        return this.list.get(i).length();
    }

    @Override
    public void sortSize() {
        this.list.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
    }

    @Override
    public void sortCaseSensitive(boolean caseSensitive) {
        if (caseSensitive) {
            this.list.sort(String::compareTo);
        } else {
            this.list.sort(String.CASE_INSENSITIVE_ORDER);
        }
    }

    @Override
    public void sortSubstring(String subS) {
        this.list.sort((s1, s2) -> {
            boolean contains1 = s1.contains(subS);
            boolean contains2 = s2.contains(subS);
            return Boolean.compare(contains2, contains1);
        });
    }
}
