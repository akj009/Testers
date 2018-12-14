public class MarioQueen {

  public static void main(String[] args) {
    int n = 5, k = 2;
    int []s =
        {3,4,2,1,5};
//        {1,2};

    int currStep = 1;
    String res = (evaluatePath(s, currStep, k))? "YES" : "NO";
    System.out.print(res);
  }

  public static boolean evaluatePath(int []s, int currStep, int k) {
    boolean res = false;
    if(k<=0) {
      return false;
    }

    if((currStep + 1) > s.length) {
      return true;
    } else if(k>1){
      res = evaluatePath(s, currStep + 1, --k);
    }

    if(k>=0 && !res) {
      if(s[currStep] >= s.length) {
        return true;
      } else if(k>1){
        res = evaluatePath(s, s[currStep], --k);
      }
    }
    return res;
  }
}
