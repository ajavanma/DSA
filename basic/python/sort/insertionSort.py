
#  time complexity: worst and average: O(n^2)
#                                best: O(n) when the array is already sorted
#  space complexity: O(1) (in-place sorting algorithm)

def insertion_sort(nums):
    for i in range(1, len(nums)):
        j = i
        while j > 0 and nums[j-1] > nums[j]:
            # Swap 
            nums[j], nums[j-1] = nums[j-1], nums[j]
            j -= 1
    return nums
