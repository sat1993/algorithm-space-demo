package fibonacci;

/**
 * 基于矩阵计算菲波那切数列加强版。
 * f0=0 f1=1 f2=1 f3=2
 * 在矩阵计算的基础上，将其优化为两个多项式的计算。
 * An = A(2m) = ( f(2m+1) f2m    )
 *                f2m     f(2m-1)
 * A2m = Am * Am = ( fm+1 fm   )^2 = ( (fm+1)^2 + fm^2 (f(m+1)+f(m-1))fm )
 *                   fm   fm-1
 * =>
 *
 * f(2m+1) = f(m+1)^2 + fm^2
 * f(2m)   = (f(m+1) + f(m-1))fm
 *
 * 当n为奇数时，n = 2m + 1, m = n/2
 * f(n+1) = f(2m+2) = (2fm + f(m+1))fm
 * f(n)   = f(m+1)^2 + fm^2
 * 当n为偶数时，n = 2m, m = n/2
 * f(n+1) = f(2m+1) = f(m+1)^2 + fm^2
 * f(n) = f(2m) = (f(m+1) + f(m-1))fm = (2f(m+1) - fm)fm
 */
public class MatrixFibonacciEnhanced {
    // f1=1, f0=0
    public static final long A[] = new long[]{1, 0};

    public long getFibonacci(int n) {
        return fibonacci(n-1)[0];
    }

    private long[] fibonacci(int n) {
        if (n / 2 == 1) {
            if (n % 2 == 1) {
                return oddCalculate(A[1], A[0]);
            } else {
                return evenCalculate(A[1], A[0]);
            }
        }
        long[] temp = fibonacci(n / 2);
        if (n % 2 == 1) {
            return oddCalculate(temp[1], temp[0]);
        } else {
            return evenCalculate(temp[1], temp[0]);
        }
    }

    /**
     * 当n为奇数时.
     * f(n+1) = f(2m+2) = (2fm + f(m+1))fm
     * f(n)   = f(m+1)^2 + fm^2
     * @param a fm+1
     * @param b fm
     * @return f(n+1) fn
     */
    private long[] oddCalculate(long a, long b) {
        return new long[]{
                (2 * b + a) * b,
                a * a + b * b
        };
    }

    /**
     * 当n为偶数时，n = 2m, m = n/2
     * f(n+1) = f(2m+1) = f(m+1)^2 + fm^2
     * f(n) = f(2m) = (f(m+1) + f(m-1))fm = (2f(m+1) - fm)fm
     * @param a f(n+1)
     * @param b fn
     * @return f(fn+1) fn
     */
    private long[] evenCalculate(long a, long b) {
        return new long[]{
                a * a + b * b,
                (2 * a - b) * b
        };
    }

    public static void main(String[] args) {
        System.out.println(new MatrixFibonacciEnhanced().getFibonacci(10));
    }
}
