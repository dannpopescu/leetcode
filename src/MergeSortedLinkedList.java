public class MergeSortedLinkedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // get the head
        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        // merge lists
        ListNode it = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                it.next = l1;
                l1 = l1.next;
            } else {
                it.next = l2;
                l2 = l2.next;
            }
            it = it.next;
        }

        it.next = (l1 == null) ? l2 : l1;

        return head;
    }
}
