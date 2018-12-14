import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ProtobufTester {

  public static void main(String[] args) {
    //
    /*TreeMap<String, Integer> stringIntegerTreeMap = new TreeMap<String, Integer>(){{
      put("holly", 3);
      put("bolly", 4);
      put("tolly", 1);
      put("sholly", 10);
    }};

    System.out.println(stringIntegerTreeMap);
    System.out.println(stringIntegerTreeMap.firstKey());
    test();
    test2();*/

//    P p = new C();
    //    p.somemethod("2");
  }
  }

 /* public static void test() {
    TreeMap<String, String> treeMap = new TreeMap<String, String>();
    treeMap.put("1", "One");
    treeMap.put("2", "Two");
    treeMap.put("3", "Three");
    treeMap.put("4", "Four");
    treeMap.put("5", "Five");

    System.out.println("Lowest key: " + treeMap.firstKey());
    System.out.println("Highest key: " + treeMap.lastKey());
  }

  public static void test2() {
    Map<String, Integer> hashMap = new HashMap<>();
    hashMap.put("One", 1);
    hashMap.put("Four", 4);
    hashMap.put("Two", 2);
    hashMap.put("Three", 3);
    hashMap.put("Five", 5);

    Map<String, Integer> sortedMap = hashMap.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    System.out.println(sortedMap);
  }
}

class P {

  void somemethod(double d) {
    System.out.println("P.somemethod()");
  }
}


class C extends P{

  void somemethod(double d) {
    System.out.println("C.somemethod() - d");
  }

  void somemethod(String a) {
    System.out.println("C.somemethod() - i");
  }
}
*/