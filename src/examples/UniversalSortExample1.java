import components.universalsort.UniversalSort1;

public class UniversalSortExample1 {
    public static void main() {
        UniversalSort1 example = new UniversalSort1();
        example.list.add("banana");
        example.list.add("apple");
        example.list.add("cat");

        System.out.println("Original List: " + example);
        example.sortAlpha();
        System.out.println("Alphabetically Sorted: " + example);
        example.reverse();
        System.out.println("Reversed List: " + example);
    }
}