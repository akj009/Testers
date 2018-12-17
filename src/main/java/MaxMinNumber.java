
import java.util.Map;
import java.util.TreeMap;

/**
 * You are playing a game with N cards. On both sides of each card there is a positive integer. The
 * cards are laid on the table. The score of the game is the smallest positive integer that does not
 * occur on the face-up cards. You may flip some cards over. Having flipped them, you then read the
 * numbers facing up and recalculate the score. What is the maximum score you can achieve?
 *
 * <p>Write a function:
 *
 * <p>class Solution { public int solution(int[] A, int[] B); }
 *
 * <p>that, given two arrays of integers A and B, both of length N, describing the numbers written
 * on both sides of the cards, facing up and down respectively, returns the maximum possible score.
 *
 * <p>For example, given A = [1, 2, 4, 3] and B = [1, 3, 2, 3], your function should return 5, as
 * without flipping any card the smallest positive integer excluded from this sequence is 5.
 *
 * <p>Given A = [4, 2, 1, 6, 5] and B = [3, 2, 1, 7, 7], your function should return 4, as we could
 * flip the first card so that the numbers facing up are [3, 2, 1, 6, 5] and it is impossible to
 * have both numbers 3 and 4 facing up.
 *
 * <p>Given A = [2, 3] and B = [2, 3] your function should return 1, as no matter how the cards are
 * flipped, the numbers facing up are [2, 3].
 *
 * <p>Write an efficient algorithm for the following assumptions:
 *
 * <p>N is an integer within the range [1..100,000]; each element of arrays A, B is an integer
 * within the range [1..100,000,000]; input arrays are of equal size.
 */
public class MaxMinNumber {
  public static int solution2(int[] A, int[] B) {
    TreeMap<String, Integer> inputMap = new TreeMap<>();
    for (int i = 0; i < A.length; i++) {
      inputMap.put(A[i] + ":" + B[i], B[i]);
    }
    System.out.println(inputMap);
    return getAbsentMax(inputMap);
  }

  private static int getAbsentMax(TreeMap<String, Integer> inputMap) {
    int maxAbsent = 1;
    for (Map.Entry<String, Integer> integerEntry : inputMap.entrySet()) {
      int l1 = Integer.parseInt(integerEntry.getKey().split(":")[0]);
      int l2 = integerEntry.getValue();
      int tmp = maxAbsent;
      if (maxAbsent == l1) {
        maxAbsent = l1 + 1;
      }
      if (tmp == l2) {
        tmp = l2 + 1;
      }
      maxAbsent = Math.max(tmp, maxAbsent);
    }
    return maxAbsent;
  }

  public static void main(String[] args) {
    int A[] = {1, 2, 4, 3}, B[] = {1, 3, 2, 3};
    System.out.println(solution2(A, B));

//    int C[] = {4, 2, 1, 6, 5}, D[] = {3, 2, 1, 7, 7};
//    System.out.println(solution2(C, D));
//
//    int E[] = {2, 3}, F[] = {2, 3};
//    System.out.println(solution2(E, F));
//
//    int G[] = {1, 1}, H[] = {2, 1};
//    System.out.println(solution2(G, H));

      int I[] = {1, 1}, J[] = {2, 2};
      System.out.println(solution2(I, J));
  }
}
