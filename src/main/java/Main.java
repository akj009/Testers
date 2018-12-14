public class Main {

  public static void main(String[] args) {
    System.out.println("Hello World!");

    String s;
    s = getS();
    if (null == s) {
      System.out.println("S IS NULL");
    }

    String a = Integer.toString(1234) + 1000 + 12;
    System.out.println(a);

    System.out.println(returnTryParadox());
  }

  private static String getS() {
    return null;
  }

  private static int returnTryParadox() {
    try {
      System.out.println("in try");
      int t = 10 / 0;
      return 1;
    } catch (Exception e) {
      System.out.println("in catch");
      return 2;
    } finally {
      return 3;
    }
  }
}
