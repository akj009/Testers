public class NoConsecutiveThrees {
    
    public static String solution(int A, int B) {
        int difference = A - B;
        return generateFinalString(A, B , difference);
    }

    private static String generateFinalString(int first, int second, int diff) {
        if(diff > 0) {
            return generateString("a", "b", diff, first, second);
        } else {
            diff *= -1;
            int tmp = second;
            second = first;
            first = tmp;
            return generateString("b", "a", diff, first, second);
        }
    }

    private static String generateString(String firstChar, String secondChar, int diff, int first, int second) {
        int totalLength = first + second;
        int currLength = 0;
        StringBuilder res = new StringBuilder();
        while(currLength < totalLength) {
            while(diff-- > 0) {
                if(first > 1) {
                    res.append(firstChar).append(firstChar);
                    first -= 2;
                }
                if(second > 0) {
                    res.append(secondChar);
                    second -= 1;
                }
            }
            if(first-- > 0) {
                res.append(firstChar);
            }
            if(second-- > 0) {
                res.append(secondChar);
            }
            
            currLength = res.length();
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 3));
        System.out.println(solution(3, 3));
        System.out.println(solution(1, 4));
        System.out.println(solution(4, 1));
        System.out.println(solution(1, 1));
        System.out.println(solution(2, 1));
        System.out.println(solution(0, 1));
        System.out.println(solution(1, 0));
        System.out.println(solution(100, 50));
    }
}