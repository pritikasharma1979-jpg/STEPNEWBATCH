package week1.practice;

import java.util.Scanner;

public class PalindromeChecker {

    static boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    static boolean isPalindromeRecursive(String text) {

        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    static boolean isPalindromeArrayReversal(String text) {

        char[] characters = text.toCharArray();

        int left = 0;
        int right = characters.length - 1;

        while (left < right) {

            char temp = characters[left];
            characters[left] = characters[right];
            characters[right] = temp;

            left++;
            right--;
        }

        String reversed = new String(characters);

        return text.equals(reversed);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        System.out.println(
                "Iterative: " +
                        (isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome")
        );

        System.out.println(
                "Recursive: " +
                        (isPalindromeRecursive(text) ? "Palindrome" : "Not Palindrome")
        );

        System.out.println(
                "Array Reversal: " +
                        (isPalindromeArrayReversal(text) ? "Palindrome" : "Not Palindrome")
        );

        scanner.close();
    }
}
