import java.util.*;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class ReverseEveryKElements2 {

    public static ListNode reverse(ListNode head, int k) {
        if(head == null || k < 2)
            return head;
        ListNode prev = null;
        ListNode curr = head;
        while(true){

            ListNode lastPrev = prev;
            ListNode lastCurr = curr;
            ListNode next     = null;
            for(int i = 0; i < k && curr != null; i ++){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            if(lastPrev != null)
                lastPrev.next = prev;
            else
                head = prev;
            lastCurr.next = curr;
            if(curr == null)
                break;
            prev = lastCurr;
            for(int i = 0; i < k && curr != null; i++){
               prev = curr;
               curr = curr.next;
            }

            if(curr == null)
                break;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryKElements2.reverse(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}