package components.universalSort;

import components.standard.Standard;

/**
 * Universal Sort kernel component with primary methods. (Note: by package-wide
 * convention, all references are non-null.)
 */
public interface universalSortKernel extends Standard<universalSort> {

    /*
     * Tracks if this is sorted alphabetically
     *
     * @updates this
     *
     * @ensures {@code this} = true or {@code this} = false
     */
    boolean isSortedAlpha = false;

    /*
     * Tracks if this is sorted numerically
     *
     * @updates this
     *
     * @ensures {@code this} = true or {@code this} = false
     */
    boolean isSortedNum = false;

    /*
     * Tracks if this is reversed
     *
     * @updates this
     *
     * @ensures {@code this} = true or {@code this} = false
     */
    boolean isReversed = false;

    // Kernel Methods

    /*
     * Sorts {@code this} alphabetically
     *
     * @updates this
     *
     * @ensures this = #this
     */
    void sortAlpha() {
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
    void sortNums() {
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
    void reverse() {
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
    int search(T x){
        int index = -1;
        if (this.contains(x)){
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
    int indexSize(int i) {
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
    boolean isSortedAlpha() {
        return this.isSortedAlpha;
    }

    /*
     * Reports the value of isSortedNum for {@code this}
     *
     * @return true if {@code this} is sorted numberically
     *
     * @ensures {@code this} = true or {@code this} = false
     */
    boolean isSortedNum() {
        return this.isSortedNum;
    }

    /*
     * Reports the value of isReversed for {@code this}
     *
     * @return true if {@code this} is reversed
     *
     * @ensures {@code this} = true or {@code this} = false
     */
    boolean isReversed() {
        return this.isReversed;
    }
}
