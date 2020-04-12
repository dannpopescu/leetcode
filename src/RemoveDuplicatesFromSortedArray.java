public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] a) {
        int k = 1;

        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i - 1]) {
                a[k] = a[i];
                k++;
            }
        }

        return k;
    }

}
