import static org.junit.Assert.assertEquals;

import components.universalsort.UniversalSort;
import components.universalsort.UniversalSort1;

public abstract class UniversalSort1Test {

        /**
         * Invokes the appropriate {@code UniversalSort} constructor for the
         * implementation under test and returns the result.
         *
         * @return the new {@code UniversalSort}
         * @requires this != null
         * @ensures constructorTest = ()
         */
        protected abstract UniversalSort constructorTest();

        private UniversalSort1 test;

        @BeforeEach
        void setUp() {
                this.test = new UniversalSort1();
        }

        @Test
        void testClear() {
                this.test.list.add("test");
                this.test.clear();
                assertTrue(this.test.list.isEmpty());
        }

        @Test
        void testNewInstance() {
                UniversalSort1 newInstance = (UniversalSort1) this.test
                                .newInstance();
                assertTrue(newInstance.list.isEmpty());
        }

        @Test
        void testTransferFrom() {
                UniversalSort1 other = new UniversalSort1();
                other.list.add("data");
                this.test.transferFrom(other);
                assertTrue(other.list.isEmpty());
                assertEquals(1, this.test.list.size());
        }

        @Test
        void testSortAlpha() {
                this.test.list.add("zebra");
                this.test.list.add("apple");
                this.test.list.add("banana");
                this.test.sortAlpha();
                assertEquals("[apple, banana, zebra]",
                                this.test.list.toString());
        }

        @Test
        void testSortNums() {
                this.test.list.add("3");
                this.test.list.add("1");
                this.test.list.add("2");
                this.test.sortNums();
                assertEquals("[1, 2, 3]", this.test.list.toString());
        }

        @Test
        void testReverse() {
                this.test.list.add("a");
                this.test.list.add("b");
                this.test.list.add("c");
                this.test.reverse();
                assertEquals("[c, b, a]", this.test.list.toString());
        }

        @Test
        void testIndexSize() {
                this.test.list.add("hello");
                this.test.list.add("world");
                int size = this.test.indexSize(0);
                assertEquals(5, size);
        }

        @Test
        void testSortSize() {
                this.test.list.add("cat");
                this.test.list.add("elephant");
                this.test.list.add("dog");
                this.test.sortSize();
                assertEquals("[cat, dog, elephant]", this.test.list.toString());
        }

        @Test
        void testSortCaseSensitive() {
                this.test.list.add("apple");
                this.test.list.add("Banana");
                this.test.list.add("apple");
                this.test.sortCaseSensitive(true);
                assertEquals("[Banana, apple, apple]",
                                this.test.list.toString());
                this.test.sortCaseSensitive(false);
                assertEquals("[apple, apple, Banana]",
                                this.test.list.toString());
        }

        @Test
        void testSortSubstring() {
                this.test.list.add("cat");
                this.test.list.add("dog");
                this.test.list.add("bat");
                this.test.sortSubstring("at");
                assertEquals("[cat, bat, dog]", this.test.list.toString());
        }

        @Test
        void testEquals() {
                UniversalSort1 other = new UniversalSort1();
                this.test.list.add("test");
                other.list.add("test");
                assertTrue(this.test.equals(other));
                other.list.add("extra");
                assertFalse(this.test.equals(other));
        }

        @Test
        void testToString() {
                this.test.list.add("a");
                this.test.list.add("b");
                assertEquals("[a, b]", this.test.toString());
        }

        @Test
        void testHashCode() {
                UniversalSort1 other = new UniversalSort1();
                this.test.list.add("test");
                other.list.add("test");
                assertEquals(this.test.hashCode(), other.hashCode());
        }
}