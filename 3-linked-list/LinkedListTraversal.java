public class LinkedListTraversal {
    // Definition for our singly-linked list node
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }   

    public static void printList(ListNode head) {
        // TODO: Step 1 - Create a temporary pointer called 'current' and set it to 'head'
        ListNode current = head;

        // TODO: Step 2 - Create a while loop that runs as long as 'current' is NOT null
        while (current != null) {
            // TODO: Step 3 - Print the current node's value
            System.out.print(current.val + " -> ");

            // TODO: Step 4 - Move the 'current' pointer to the NEXT node in the list
            current = current.next;
        }

        // This caps off the end of the list
        System.out.println("null");
    }
    public static void main(String[] args) {
        // Manually wiring up the list: 10 -> 20 -> 30 -> 40 -> null
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);

        System.out.print("Linked List: ");
        printList(head);
        // Expected Output: Linked List: 10 -> 20 -> 30 -> 40 -> null
    }
}
