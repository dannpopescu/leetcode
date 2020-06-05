public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int target) {
        while (head != null && head.val == target) {
            head = head.next;
        }

        ListNode it = head;

        while (it != null && it.next != null) {
            if (it.next.val != target) {
                it = it.next;
            } else {
                ListNode aux = it.next;
                it.next = aux.next;
                aux.next = null;
            }
        }

        return head;
    }
}
