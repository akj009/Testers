import java.util.Vector;

public class CollectionsTest {
  public static void main(String[] args) {
    System.out.println(":::: started: ");
    testVectorContainsAll();
  }

    private static void testVectorContainsAll() {
        Vector<String> left = new Vector<String>() {{ add("1"); add("2"); }};
        Vector<String> right = new Vector<String>() {{ add("2"); add("1"); }};
        System.out.println(left.containsAll(right));
    }
}
