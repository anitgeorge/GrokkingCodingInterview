/**
 *
 * Given a non-empty, singly linked list with head node head,
 * return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MiddleOfAList {
    public ListNode middleNode(ListNode head) {
        if(head == null)
            return null;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}