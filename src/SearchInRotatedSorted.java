/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSorted {

    public int search(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;

            if (a[mid] == key) {
                return mid;
            }

            if (a[lo] <= a[mid]) {
                if (key >= a[lo] && key < a[mid]) {
                    return binarySearch(a, lo, mid - 1, key);
                }
            } else if (key < a[mid] || key >= a[lo]) {
                hi = mid - 1;
                continue;
            }

            if (a[mid] <= a[hi]) {
                if (key > a[mid] && key <= a[hi]) {
                    return binarySearch(a, mid + 1, hi, key);
                }
            } else if (key > a[mid] || key <= a[hi]) {
                lo = mid + 1;
                continue;
            }

            break;
        }

        return -1;
    }


    public int binarySearch(int[] a, int lo, int hi, int key) {
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;

            if (a[mid] == key) {
                return mid;
            } else if (a[mid] > key) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }
}
