/**
 * 二分查找法.
 */
public class BinarySearch {
    private static final int[] arrays = new int[]{5, 12, 13, 23, 29, 33, 35, 39, 44, 46, 49, 51, 56, 60, 71, 82, 99};

    public int binarySearch(int[] arrays, int num) {
        int left = 0;
        int right = arrays.length - 1;
        while (left <= right) {
            // 防止left+right溢出.
            int mid = left + (right - left) / 2;
            // 如果num大于mid元素，则取右半部分.
            if (arrays[mid] < num) {
                left = mid + 1;

            }
            // 如果num小于mid元素，则取左半部分.
            else if (num < arrays[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().binarySearch(arrays, 34));
    }
}
