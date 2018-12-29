import models.Stack;

/**
 * Given a string containing alphanumeric characters, calculate sum of all numbers present in the string.
 * Example: 
 * Input: 1Hello28worl2
 * Output: 31
 */

public class SumOfNumbersInString {

    /**
     * time - O(n)
     * space - O(n)
     * @param input
     * @return
     */
    private static int getSumOfNumbers1(String input) {
        Stack<Character> numStack = new Stack<>();
        int sum = 0;
        for(char c : input.toCharArray()) {
            if(isNum(c)) {
                numStack.push(c);
            } else {
                if(numStack.size()>0) {
                    sum += popNumbers(numStack);
                }
            }
        }
        if(numStack.size()>0) {
            sum += popNumbers(numStack);
        }
        return sum;
    }

    /**
     * time - O(n)
     * space - O(1)
     * 
     * @param input
     * @return
     */
    private static int getSumOfNumbers2(String input) {
        int sum = 0;
        int stIdx = -1;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(isNum(c) && stIdx < 0) {
                stIdx = i;
            } else if(stIdx >= 0 && !isNum(c)) {
                sum += Integer.parseInt(input.substring(stIdx, i));
                stIdx = -1;
            }
        }
        if(stIdx >= 0) {
            sum += Integer.parseInt(input.substring(stIdx));
        }
        return sum;
    }

    private static int popNumbers(Stack<Character> numberStack) {
        StringBuilder s = new StringBuilder();
        while(null != numberStack.peek()) {
            s.append(numberStack.pop());
        }
        return Integer.parseInt(s.reverse().toString());
    }

    private static boolean isNum(char c) {
        return (c>='0' && c<='9');
    }

    public static void main(String[] args) {
        System.out.println(":::: started:");
        String input = "1Hello28worl2i3";
        // System.out.println("\nSum of numbers in " + input + ": " + getSumOfNumbers1(input));
        System.out.println("\nSum of numbers in " + input + ": " + getSumOfNumbers2(input));
    }
}