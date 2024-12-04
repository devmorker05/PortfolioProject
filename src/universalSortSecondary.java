package components.universalSort;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Layered implementations of secondary methods for {@code universalSort}
 */
public abstract class UniversalSortSecondary implements UniversalSort {
    /*
     * Public members ---------------------------------------------------------
     */

    /*
     * Tracks if this is sorted alphabetically
     *
     * @updates this
     *
     * @ensures {@code this} = true or {@code this} = false
     */
    @Override
    public boolean isSortedAlpha = false;

    /*
     * Tracks if this is sorted numerically
     *
     * @updates this
     *
     * @ensures {@code this} = true or {@code this} = false
     */
    @Override
    public boolean isSortedNum = false;

    /*
     * Tracks if this is reversed
     *
     * @updates this
     *
     * @ensures {@code this} = true or {@code this} = false
     */
    @Override
    public boolean isReversed = false;

    /*
     * Common methods (from universalSortKernel)-------------------------------
     */

    /*
     * Sorts {@code this} alphabetically
     *
     * @updates this
     *
     * @ensures this = #this
     */
    @Override
    public void sortAlpha() {
        if (!this.isSortedAlpha()) {
            Collections.sort(this);
            this.isSortedAlpha = true;
        }
    }

    /*
     * Sorts {@code this} numerically
     *
     * @updates this
     *
     * @ensures this = #this
     */
    @Override
    public void sortNums() {
        if (!this.isSortedNum()) {
            Collections.sort(this);
            this.isSortedNum = true;
        }
    }

    /*
     * Reverses {@code this}
     *
     * @updates this
     *
     * @ensures this = #this
     */
    @Override
    public void reverse() {
        if (!this.isReversed()) {
            Collections.sort(this);
            this.isReversed = true;
        }
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
    @Override
    public int search(T x) {
        int index = -1;
        if (this.contains(x)) {
            index = this.indexOf(x);
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
        String index = this.get(i);
        return index.length();
    }

    /*
     * Reports the value of isSortedAlpha for {@code this}
     *
     * @return true if {@code this} is sorted alphabetically
     *
     * @ensures {@code this} = true or {@code this} = false
     */
    @Override
    public boolean isSortedAlpha() {
        return this.isSortedAlpha;
    }

    /*
     * Reports the value of isSortedNum for {@code this}
     *
     * @return true if {@code this} is sorted numberically
     *
     * @ensures {@code this} = true or {@code this} = false
     */
    @Override
    public boolean isSortedNum() {
        return this.isSortedNum;
    }

    /*
     * Reports the value of isReversed for {@code this}
     *
     * @return true if {@code this} is reversed
     *
     * @ensures {@code this} = true or {@code this} = false
     */
    @Override
    public boolean isReversed() {
        return this.isReversed;
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
        for (int i = 0; i < this.length() - 1; i++) {
            if (this.indexSize(i) > this.indexSize(i + 1)) {
                T temp = arr[i];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
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
    public void sortCaseSensitive(boolean case) {
        ArrayList<T> upperCase = new ArrayList<T>();
        ArrayList<T> lowerCase = new ArrayList<T>();
        for (int i = 0; i < this.length(); i++) {
            if (Character.isUpperCase(i)) {
                upperCase.add(i);
            } else {
                lowerCase.add(i);
            }
        }
        Collections.sort(upperCase);
        Collections.sort(lowerCase);
        this.clear();
        if (case == true) {
            this.add(upperCase);
            this.add(lowerCase);
        } else {
            this.add(lowerCase);
            this.add(upperCase);
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
    public sortSubstring(String s) {
        ArrayList removed = this.remove(s);
        Collections.sort(removed);
        this.clear();
        this.add(s);
        this.add(removed);
    }
}
