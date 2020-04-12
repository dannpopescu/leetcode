public class GlobalAndLocalInversions {

    public static boolean isIdealPermutation(int[] A) {
        int global = 0, local = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) global++;
            }
        }

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) local++;
        }

        return local == global;
    }
}
