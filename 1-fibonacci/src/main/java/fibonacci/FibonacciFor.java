package fibonacci;

/**
 * for循环计算菲波那切数列，时间复杂度O(n)，空间复杂度O(1)
 */
public class FibonacciFor {

    private long fibonacci(int n) {
        if (n < 0) {
            throw new UnsupportedOperationException("不支持小于0的数列计算");
        }
        if (n == 0) {
            return 0;
        }
        long f0 = 0;
        long fn = 1;
        // 循环一次计算一次fn，第一次循环结果fn为f2
        for (int i = 0; i < n - 1; i++) {
            long a = fn;
            fn = f0 + fn;
            f0 = a;
        }
        return fn;
    }

    public static void main(String[] args) {
        System.out.println(new FibonacciFor().fibonacci(10));
    }
}
