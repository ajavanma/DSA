#  divide and conquer
#  divides the input array into two halves, calls itself for the two halves, and then merges the two sorted halves
   
#  time complexity: O(n log n)
#     division: log n
#     merging: n
#  space complexity: O(n)

# problems: 
# Merge sort requires an extra array in memory to merge the sorted sub arrays.
# Merge sort requires many recursive function calls, and function calls can have significant resource overhead.

def merge_sort(nums):
    
    if len(nums) <= 1:
        return nums
    
    mid = len(nums) // 2
    left_half = merge_sort(nums[:mid])
    right_half = merge_sort(nums[mid:])

    return merge(left_half, right_half)

def merge(first, second):
    merged = []
    i = 0  # Index for the first list
    j = 0  # Index for the second list

    # Merge the two lists by comparing their elements
    while i < len(first) and j < len(second):
        if first[i] <= second[j]:
            merged.append(first[i])
            i += 1
        else:
            merged.append(second[j])
            j += 1

    # If there are remaining elements in 'first', add them to 'merged'
    while i < len(first):
        merged.append(first[i])
        i += 1

    # If there are remaining elements in 'second', add them to 'merged'
    while j < len(second):
        merged.append(second[j])
        j += 1

    return merged
