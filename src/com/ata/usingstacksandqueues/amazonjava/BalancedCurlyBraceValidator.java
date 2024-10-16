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
        int maxUnbalanced = 0;
        int unbalancedCount = 0;
        int longestBetweenBraces = 0;
        int currentCountBetweenBraces = 0;
        boolean insideBraces = false;
        int remainingOpenBraces = 0;
        int remainingCloseBraces = 0;

        for (char c : fileCharacters) {
            if (c == '{') {
                stack.push(c);
                unbalancedCount++;
                insideBraces = true;
                currentCountBetweenBraces = 0; // Reset the counter
                if (unbalancedCount > maxUnbalanced) {
                    maxUnbalanced = unbalancedCount;
                }
            } else if (c == '}') {
                try {
                    stack.pop();
                    unbalancedCount--;
                    if (insideBraces) {
                        if (currentCountBetweenBraces > longestBetweenBraces) {
                            longestBetweenBraces = currentCountBetweenBraces;
                        }
                        insideBraces = false;
                    }
                } catch (EmptyStackException e) {
                    remainingCloseBraces++;
                    return false;  // Unbalanced because there is no matching '{'
                }
            } else if (insideBraces) {
                // Count the characters between braces
                currentCountBetweenBraces++;
            }
        }

        // If the stack is not empty, there are unbalanced opening braces left
        remainingOpenBraces = stack.size();

        if (debug) {
            System.out.println("Maximum unbalanced braces encountered: " + maxUnbalanced);
            System.out.println("Remaining unbalanced opening braces: " + remainingOpenBraces);
            System.out.println("Remaining unbalanced closing braces: " + remainingCloseBraces);
            System.out.println("Longest sequence between balanced braces: " + longestBetweenBraces);
        }

        // If the stack is empty, the braces are balanced
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
