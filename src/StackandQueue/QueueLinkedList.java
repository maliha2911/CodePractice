package StackandQueue;

public class QueueLinkedList {
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
    public void add(int data){
        if(head== null){
            head= new Node(data);
            tail= head;
            return;
        }
        Node node= new Node(data);
        tail.next= node;
        tail=node;
        size++;
    }
    public int poll() throws Exception{
        if(head== null) throw new Exception("queue is empty");
        else{
            int val= head.value;
            head= head.next;
            size--;
            return val;
        }

    }
    public int peek() throws Exception{
        if(head== null) throw new Exception("queue is empty");
        else{
            int val= head.value;
            return val;
        }
    }
    public int size(){
        if(head== null) return 0;
        return size;
    }

    public static void main(String[] args) throws Exception {
        QueueLinkedList queue= new QueueLinkedList();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }

}
