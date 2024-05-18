package leetcode.medium.java;
import java.util.Arrays;

// You are given an array happiness of length n, and a positive integer k.
// There are n children standing in a queue, where the ith child has happiness value happiness[i]. You want to select k children from these n children in k turns.
// In each turn, when you select a child, the happiness value of all the children that have not been selected till now decreases by 1. Note that the happiness value cannot become negative and gets decremented only if it is positive.
// Return the maximum sum of the happiness values of the selected children you can achieve by selecting k children.
 

// Example 1:
// Input: happiness = [1,2,3], k = 2
// Output: 4
// Explanation: We can pick 2 children in the following way:
// - Pick the child with the happiness value == 3. The happiness value of the remaining children becomes [0,1].
// - Pick the child with the happiness value == 1. The happiness value of the remaining child becomes [0]. Note that the happiness value cannot become less than 0.
// The sum of the happiness values of the selected children is 3 + 1 = 4.

// Example 2:
// Input: happiness = [1,1,1,1], k = 2
// Output: 1
// Explanation: We can pick 2 children in the following way:
// - Pick any child with the happiness value == 1. The happiness value of the remaining children becomes [0,0,0].
// - Pick the child with the happiness value == 0. The happiness value of the remaining child becomes [0,0].
// The sum of the happiness values of the selected children is 1 + 0 = 1.

// Example 3:
// Input: happiness = [2,3,4,5], k = 1
// Output: 5
// Explanation: We can pick 1 child in the following way:
// - Pick the child with the happiness value == 5. The happiness value of the remaining children becomes [1,2,3].
// The sum of the happiness values of the selected children is 5.

public class MaximizeHappinessOfSelectedChildren {
    public long maximumHappinessSum(int[] happiness, int k) {
        
        Arrays.sort(happiness);  // ascending order 
        
        long ans = 0;
        int n = happiness.length;
        
        // Iterate backwards to simulate descending order
        for (int i = 0; i < k && i < n; i++) {
            int index = n - 1 - i;  // approach 1: descending indexing
            ans += Math.max(happiness[index] - i, 0);
        }
        
        return ans;
    }
}


public class MaximizeHappinessOfSelectedChildren2 {
    public long maximumHappinessSum(int[] happiness, int k) {
        
        Arrays.sort(happiness);  // ascending order
        reverse(happiness);     // reverse it for descending order

        long ans = 0;
        int n = happiness.length;

        for (int i = 0; i < k && i < n; i++) {
            ans += Math.max(happiness[i] - i, 0); 
        }
        
        return ans;
    }

    // Helper function to reverse an array
    private void reverse(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
