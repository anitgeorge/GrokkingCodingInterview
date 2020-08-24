/**
 *
 * Given the head of a Singly LinkedList, write a function to
 * determine if the LinkedList has a cycle in it or not.
 *
 * class ListNode {
 *   int value = 0;
 *   ListNode next;
 *
 *   ListNode(int value) {
 *     this.value = value;
 *   }
 * }
 *
 * @author anitgeorge
 */

class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                return true; // found the cycle
        }
        return false;
    }
}