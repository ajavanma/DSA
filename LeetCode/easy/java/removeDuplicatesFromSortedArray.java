package leetcode.easy.java;
// Given an integer array nums sorted in ascending order, remove the duplicates in-place such that each unique element appears only once. 
//The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

class Solution {
    public int removeDuplicates(int[] nums) {

        int j = 1;  // unique Pointer, first element is always unique
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
