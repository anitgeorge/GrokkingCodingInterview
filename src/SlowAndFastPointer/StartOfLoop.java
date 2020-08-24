/**
 *
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 *
 * To represent a cycle in the given linked list, we use an integer
 * pos which represents the position (0-indexed) in the linked list
 * where tail connects to. If pos is -1, then there is no cycle
 * in the linked list.
 *
 * Note: Do not modify the linked list.
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 *
 * @author anitgeorge
 */
public class StartOfLoop {
    public ListNode detectCycle(ListNode head) {

        if(head == null || head.next == null)
            return null;

        ListNode slow = head, fast = head.next;
        int count = 0;
        while(slow != fast && fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                count = countNodes(slow);
        }
        if(slow != fast)
            return null;
        return startNode(head, count);
    }

    private int countNodes(ListNode node){

        int count = 0;
        ListNode curr = node;
        do{
            count++;
            curr = curr.next;
        }while(node != curr);

        return count;
    }

    private ListNode startNode(ListNode head, int count){

        ListNode dummy1 = head, dummy2 = head;
        for(int i =0 ;i < count; i++)
            dummy1 = dummy1.next;

        while(dummy1 != dummy2){

            dummy1 = dummy1.next;
            dummy2 = dummy2.next;
        }

        return dummy1;
    }
}