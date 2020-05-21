public class PlusOne {

    public static int[] plusOne(int[] a) {
        int n = a.length - 1;
        a[n]++;

        for (int i = n; i > 0; i--) {
            if (a[i] == 10) {
                a[i] = 0;
                a[i - 1]++;
            } else {
                break;
            }
        }

        if (a[0] == 10) {
            a = new int[a.length + 1];
            a[0] = 1;
        }

        return a;
    }
}
