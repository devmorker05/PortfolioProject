package components.universalsort;

import components.standard.Standard;

/**
 * Kernel interface for UniversalSort. Contains the core methods for sorting and
 * reversing sequences.
 */
public interface UniversalSortKernel extends Standard<UniversalSort> {

    /**
     * Sorts this alphabetically.
     *
     * @updates this
     * @ensures this is sorted alphabetically
     */
    void sortAlpha();

    /**
     * Sorts this numerically.
     *
     * @updates this
     * @ensures this is sorted numerically
     */
    void sortNums();

    /**
     * Reverses the order of this.
     *
     * @updates this
     * @ensures the order of this is reversed
     */
    void reverse();

    /**
     * Reports the size of the element at a given index.
     *
     * @param i
     *            the index of the element
     * @return the size of the element at index {@code i}
     * @requires 0 <= i < this.length()
     * @ensures indexSize = |this[i]|
     */
    int indexSize(int i);
}
