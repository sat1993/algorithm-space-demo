package fibonacci;

/**
 * 基于矩阵形式获取菲波那切数列。
 * f0=0 f1=1 f2=1 f3=2
 * 通过矩阵换算.
 * A = ( 1  1 ) = ( f2  f1 )
 *       1  0       f1  f0
 * An = A^n = ( f(n+1) fn     )
 *              fn     f(n-1)
 * 若n为奇数：
 * An = A(n/2) * A(n/2) * A
 * 若n为偶数:
 * An = A(n/2) * A(n/2)
 * 通过递归实现.
 */
public class MatrixFibonacci {
    private static final long[][] A = new long[2][2];

    static {
        A[0][0] = 1;
        A[0][1] = 1;
        A[1][0] = 1;
        A[1][1] = 0;
    }

    public long getFibonacci(int n) {
        return fibonacci(n)[0][1];
    }
    private long[][] fibonacci(int n) {
        if (n == 1) {
            return A;
        }
        // 如果n是非1奇数.
        if (n % 2 == 1) {
            long[][] temp = matrixMultiplication(fibonacci(n / 2), fibonacci(n / 2));
            return matrixMultiplication(temp, A);
        } else {
            return matrixMultiplication(fibonacci(n / 2), fibonacci(n / 2));
        }
    }

    private long[][] matrixMultiplication(long[][] a1, long[][] a2) {
        long[][] result = new long[2][2];
        result[0][0] = a1[0][0] * a2[0][0] + a1[0][1] * a2[1][0];
        result[0][1] = a1[0][0] * a2[0][1] + a1[0][1] * a2[1][1];
        result[1][0] = a1[1][0] * a2[0][0] + a1[1][1] * a2[1][0];
        result[1][1] = a1[1][0] * a2[0][1] + a1[1][1] * a2[1][1];
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MatrixFibonacci().getFibonacci(10));
    }
}
