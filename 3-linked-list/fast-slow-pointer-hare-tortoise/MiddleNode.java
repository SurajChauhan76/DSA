// Finding the Middle node
public class MiddleNode {
    
    // Definition for our singly-linked list node
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode middleNode(ListNode head) {
        // Initialize 'slow' and 'fast' pointers at the head
        ListNode slow = head;  // Tortoise
        ListNode fast = head;  // Hare

        // Create your while loop.
        // Think carefully about the condition: 'fast' needs to safely jump TWO spots.
        while (fast != null && fast.next != null) {
            // Move 'slow' one step
            slow = slow.next;

            // Move 'fast' two steps
            fast = fast.next.next;
        }

        // When the loop ends, 'slow' pointer is sitting on the middle node
        return slow;
    }

    // Helper method to print the list from a given node
    public static void printFromNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + (node.next != null ? " -> " : " -> null\n"));
            node = node.next;
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Odd number of node
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        System.out.print("Odd List Middle: ");
        printFromNode(middleNode(head1)); // Expected: 3 -> 4 -> 5 -> null

        // Test Case 2: Even number of nodes
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next =new ListNode(6);

        System.out.print("Even List Middle: ");
        printFromNode(middleNode(head2)); // Expected: 4 -> 5 -> 6 -> null
    }
}
