public class MergeSortedArrays {

    public void merge(int[] A, int m, int[] B, int n) {
        int i = 0;
        int j = 0;

        while (i < A.length && j < B.length) {
            if (B[j] < A[i]) {
                for (int k = m + j; k > i; k--) {
                    A[k] = A[k - 1];
                }
                A[i] = B[j];
                j++;
            }
            i++;
        }

        while (j < B.length) {
            A[m + j] = B[j];
            j++;
        }
    }
}
