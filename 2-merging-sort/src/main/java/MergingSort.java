
public class MergingSort {
    private static final int[] arrays = new int[]{5, 4, 7, 9, 1, 5, 9, 7, 12, 556, 76, 3, 1, 12};

    public void sort(int[] arrays) {
        sort(arrays, 0, arrays.length - 1);
    }

    /**
     * 归并排序.
     */
    public void sort(int[] arrays, int left, int right) {
        // 说明拆分结束.
        if (right == left) {
            return;
        }
        // 使用(lo+hi)/2，有可能溢出.
        int mid = left + (right - left) / 2;
        // 拆分arrays.
        sort(arrays, left, mid);
        sort(arrays, mid + 1, right);
        // 合并.
        merge(arrays, left, mid, right);
    }

    /**
     * 合并元素
     */
    public void merge(int[] arrays, int left, int mid, int right) {
        //temp数组用于暂存合并的结果
        int[] temp = new int[right - left + 1];
        //左半边的指针
        int i = left;
        //右半边的指针
        int j = mid+1;
        //合并后数组的指针
        int k = 0;

        //将记录由小到大地放进temp数组
        for(; i <= mid && j <= right; k++)
        {
            if (arrays[i] < arrays[j]) {
                temp[k] = arrays[i++];
            } else {
                temp[k] = arrays[j++];
            }
        }

        //接下来两个while循环是为了将剩余的（比另一边多出来的个数）放到temp数组中
        while (i <= mid) {
            temp[k++] = arrays[i++];
        }

        while (j <= right) {
            temp[k++] = arrays[j++];
        }

        //将temp数组中的元素写入到待排数组中
        for(int l = 0; l < temp.length; l++) {
            arrays[left + l] = temp[l];
        }
    }

    public static void main(String[] args) {
        new MergingSort().sort(arrays);
        for (int array : arrays) {
            System.out.println(array);
        }
    }
}
