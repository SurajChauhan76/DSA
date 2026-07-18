// Floyd's Algorith
public class LikedListCycle {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static boolean hasCycle(ListNode head) {
        // Edge case: empty list or single node pointing to null
        if (head == null || head.next == null) {
            return false;
        }

        // Both pointers start at the head
        ListNode slow = head; // Tortoise
        ListNode fast = head; // Hare

        // We must ensure fast and fast.next are not null before we jump two spots!
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move 1 step
            fast = fast.next.next;     // Move 2 steps

            // If they land on the exact same node in memory, it's a loop!
            if (slow == fast) {
                return true;
            }
        }

        // If fast hits null, it reached the end. No loop exists.
        return false;
    }

    public static void main (String [] args) {
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = head.next;

        System.out.println("Cycle exits: " + hasCycle(head));
    }
}
