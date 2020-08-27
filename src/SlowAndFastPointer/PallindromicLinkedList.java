/**
 *
 * Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.
 *
 * Your algorithm should use constant space and the input LinkedList should be in the original
 * form once the algorithm is finished. The algorithm should have O(N) time complexity
 * where ‘N’ is the number of nodes in the LinkedList.
 */

import java.util.*;
class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

class PalindromicLinkedList {
    public static boolean isPalindrome(ListNode head) {

        return isPalindromeUtil(head);
    }

    private static boolean isPalindromeUtil(ListNode right){

        Stack<ListNode> stack = new Stack<>();
        ListNode slow = right;
        while(slow != null){

            stack.push(slow);
            slow = slow.next;
        }

        while(!stack.isEmpty()){

            ListNode temp = stack.pop();
            if(temp.value != right.value) return false;
            right = right.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }
}