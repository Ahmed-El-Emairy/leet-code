import HelperFiles.StackObj;

public class P20_Valid_Parenthesis {
    public static boolean isValid(String s) {
        StackObj stack = new StackObj(s.length());

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[')
                stack.push(currentChar);
            else {

                if (stack.isEmpty())
                    return false;

                char lastCharacter = (char) stack.top();
                if (currentChar == ')' && lastCharacter == '(')
                    stack.pop();
                else if (currentChar == '}' && lastCharacter == '{')
                    stack.pop();
                else if (currentChar == ']' && lastCharacter == '[')
                    stack.pop();
                else
                    return false;
            }
        }

        return stack.isEmpty() ? true : false;
    }
}
