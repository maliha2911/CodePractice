package StackandQueue;

public class PriorityQueueLinkedList extends QueueLinkedList{
    @Override
    public void add(int data){
        if(head== null){
            Node node= new Node(data);
            head= node;
            tail=head;
        }
        else if(data<= head.value){
            head.next=head;
            head= new Node(data);
        }
        else if (data>= tail.value){
            tail.next= new Node(data);
            tail= tail.next;
        }
        else {
            Node prev = head;
            Node next = head;

            while (data >= next.value) {
                prev = next;
                next = next.next;
            }

            prev.next = new Node(data);
            prev.next.next = next;
        }
    }

    public static void main(String[] args) throws Exception {
        PriorityQueueLinkedList q= new PriorityQueueLinkedList();
        q.add(2);
        q.add(4);
        q.add(3);
        q.add(1);
        q.add(5);
        System.out.println(q.poll());
    }
}
