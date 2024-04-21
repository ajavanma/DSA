package leetcode.java;

class removeDuplicatesFromLinkedList {
    private static class ListNode {
        private int data; 
        private ListNode next; 
  
        public ListNode(int data) {
           this.data = data;
           this.next = null;
        }
     }
    
     
    // Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
    public ListNode deleteDuplicates(ListNode head) {
        // Check if the list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }

        // "current" Pointer to traverse the list
        ListNode current = head;
        
        while (current.next != null) {
            // If the current value is equal to the next value, skip the next node
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                // traverse
                current = current.next;
            }
        }

        return head;
    }
}
