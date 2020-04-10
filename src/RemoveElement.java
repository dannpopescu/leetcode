import java.util.Arrays;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;

        while (true) {

            while (left < nums.length && nums[left] != val)
                left++;
            while (right >= 0 && nums[right] == val)
                right--;

            if (right <= left) break;

            swap(nums, left, right);

        }
        return left;
    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
