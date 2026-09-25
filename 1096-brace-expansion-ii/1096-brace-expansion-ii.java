import java.util.*;

class Solution {

    private String expression;
    private int index = 0;

    public List<String> braceExpansionII(String expression) {
        this.expression = expression;

        Set<String> result = parseExpression();

        List<String> answer = new ArrayList<>(result);
        Collections.sort(answer);

        return answer;
    }

    // Handles union: expr , expr
    private Set<String> parseExpression() {
        Set<String> result = parseTerm();

        while (index < expression.length()
                && expression.charAt(index) == ',') {

            index++; // skip ','

            Set<String> next = parseTerm();
            result.addAll(next);
        }

        return result;
    }

    // Handles concatenation: term term term...
    private Set<String> parseTerm() {
        Set<String> result = new HashSet<>();
        result.add("");

        while (index < expression.length()
                && expression.charAt(index) != '}'
                && expression.charAt(index) != ',') {

            Set<String> factor = parseFactor();

            Set<String> temp = new HashSet<>();

            for (String s1 : result) {
                for (String s2 : factor) {
                    temp.add(s1 + s2);
                }
            }

            result = temp;
        }

        return result;
    }

    // Handles a single letter OR {...}
    private Set<String> parseFactor() {

        Set<String> result = new HashSet<>();

        char ch = expression.charAt(index);

        // Single lowercase letter
        if (Character.isLetter(ch)) {
            result.add(String.valueOf(ch));
            index++;
        }

        // Braced expression
        else if (ch == '{') {
            index++; // skip '{'

            result = parseExpression();

            index++; // skip '}'
        }

        return result;
    }
}