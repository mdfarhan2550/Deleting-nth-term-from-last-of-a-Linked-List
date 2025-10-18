class PracticeLL {
    Node head;
    class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    //add first last
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }

        Node currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }
    public void printList() {
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("Null");
    }
    public void deleteFirst() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }
    public void deleteLast() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        if(head.next == null) {
            head = null;
            return;
        }
        Node prevNode = head;
        Node currNode = head.next;
        while(currNode.next != null) {
            prevNode = currNode;
            currNode = currNode.next;
        }
        prevNode.next = null;
    }
    public void deleteNthLast(int n) {
        int size = 0;
        Node currNode = head;
        while(currNode != null) {
            currNode = currNode.next;
            size++;
        }
        if(n == size) {
            head = head.next;
            return;
        }

        int idxForSearch = size - n;
        Node prevNode = head;
        int i = 1;
        while(i != idxForSearch) {
            prevNode = prevNode.next;
            i++;
        }
        prevNode.next = prevNode.next.next;
    }

    public static void main(String args[]) {
        PracticeLL list = new PracticeLL();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.printList();

        list.deleteNthLast(2);
        list.printList();
    }
}
