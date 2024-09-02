package CodingPractice.PracticeQuestions.Accolite;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}


public class DeleteMiddleLInkedList {

    public static Node head = null;
    public static Node tail = null;

    public static int size;

    public static void deleteMiddleNode() {

        Node temp, current;
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else {
            int count = (size % 2 == 0) ? (size / 2) : ((size + 1) / 2);
            if (head != tail) {
                temp = head;
                current = null;
                for (int i = 0; i < count - 1; i++) {
                    current = temp;
                    temp = temp.next;
                }
                if (current != null) {
                    current.next = temp.next;
                    temp = null;
                } else {
                    head = tail = temp.next;
                    temp = null;
                }
            } else {
                head = tail = null;
            }
        }

        size--;
    }

    public static void addNode(int data) {

        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }
    public static void display() {

        Node current = head;
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {


        DeleteMiddleLInkedList.addNode(1);
        DeleteMiddleLInkedList.addNode(2);
        DeleteMiddleLInkedList.addNode(3);
        DeleteMiddleLInkedList.addNode(4);
        DeleteMiddleLInkedList.addNode(5);
        DeleteMiddleLInkedList.addNode(6);
        DeleteMiddleLInkedList.addNode(7);
        DeleteMiddleLInkedList.addNode(8);
        DeleteMiddleLInkedList.addNode(9);

        System.out.println("Original List: ");
        DeleteMiddleLInkedList.display();


            deleteMiddleNode();
            System.out.println("Updated List: ");
            DeleteMiddleLInkedList.display();


    }
}
