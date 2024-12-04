import components.universalsort.UniversalSort1;

public class UniversalSortExample2 {
    public static void main() {
        UniversalSort1 example = new UniversalSort1();
        example.list.add("elephant");
        example.list.add("ant");
        example.list.add("hippopotamus");

        System.out.println("Original List: " + example);
        example.sortSize();
        System.out.println("Sorted by Size: " + example);
        example.sortSubstring("ant");
        System.out.println("Sorted by Substring 'ant': " + example);
    }
}
