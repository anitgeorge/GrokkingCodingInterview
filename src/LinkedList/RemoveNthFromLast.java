/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    int index = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head  == null)
            return head;
        ListNode temp = removeNthFromEnd(head.next, n);
        if(++index == n)
            return temp;
        head.next = temp;
        return head;
    }
}