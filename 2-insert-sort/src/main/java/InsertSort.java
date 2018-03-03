public class InsertSort {
    private static final int[] arrays = new int[]{5, 4, 7, 9, 1, 5, 9, 7, 12, 556, 76, 3, 1, 12};

    /**
     * 插入排序.
     * 复杂度O(n^2)，空间复杂度O(1)
     */
    public void insertSort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            int num = arrays[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (num < arrays[j]) {
                    arrays[j + 1] = arrays[j];
                } else {
                    break;
                }
            }
            arrays[j + 1] = num;
        }
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(arrays);
        for (int array : arrays) {
            System.out.println(array);
        }
    }
}
