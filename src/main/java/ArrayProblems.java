import java.util.HashMap;
import java.util.Map;

public class ArrayProblems {
    public static void main(String[] args) {
        System.out.println(":::: started:");
        pairWithSumZero();
        pairFarthestFromZero();
        maxElementInIncreasingDecreasingArray();
        pairInTwoArrays();
    }

    // 1. Pair in an array of integers whose sum is equal to zero
    /**
     * time - O(n)
     * space - O(n)
     */
    public static void pairWithSumZero() {
        int[] input = new int[] {-1,2,4,1,3,-2};
        Map<Integer, Integer> numTrackMap = new HashMap<>();
        System.out.println(" - Pairs with sum as zero\n");
        for (int i = 0; i < input.length; i++) {
            if(numTrackMap.containsKey(-1 * input[i])) {
                System.out.println(String.format("   (%d,%d)", numTrackMap.get(-1 * input[i]) + 1, i + 1));
            } else {
                numTrackMap.put(input[i], i);
            }
        }
    }

    // 2. Pair in an array of integers whose sum is farthest from zero
    /**
     * time - O(n)
     * space - O(1)
     */
    public static void pairFarthestFromZero() {
        int[] input = new int[] {-1,2,4,1,3,-2};
        int largestNum = Integer.MIN_VALUE;
        int secondLargestNum = Integer.MIN_VALUE;
        int largestNumIdx = -1;
        int secondLargestNumIdx = -1;
        for (int i = 0; i < input.length; i++) {
            if(input[i] >= largestNum) {
                secondLargestNum = largestNum;
                largestNum = input[i];
                secondLargestNumIdx = largestNumIdx;
                largestNumIdx = i;
            } else if(input[i] > secondLargestNum) {
                secondLargestNum = input[i];
                secondLargestNumIdx = i;
            }
        }
        System.out.println("\n - Pair with sum farthest from zero\n");
        System.out.println(String.format(
            "   Sum: %d, Numbers: (%d, %d), Indexes: (%d, %d)",
            largestNum + secondLargestNum,
            largestNum, secondLargestNum,
            largestNumIdx + 1, secondLargestNumIdx + 1)
        );
    }

    // 3. Find the maximum element in an array which is first increasing and then decreasing
    /**
     * time - O(log n)
     * space - O(1)
     */
    public static void maxElementInIncreasingDecreasingArray() {
        int[] input = new int[] {1,3,5,4,6,7,8,2,0,-1,-2,-3,-5,-9,10,-12,-14};
        int maxNum = findMax(input, 0, input.length - 1);
        System.out.println("\n - Max number in array which is first increasing and then decreasing");
        System.out.println("\n   " + maxNum);
    }

    private static int findMax(int[] arr, int startIdx, int endIdx) {
        int midIdx = (startIdx + endIdx) / 2;
        int maxEl = arr[midIdx];
        if(startIdx == endIdx) {
            return maxEl;
        }
        if(arr[midIdx + 1] > maxEl) {
            return findMax(arr, midIdx, endIdx);
        } else if(arr[midIdx - 1] > maxEl) {
            return findMax(arr, startIdx, midIdx);
        } else {
            return maxEl;
        }
    }



    // 4. Given two unsorted arrays, print all pairs with sum as x
    /**
     * time - O(n + m)
     * space - O(n)
     */
    public static void pairInTwoArrays() {
        int[] input1 = new int[] {-1,2,4,1,3,-2};
        int[] input2 = new int[] {1,3,5,4,6,7,8,2,0,-1,-2,-3,-5,-9,10,-12,-14};

        int targetSum = 7;
        
        System.out.println("\n - Pairs with sum as target number in 2 unsorted arrays\n");
        Map<Integer, Integer> input1TrackMap = new HashMap<>();
        for (int i = 0; i < input1.length; i++) {
            input1TrackMap.put(targetSum - input1[i], input1[i]);
        }
        
        for (int i = 0; i < input2.length; i++) {
            int key = input2[i];
            if(input1TrackMap.containsKey(key)) {
                System.out.println(String.format("   (%d, %d)", input1TrackMap.get(key), input2[i]));
            }
        }
    }

}