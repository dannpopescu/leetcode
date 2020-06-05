public class RemoveDuplicatesFromSortedLinkedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode lastUnique = null;
        ListNode it = head;
        head = null;

        while (it != null) {

            boolean duplicateFound = false;

            while (it.next != null && it.val == it.next.val) {
                it = it.next;
                duplicateFound = true;
            }

            if (duplicateFound) {
                // `it` is the last duplicate in the current sequence of duplicates.
                // Advance `it` and break the link from the seq. of duplicates to the rest of the list.
                ListNode aux = it;
                it = it.next;
                aux.next = null;
            } else if (head == null) {
                // Create the list
                head = it;
                lastUnique = head;
                it = it.next;
            } else {
                // Add a new node to the list
                lastUnique.next = it;
                lastUnique = lastUnique.next;
                it = it.next;
            }
        }

        if (lastUnique != null) {
            lastUnique.next = null;
        }

        return head;
    }
}
