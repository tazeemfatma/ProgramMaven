package org.example;

public class LinkedList {
    class Node{
        Node next;
        int data;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node head=null;
    Node tail=null;
    public  void addNode(int data){
        Node new_node=new Node(data);

        if(head==null){
            head=new_node;
            tail=new_node;
        }else{
            tail.next=new_node;
            tail=tail.next;
        }

    }
    public void print(){
        Node temp=head;
        while(temp !=null){
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
    }

    public void delete(int data){
        Node temp=head;
        int flag=0;
        while(temp.next!=null){
            if(temp.next.data==data){
                temp.next=temp.next.next;
                flag=1;
                break;
            }
        }
        if(flag==1)
            System.out.println("deleted");
        else
            System.out.println("Requested data not found");
    }
    public int findMiddle(){
        Node slowPointer=head;
        Node fastPointer=head;//1->2->3->null
        while(fastPointer!=null && fastPointer.next!=null){
            slowPointer=slowPointer.next;
            fastPointer=fastPointer.next.next;
        }
        return slowPointer.data;
    }
    public static void main(String[] args){
        //Scanner in=new Scanner(System.in);
        //int data=in.nextInt();
        LinkedList ll=new LinkedList();
        ll.addNode(3);
        ll.addNode(2);
        ll.addNode(1);
        ll.print();
        ll.delete(2);
        System.out.println();
        ll.print();
        ll.addNode(5);
        System.out.println();
        ll.print();
        System.out.println("middle element"+ll.findMiddle());
        ll.addNode(7);
        System.out.println();
        ll.print();
        System.out.println("middle element"+ll.findMiddle());
      //  ll.head.next.next=ll.head;
        ll.findLoop();
    }

    private void findLoop() {
        Node slowPointer=head;
        Node fastPointer=head;
        int flag=0;
        while(fastPointer!=null && fastPointer.next != null){
            slowPointer=slowPointer.next;
            fastPointer=fastPointer.next.next;
            if(slowPointer==fastPointer) {
                System.out.println("loop exists");
                flag=1;
                break;
            }
        }
        if(flag==0)
            System.out.println("loop does not exists");
    }
}
