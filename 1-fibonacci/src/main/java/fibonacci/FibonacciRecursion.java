package fibonacci;

/**
 * 递归方式获取菲波那切数列。
 * fn = f(n-1) + f(n-2)
 */
public class FibonacciRecursion {
    private static final long f0 = 0;
    private static final long f1 = 1;

    private long fibonacci(int n) {
        if (n < 0) {
            throw new UnsupportedOperationException("不支持n<0的情况");
        }
        if (n == 1) {
            return f1;
        }
        if (n == 0) {
            return f0;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(new FibonacciRecursion().fibonacci(10));
    }
}
