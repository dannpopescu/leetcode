public class SquaresOfASortedArray {

    public static int[] sortedSquares(int[] A) {
        int[] S = new int[A.length];

        if (A[0] >= 0) {
            for (int i = 0; i < A.length; i++) {
                S[i] = A[i] * A[i];
            }
            return S;
        }

        int left = 0;
        int right = A.length - 1;

        for (int i = A.length - 1; i >= 0; i--) {
            if (Math.abs(A[left]) > A[right]) {
                S[i] = A[left] * A[left];
                left++;
            } else {
                S[i] = A[right] * A[right];
                right--;
            }
        }

        return S;
    }
}
