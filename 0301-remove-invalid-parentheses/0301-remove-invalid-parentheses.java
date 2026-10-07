import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String current = queue.poll();

                // If valid, add it to result
                if (isValid(current)) {
                    result.add(current);
                    found = true;
                }

                // If we already found valid strings at this level,
                // don't generate strings with more removals
                if (found) {
                    continue;
                }

                // Try removing each parenthesis
                for (int j = 0; j < current.length(); j++) {

                    char ch = current.charAt(j);

                    // Only remove parentheses
                    if (ch != '(' && ch != ')') {
                        continue;
                    }

                    String next =
                        current.substring(0, j) +
                        current.substring(j + 1);

                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }

            // Minimum removals found
            if (found) {
                break;
            }
        }

        return result;
    }

    // Checks whether a string has valid parentheses
    private boolean isValid(String s) {

        int balance = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                balance++;
            } 
            else if (ch == ')') {
                balance--;

                // More closing than opening
                if (balance < 0) {
                    return false;
                }
            }
        }

        return balance == 0;
    }
}