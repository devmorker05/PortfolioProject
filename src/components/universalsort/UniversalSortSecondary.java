package components.universalsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/*
 * Layered implementations of secondary methods for {@code universalSort}
 */
public abstract class UniversalSortSecondary implements UniversalSort {

    public ArrayList<String> list;

    // Standard Methods

    @Override
    public void clear() {
        this.clear();
    }

    @Override
    public UniversalSortSecondary newInstance() {
    }

    @Override
    public void transferFrom(UniversalSort source) {
        assert source instanceof UniversalSortSecondary : "Violation of: source is UniversalSortArrayList";
        UniversalSortSecondary localSource = (UniversalSortSecondary) source;
        this.list = localSource.list;
        localSource.clear();
    }

    @Override
    public String toString() {
        return this.list.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        UniversalSortSecondary that = (UniversalSortSecondary) obj;
        return Objects.equals(this.list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.list);
    }

    /*
     * Common methods (from universalSortKernel)-------------------------------
     */

    @Override
    public void sortAlpha() {
        Collections.sort(this.list);
    }

    @Override
    public void sortNums() {
        Collections.sort(this.list);
    }

    @Override
    public void reverse() {
        Collections.reverse(this.list);
    }

    /*
     * returns the index of `T x` in {@code this}
     *
     * @param x the {@code x} for the value searched for
     *
     * @return the index if {@code T x} exists, -1 if otherwise
     *
     * @ensure this >= -1
     */
    public int search(String x) {
        int index = -1;
        if (this.list.contains(x)) {
            index = this.list.indexOf(x);
        }
        return index;
    }

    /*
     * Reports the size of {@code this} from {@code i}
     *
     * @param i the {@code int} for the index
     *
     * @return the length
     *
     * @ensures this >= 0
     */
    @Override
    public int indexSize(int i) {
        String index = this.list.get(i);
        return index.length();
    }

    /*
     * Other non-kernel methods -----------------------------------------------
     */

    /*
     * Sorts {@code this} by the size of the indices
     *
     * @updates this
     *
     * @ensures this = #this
     */
    @Override
    public void sortSize() {
        this.list.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
    }

    /*
     * Sorts {@code this} alphabetically with emphasis on case based on {@code
     * case}
     *
     * @param case the {@code boolean} for the case, with true prioritizing
     * uppercase letters
     *
     * @updates this
     *
     * @ensures this = #this
     */
    @Override
    public void sortCaseSensitive(boolean whichCase) {
        ArrayList<String> upperCase = new ArrayList<String>();
        ArrayList<String> lowerCase = new ArrayList<String>();
        for (int i = 0; i < this.list.size(); i++) {
            if (Character.isUpperCase(i)) {
                upperCase.add(this.list.get(i));
            } else {
                lowerCase.add(this.list.get(i));
            }
        }
        Collections.sort(upperCase);
        Collections.sort(lowerCase);
        this.list.clear();
        if (whichCase == true) {
            int i = 0;
            while (upperCase.size() != 0) {
                this.list.add(upperCase.get(i));
                i++;
            }
            i = 0;
            while (lowerCase.size() != 0) {
                this.list.add(lowerCase.get(i));
                i++;
            }
        } else {
            int i = 0;
            while (lowerCase.size() != 0) {
                this.list.add(lowerCase.get(i));
                i++;
            }
            i = 0;
            while (upperCase.size() != 0) {
                this.list.add(upperCase.get(i));
                i++;
            }
        }
    }

    /*
     * Sorts {@code this} after the substring {@code s}
     *
     * @param s the {@code String} that stays the same
     *
     * @updates this
     *
     * @ensures this = #this
     */
    @Override
    public void sortSubstring(String subS) {
        assert subS != null : "subS must not be null";
        this.list.sort((s1, s2) -> {
            boolean contains1 = s1.contains(subS);
            boolean contains2 = s2.contains(subS);
            return Boolean.compare(contains2, contains1);
        });
    }
}
