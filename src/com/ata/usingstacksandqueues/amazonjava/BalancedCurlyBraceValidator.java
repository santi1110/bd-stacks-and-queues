package ata.usingstacksandqueues.amazonjava;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/**
 * Compiler check that ensures the curly braces in a file are evenly matched. The file must contain an even number of
 * opening and closing curly braces. This check does not perform any validation that the curly braces are in legal
 * locations in the file. [NOTE] Your implementation does not need to handle escaped curly braces within strings
 * literals.
 */
public class BalancedCurlyBraceValidator {

    private boolean debug = false;

    /**
     * Validates that the curly braces in the list of provided file characters are balanced.
     * @param fileCharacters all characters in a java file
     * @return true if the braces are balanced, false otherwise
     */
    public boolean check(List<Character> fileCharacters) {
        Stack<Character> stack = new Stack<>();
        for (char c : fileCharacters) {
            if(c == '{') {
                stack.push(c);
            } else if (c == '}') {
                try {
                    stack.pop();
                } catch(EmptyStackException e) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * Use this to enable or disable additional debug messages.
     * @param debug the value to set the debug variable
     */
    public void setDebug(boolean debug) {
        this.debug = debug;
    }
}
