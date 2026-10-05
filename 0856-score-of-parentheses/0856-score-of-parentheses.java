import java.util.*;

class Solution {
    public int scoreOfParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                stack.push(0);
            } 
            else {
                int inside = stack.pop();

                int score = Math.max(2 * inside, 1);

                int previous = stack.pop();

                stack.push(previous + score);
            }
        }

        return stack.pop();
    }
}