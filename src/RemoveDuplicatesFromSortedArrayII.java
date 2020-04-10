public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int duplicatesCounter = 0;  // number of numbers that appear more than twice
        int counter = 1;            // number of times a number appeared in the array

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1 - duplicatesCounter]) {
                // if the number appeared less than two times, put it in the right position
                // else increase the spread between indexes that will be used in later swaps
                if (counter < 2) {
                    swap(nums, i, i - duplicatesCounter);
                } else {
                    duplicatesCounter++;
                }

                counter++;

            } else {
                swap(nums, i, i - duplicatesCounter);
                counter = 1;
            }
        }

        return nums.length - duplicatesCounter;
    }

    public void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
