package week4.assignment;

import java.util.HashMap;
import java.util.Scanner;

public class SubarraySumEqualsK {

    static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();

        // Empty prefix
        prefixSumCount.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            currentSum = currentSum + nums[i];

            int requiredSum = currentSum - k;

            if (prefixSumCount.containsKey(requiredSum)) {
                count = count + prefixSumCount.get(requiredSum);
            }

            // Store current prefix sum
            if (prefixSumCount.containsKey(currentSum)) {

                prefixSumCount.put(
                        currentSum,
                        prefixSumCount.get(currentSum) + 1
                );

            } else {

                prefixSumCount.put(currentSum, 1);
            }
        }

        return count;
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

        int result = subarraySum(nums, k);

        System.out.println("Number of subarrays: " + result);

        scanner.close();
    }
}