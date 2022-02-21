package ata.usingstacksandqueues.palindrome;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeCheckerTest {

    @Test
    public void isPalindrome_emptyInput_returnsTrue() {
        // GIVEN
        Queue<Integer> integers = new LinkedList<>();

        //WHEN
        boolean result = PalindromeChecker.isPalindrome(integers);

        //THEN
        assertTrue(result, "Expected an empty input to return true.");
    }

    @Test
    public void isPalindrome_inputSize1_returnsTrue() {
        // GIVEN
        Queue<Integer> integers = new LinkedList<>(ImmutableList.of(3));

        //WHEN
        boolean result = PalindromeChecker.isPalindrome(integers);

        //THEN
        assertTrue(result, "Expected an input of size 1 to return true.");
    }

    @Test
    public void isPalindrome_notPalindromeEvenLength_returnsFalse() {
        // GIVEN
        Queue<Integer> integers = new LinkedList<>(ImmutableList.of(3, 8, 17, 9, 9, 17, 8, 2));

        //WHEN
        boolean result = PalindromeChecker.isPalindrome(integers);

        //THEN
        assertFalse(result, "Expected an even length non palindrome to return false.");
    }

    @Test
    public void isPalindrome_notPalindromeOddLength_returnsFalse() {
        // GIVEN
        Queue<Integer> integers = new LinkedList<>(ImmutableList.of(3, 8, 17, 9, 17, 9, 3));

        //WHEN
        boolean result = PalindromeChecker.isPalindrome(integers);

        //THEN
        assertFalse(result, "Expected an odd length non palindrome to return false.");
    }

    @Test
    public void isPalindrome_palindromeEvenLength_returnsTrue() {
        // GIVEN
        Queue<Integer> integers = new LinkedList<>(ImmutableList.of(3, 8, 17, 9, 9, 17, 8, 3));

        //WHEN
        boolean result = PalindromeChecker.isPalindrome(integers);

        //THEN
        assertTrue(result, "Expected an even length palindrome to return true.");
    }

    @Test
    public void isPalindrome_palindromeOddLength_returnsTrue() {
        // GIVEN
        Queue<Integer> integers = new LinkedList<>(ImmutableList.of(3, 8, 17, 9, 17, 8, 3));

        //WHEN
        boolean result = PalindromeChecker.isPalindrome(integers);

        //THEN
        assertTrue(result, "Expected an odd length palindrome to return true.");
    }

    @Test
    public void isPalindrome_notPalindrome_doesNotDestroyInputQueue() {
        // GIVEN
        Queue<Integer> integers = new LinkedList<>(ImmutableList.of(3, 8, 1, 9, 17, 8, 3));
        Queue<Integer> copy = new LinkedList<>(integers);

        //WHEN
        PalindromeChecker.isPalindrome(integers);

        //THEN
        assertEquals(copy, integers, "Expected input queue to not change.");
    }

    @Test
    public void isPalindrome_palindrome_doesNotDestroyInputQueue() {
        // GIVEN
        Queue<Integer> integers = new LinkedList<>(ImmutableList.of(3, 8, 17, 9, 17, 8, 3));
        Queue<Integer> copy = new LinkedList<>(integers);

        //WHEN
        PalindromeChecker.isPalindrome(integers);

        //THEN
        assertEquals(copy, integers, "Expected input queue to not change.");
    }

    @Test
    public void isPalindromeGeneric_characterInput_returnsTrue() {
        // GIVEN
        Queue<Character> characters = new LinkedList<>(ImmutableList.of('t', 'a', 'c', 'o', 'c', 'a', 't'));

        //WHEN
        boolean result = PalindromeChecker.isPalindromeGeneric(characters);

        //THEN
        assertTrue(result, "Expected an odd length palindrome to return true.");
    }

    @Test
    public void isPalindromeGeneric_integerInput_returnsTrue() {
        // GIVEN
        Queue<Integer> integers = new LinkedList<>(ImmutableList.of(3, 8, 17, 9, 9, 17, 8, 3));

        //WHEN
        boolean result = PalindromeChecker.isPalindrome(integers);

        //THEN
        assertTrue(result, "Expected an even length palindrome to return true.");
    }
}
