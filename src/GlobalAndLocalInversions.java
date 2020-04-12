public class GlobalAndLocalInversions {

    public static boolean isIdealPermutation(int[] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j] && j - i > 1) return false;
            }
        }
        return true;
    }
}
