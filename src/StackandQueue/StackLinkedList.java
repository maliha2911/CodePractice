package StackandQueue;

public class StackLinkedList {
    Node head;
    Node tail;
    int size=0;
    class Node{
        int value;
        Node next;
        Node(int v){
            this.value= v;
            this.next= null;
        }
    }
    public boolean push(int data){
        if(head==null){
            head= new Node(data);
            tail=head;
        }
        Node node= new Node(data);
        head.next=head;
        head= node;
        size++;
        return true;
    }

    public int pop() throws Exception{
        if(head== null) throw new Exception("stack is empty");
        int val= head.value;
        size--;
        head= head.next;
        return val;
    }

    public  int peek() throws Exception{
        if(head== null) throw new Exception("stack is empty");
        int val= head.value;
        return  val;
    }

    public int size(){
        if (head==null) return 0;
        return size;
    }

    public static void main(String[] args) throws Exception {
        StackLinkedList stack= new StackLinkedList();

        stack.push(1);
        System.out.println(stack.pop());
        stack.push(2);
        stack.push(3);

    }
}
