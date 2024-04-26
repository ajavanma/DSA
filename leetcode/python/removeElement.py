from typing import List

# Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

# Custom Judge:

# The judge will test your solution with the following code:

# int[] nums = [...]; // Input array
# int val = ...; // Value to remove
#  int[] expectedNums = [...]; // The expected answer with correct length.
#                              // It is sorted with no values equaling val.

# int k = removeElement(nums, val); // Calls your implementation

# assert k == expectedNums.length;
# sort(nums, 0, k); // Sort the first k elements of nums
# for (int i = 0; i < actualLength; i++) {
#     assert nums[i] == expectedNums[i];
# }
# If all assertions pass, then your solution will be accepted.

class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        insertPosition = 0

        for num in nums:
            if num != val:
                nums[insertPosition] = num
                insertPosition += 1
        
        return insertPosition
