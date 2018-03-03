import java.util.*;

/**
 * 去重算法的几种实现.
 */
public class DuplicationAlgorithm {
    private static final int[] arrays = new int[]{3, 4, 1, 2, 9, 8, 3, 8, 2, 6, 6, 5};
    private static final int MAX = 10;
    /**
     * 通过hashSet去重，无法计数.
     * 因为是通过散列进行去重，所以无序.
     * 时间复杂度O(nlogn), 空间复杂度O(n).
     */
    public int[] duplicatedBySet(int[] arrays) {
        final Set<Integer> hashSet = new HashSet<>();
        for (int array : arrays) {
            hashSet.add(array);
        }
        return setToIntArray(hashSet);
    }

    /**
     * 通过TreeSet去重，无法计数。
     * 因为是红黑树去重，所以有序。
     * 时间复杂度O(nlogn)，空间复杂度O(n)
     */
    public int[] duplicatedByTreeSet(int[] arrays) {
        final Set<Integer> treeSet = new TreeSet<>();
        for (int array : arrays) {
            treeSet.add(array);
        }
        return setToIntArray(treeSet);
    }

    /**
     * 通过排序后，LR定位进行去重。
     * 因为排序后再进行去重，排序复杂度O(nlogn)，空间复杂度O(1)。去重复杂度O(n),空间复杂度O(1).
     * 有序，并可以计数，计算每个数重复了多少次。
     * 时间复杂度O(nlogn)，空间复杂度O(1)
     */
    public int[] duplicatedBySortAndLR(int[] arrays) {
        List<Integer> resultList = new ArrayList<>();
        // 排序.
        Arrays.sort(arrays);
        int L = 0;
        int R = 0;
        for (; L < arrays.length; R++) {
            // 必然是R>L.
            if (R == arrays.length || arrays[L] != arrays[R]) {
                System.out.printf("%d has %d \n", arrays[L], R - L);
                resultList.add(arrays[L]);
                L = R;
            }
        }
        return listToIntArray(resultList);
    }

    /**
     * 通过数组下标去重.
     * 0~max.适用于max较少，而重复数较多情况。
     * 时间复杂度O(max),空间复杂度O(max)
     */
    public int[] duplicatedByArray(int[] arrays) {
        List<Integer> resultList = new LinkedList<>();
        int[] result = new int[MAX];
        for (int array : arrays) {
            result[array]++;
        }
        for (int i = 0; i < result.length; i++) {
            int value = result[i];
            if (value != 0) {
                resultList.add(i);
                System.out.printf("%d has %d\n", i, value);
            }
        }
        return listToIntArray(resultList);
    }

    private int[] listToIntArray(List<Integer> list) {
        final int[] result = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            result[i++] = integer;
        }
        return result;
    }

    private int[] setToIntArray(Set<Integer> set) {
        final int[] result = new int[set.size()];
        int i = 0;
        for (Integer integer : set) {
            result[i++] = integer;
        }
        return result;
    }

    public static void main(String[] args) {
        final DuplicationAlgorithm duplicationAlgorithm = new DuplicationAlgorithm();
        int[] result = duplicationAlgorithm.duplicatedBySortAndLR(arrays);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
