public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode headOdd = head, itOdd = headOdd;
        ListNode headEven = head.next, itEven = headEven;

        head = head.next.next;

        for (int counter = 3; head != null; counter++) {
            if (counter % 2 == 0) {
                itEven.next = head;
                itEven = itEven.next;
            } else {
                itOdd.next = head;
                itOdd = itOdd.next;
            }
            head = head.next;
        }

        itOdd.next = headEven;
        itEven.next = null;

        return headOdd;
    }
}
