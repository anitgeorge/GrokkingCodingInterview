/**
 *
 * Given an array of ‘K’ sorted LinkedLists, merge them into one sorted list.
 *
 * Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4]
 * Output: [1, 2, 3, 3, 4, 6, 6, 7, 8]
 */

import java.util.*;

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class MergeKSortedLists {

    public static ListNode merge(ListNode[] lists) {
        ListNode result = new ListNode(-1);
        if(lists == null || lists.length == 0)
           return result;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
                (a, b) -> a.value - b.value
        );
        for(int i = 0; i < lists.length; i++)
            if(lists[i] != null)
                minHeap.offer(lists[i]);

        ListNode head = null, tail = null;
        while(!minHeap.isEmpty()){

            ListNode curr = minHeap.poll();
            if(head == null){
                head = curr;
                tail = curr;
            } else{
                tail.next = curr;
                tail = curr;
            }
            if(curr.next != null)
                minHeap.offer(curr.next);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        ListNode result = MergeKSortedLists.merge(new ListNode[] { l1, l2, l3 });
        System.out.print("Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
