public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int zeroesCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroesCount++;
                continue;
            }

            if (zeroesCount != 0) {
                swap(nums, i, i - zeroesCount);
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
