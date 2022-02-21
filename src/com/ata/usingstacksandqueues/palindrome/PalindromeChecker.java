package ata.usingstacksandqueues.palindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Contains logic to validate whether a provided input is a palindrome.
 */
public class PalindromeChecker {

    /**
     * Takes a queue of integers as a parameter and returns true if the numbers in the queue represent a palindrome
     * (and false otherwise). A sequence of numbers is considered a palindrome if it is the same in reverse order.
     * For example, suppose a queue called q stores these values:
     *
     * front [3, 8, 17, 9, 17, 8, 3] back
     *
     * Then the call to isPalindrome(q); should return true because this sequence is the same in reverse order.
     *
     * If the queue had instead stored these values:
     *
     * front [3, 8, 17, 9, 4, 17, 8, 3] back
     *
     * The call to isPalindrome would instead return false because this sequence is not the same in reverse order
     * (the 9 and 4 in the middle don't match).
     *
     * The empty queue should be considered a palindrome. You may not make any assumptions about how many elements are
     * in the queue and your method must restore the queue so that it stores the same sequence of values after the call
     * as it did before.
     *
     * @param q the queue of integers to inspect for the palindrome quality
     * @return true if the numbers in the queue represent a palindrome, false otherwise
     */
    public static boolean isPalindrome(Queue<Integer> q) {
        if(q.isEmpty()){
            return true;
        }
        Queue<Integer> copyQ = new LinkedList<>(q);
        Stack<Integer> s = new Stack<>();
        int size = copyQ.size();
        for(int i = 0; i < size; i++){
            int x = copyQ.remove();
            copyQ.add(x);
            s.push(x);
        }

        while(!copyQ.isEmpty()) {
            if(copyQ.remove() != s.pop()) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean isPalindromeGeneric(Queue<T> q) {
        if(q.isEmpty()){
            return true;
        }
        Queue<T> copyQ = new LinkedList<>(q);
        Stack<T> s = new Stack<>();
        int size = copyQ.size();
        for(int i = 0; i < size; i++){
            T x = copyQ.remove();
            copyQ.add(x);
            s.push(x);
        }

        while(!copyQ.isEmpty()) {
            if(copyQ.remove() != s.pop()) {
                return false;
            }
        }
        return true;
    }
}
