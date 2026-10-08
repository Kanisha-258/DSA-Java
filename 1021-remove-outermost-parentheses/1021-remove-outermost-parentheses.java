class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int depth = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                // Not an outermost '('
                if (depth > 0) {
                    result.append(ch);
                }
                depth++;
            } 
            else {
                depth--;

                // Not an outermost ')'
                if (depth > 0) {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }
}