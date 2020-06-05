public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        if (head.next == null) return head;

        int size = getListSize(head);

        ListNode it = head;
        for (int i = 0; i < size / 2; i++) {
            it = it.next;
        }

        return it;
    }

    public int getListSize(ListNode head) {
        int size = 0;
        for (ListNode it = head; it != null; it = it.next) {
            size++;
        }
        return size;
    }
}
