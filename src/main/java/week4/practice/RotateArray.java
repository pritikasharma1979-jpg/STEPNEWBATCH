package week4.practice;



import java.util.Scanner;
import java.util.Arrays;

public class RotateArray {

    static int[] rotateArray(int[] nums, int k) {

        int n = nums.length;

        // Reduce k
        k = k % n;

        int[] newArray = new int[n];

        for (int i = 0; i < n; i++) {

            int newPosition = (i + k) % n;

            newArray[newPosition] = nums[i];
        }

        return newArray;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter k: ");
        int k = scanner.nextInt();

        int[] result = rotateArray(nums, k);

        System.out.println("Rotated Array: " + Arrays.toString(result));

        scanner.close();
    }
}
