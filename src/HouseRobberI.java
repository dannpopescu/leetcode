public class HouseRobberI {

    public static int rob(int[] a) {
        switch (a.length) {
            case 0:
                return 0;
            case 1:
                return a[0];
            case 2:
                return Math.max(a[0], a[1]);
        }

        int secondLastMax = a[0];               // max profit if stop robbing at the penultimate house
        int lastMax = Math.max(a[0], a[1]);     // max profit if stop robbing at the last house

        for (int i = 2; i < a.length; i++) {
            int maxCurrentProfit = Math.max(secondLastMax + a[i], lastMax);
            secondLastMax = lastMax;
            lastMax = maxCurrentProfit;
        }

        return lastMax;
    }
}
