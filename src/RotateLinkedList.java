public class RotateLinkedList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) { // if empty or only one element
            return head;
        }

        int size = getListSize(head);
        k = k % size;
        if (k == 0) {
            return head;
        }

        ListNode it = head;
        for (int i = 0; i < size - k - 1; i++) {
            it = it.next;
        } // `it` should be the new end of the list

        ListNode newLast = it;
        ListNode newFirst = it.next;
        for (int i = 0; i < k; i++) {
            it = it.next;
        } // `it` is now the last end of the list

        it.next = head;
        head = newFirst;
        newLast.next = null;

        return head;
    }

    public int getListSize(ListNode head) {
        int size = 0;
        for (ListNode it = head; it != null; it = it.next) {
            size++;
        }
        return size;
    }
}
