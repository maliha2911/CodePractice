package LinkedList;

public class Solution {
    public static ListNode getMid(ListNode head){
        ListNode fast= head;
        ListNode slow= head;
        while(fast.next != null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static ListNode reverseList(ListNode head){
        ListNode prev= null;
        ListNode curr=head;
        while(curr!= null){
            ListNode next= curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head== null || head.next==null){
            return true;
        }
        ListNode firstHalfStart= head;
        ListNode firstHalfEnd=getMid(head);
        ListNode secondHalfStart= reverseList(firstHalfEnd.next);

        while(secondHalfStart != null){
            if(secondHalfStart.val != firstHalfStart.val){
                return false;
            }
            firstHalfStart=firstHalfStart.next;
            secondHalfStart=secondHalfStart.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode listNode= new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))));
    }
}
