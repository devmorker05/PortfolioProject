package components.universalSort;

/**
 * {@code universalSortKernel} enhanced with secondary methods.
 */
public interface UniversalSort extends UniversalSortKernel {

    /**
     * sorts {@code this} by the size of the indices, smallest to largest.
     *
     * @updates this
     *
     * @ensures this = #this
     */
    void sortSize();

    /**
     * sorts {@code this} alphabetally, while accounting for case
     *
     * @param whichCase
     *            true if the sort have lowercase values going first, false
     *            otherwise
     *
     * @updates this
     *
     * @ensures this = #this
     */
    void sortCaseSensitive(boolean whichCase);

    /**
     * Sorts {@code this} after the substring {@code subS}
     *
     * @param subS
     *            the substring used to sort the data
     *
     * @updates this
     *
     * @ensures this = #this
     */
    void sortSubstring(String subS);
}