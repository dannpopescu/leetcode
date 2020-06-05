public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode it = head;
        head = null;

        while (it != null) {
            ListNode current = it;
            it = it.next;
            current.next = head;
            head = current;
        }

        return head;
    }
}
