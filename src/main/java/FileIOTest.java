import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileIOTest {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    System.out.println(":::: started:");
    System.out.println(":::: current directory: " + System.getProperty("user.dir"));
    Path p = Paths.get("src/main/resources/prod.mapping");
    System.out.println(p);
    System.out.println(Files.readAllLines(p));

//    test1();
    // writeMapInFile();
//    readMapFromFile();
  }

  private static void writeMapInFile() throws IOException {
    Map<String, String> myMap = new HashMap<String, String>(){{
      put("k1", "v1");
      put("k2", "v2");
    }};
    File file = new File("src/main/resources/nFile1.dat");
    if(!file.exists()) {
      boolean created = file.createNewFile();
    }
    FileOutputStream fos = new FileOutputStream(file);
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(myMap);
    oos.close();
    fos.close();
    Scanner scanner = new Scanner(System.in);
    int i = scanner.nextInt();
    System.out.println(i);
  }

  private static void readMapFromFile() throws IOException, ClassNotFoundException {
    File file = new File("src/main/resources/testsurvey.dat");
    if(!file.exists()) {
      return;
    }

    FileInputStream fis = new FileInputStream(file);
    ObjectInputStream objectInputStream = new ObjectInputStream(fis);
    Map<String, String> myMap = (Map<String, String>) objectInputStream.readObject();
    System.out.println(myMap);
  }

  private static void test1() throws IOException {
    Path p1 = Paths.get("src/main/resources/mtp1");
    List<String> list = Files.readAllLines(p1);
    Map<String, Long> map = new HashMap<>();
    list.forEach(s -> {
      String[] kv = s.split(": ");
      if(map.containsKey(kv[0])) {
        Long st = map.get(kv[0]);
        map.put(kv[0], Long.parseLong(kv[1].trim())-st);
      } else {
        map.put(kv[0],Long.parseLong(kv[1].trim()));
      }
    });

    System.out.println(map);
  }
}
