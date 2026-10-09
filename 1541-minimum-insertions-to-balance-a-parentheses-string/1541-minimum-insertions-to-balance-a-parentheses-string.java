
class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int insertions = 0;

        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                open++;
                i++;
            } else {
                // Check whether the next character is ')'
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    // We have a complete closing pair
                    i += 2;
                } else {
                    // Insert one ')' to complete the pair
                    insertions++;
                    i++;
                }

                if (open > 0) {
                    open--;
                } else {
                    // Insert '(' to match the closing pair
                    insertions++;
                }
            }
        }

        // Each unmatched '(' needs two closing ')'
        insertions += open * 2;

        return insertions;
    }
}
