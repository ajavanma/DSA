package java.sort;

//
//  time complexity:
// average and worst  : O(n^2) 
// best               : O(n) (when the array is already sorted)
//
// space complexity: O(1) (in-place sorting algorithm)
//
// outer for-loop takes track of the "iteration" (based on the length -1)
// inner for-loop takes care of the "comparing and swapping"
//
// Repeatedly compare a pair of adjacent elements and swap them if they are in wrong order
// If we haven’t done a swap in an iteration, break 
//
// ascending
//
public class BubbleSort {
   public void sort(int[] arr) {
      boolean isSwapped;

      for (int i = 0; i < arr.length - 1; i++) {
         isSwapped = false;
         for (int j = 0; j < arr.length - 1 - i; j++) { // in each iteration the last number is sorted in its place, so the number of iteration is reduced by i
            if (arr[j] > arr[j + 1]) {
               // swap
               int temp = arr[j];
               arr[j] = arr[j + 1];
               arr[j + 1] = temp;
               isSwapped = true;
            }
         }

         if (isSwapped == false) {  // after a complete "inner for loop" pass if no swap was done, it means the array is already sorted
            break;
         }
      }
   }


   // #include <vector>
   // #include <algorithm>  // For std::swap
   //
   // class BubbleSort {
   // public:
   //    void sort(std::vector<int>& arr) {
   //       bool isSwapped;
   //
   //       for (int i = 0; i < arr.size() - 1; i++) {
   //             isSwapped = false;
   //
   //             for (int j = 0; j < arr.size() - 1 - i; j++) {
   //                if (arr[j] > arr[j + 1]) {
   //                   std::swap(arr[j], arr[j + 1]);  // Using std::swap to exchange elements
   //                   isSwapped = true;
   //                }
   //             }
   //
   //             if (!isSwapped) {  // If no two elements were swapped by inner loop, then break
   //                break;
   //             }
   //       }
   //    }
   // };



   public void printArray(int[] arr) {
      int n = arr.length;
      for (int i = 0; i < n; i++) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }

   public static void main(String[] args) {
      int[] arr = new int[] { 5, 1, 2, 9, 10 };
      BubbleSort bs = new BubbleSort();
      bs.printArray(arr);
      bs.sort(arr);
      bs.printArray(arr);

   }

}