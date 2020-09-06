import java.util.*;

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class RotateList {

    public static ListNode rotate(ListNode head, int rotations) {
        if(head == null || head.next == null)
           return head;
        int count = 1;
        ListNode curr = head;
        while(curr.next != null){
            count++;
            curr = curr.next;
        }
        curr.next = head;
        rotations %= count;
        ListNode prev = null;
        curr = head;
        for(int i = 0; i< rotations; i++){
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        return curr;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode result = RotateList.rotate(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}