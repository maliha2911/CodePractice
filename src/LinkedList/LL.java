package LinkedList;

public class LL {
    Node head;
    class Node{
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
    public void createList(String[] arr){
        Node head=null;
        Node tail=null;
        for(int i=0; i< arr.length;i++) {
            Node node = new Node(arr[i]);

            if (head == null) {
                head = node;
                tail= node;
            }else {
                tail.next=node;
                tail=node;
            }

        }


    }
    public void addFirst(String data){
        Node node=new Node(data);
        if(head==null){
            head=node;
            return;
        }
        node.next=head;
        head=node;

    }
    public void addLast(String data){
        Node node=new Node(data);
        if(head==null){
            head=node;
            return;
        }
        Node currNode=head;
        while(currNode.next!=null){
            currNode=currNode.next;
        }
        currNode.next=node;
    }
    public void addAfter(String data, Node previousNode){
        if(head==null){
            System.out.println("LIst is empty");
            return;
        }
        Node node=new Node(data);
        node.next=previousNode.next;
        previousNode.next=node;

    }
    public void deleteFirst(){
        if(head==null){
            System.out.println("LIst is empty");
            return;
        }
        head=head.next;
    }
    public void deleteLast(){
        if(head==null){
            System.out.println("LIst is empty");
            return;
        }
        if(head.next==null){
            head=null;
            return;
        }
        Node secondLastNode=head;
        Node lastNode=head.next;
        while(lastNode.next!=null){
            secondLastNode=secondLastNode.next;
            lastNode=lastNode.next;
        }
        secondLastNode.next=null;
    }
    public Node reverseList(){
        if(head==null || head.next==null){
            return head;
        }
        Node prev= null;
        Node curr=head;
        while(curr!= null){
            Node next= curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;

    }
    public static ListNode getMid(ListNode head){
        ListNode fast= head;
        ListNode slow= head;
        while(fast.next != null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public void printLinkedList(){
        if(head==null){
            System.out.println("LIst is empty");
            return;
        }
        Node currNode=head;
        while(currNode!=null){
            System.out.print(currNode.data+ "->");
            currNode=currNode.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {

        LL list=new LL();
        list.addFirst("b");
        list.addFirst("a");
        list.addLast("z");
        list.addAfter("c", list.head.next);
        list.printLinkedList();
        list.deleteLast();
        list.printLinkedList();

    }
}
