public class RemoveDuplicatesFromSortedLinkedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode it = head;

        while (it.next != null) {
            if (it.val == it.next.val) {
                ListNode aux = it.next;
                it.next = aux.next;
                aux.next = null;
            } else {
                it = it.next;
            }
        }

        return head;
    }
}
