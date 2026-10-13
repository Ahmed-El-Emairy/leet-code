import HelperFiles.StackObj;

public class P32_Longest_Valid_Parenthesis {
    public int longestValidParentheses(String s) {

        if (s.length() < 2)
            return 0;

        StackObj indices = new StackObj(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                indices.push(i + 1);
            } else {
                if (!indices.isEmpty() && s.charAt((int) indices.top() - 1) == '(') {
                    indices.pop();
                } else {
                    indices.push(i + 1);
                }
            }
        }

        int max = 0;

        if (indices.isEmpty())
            max = s.length();

        if (!indices.isEmpty())
            max = s.length() - (int) indices.top();

        while (indices.size() > 1) {
            int distance = (int) indices.pop() - (int) indices.top() - 1;
            if (distance > max)
                max = distance;
        }

        int initialLength = 0;
        if (!indices.isEmpty())
            initialLength = (int) indices.top() - 1;

        max = max > initialLength ? max : initialLength;

        return max;
    }
}
