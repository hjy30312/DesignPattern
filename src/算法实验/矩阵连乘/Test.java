package 算法实验.矩阵连乘;

/**
 * @author hjy
 * @create 2017/11/21
 **/
public class Test {
    private static final int  count = 6;
    /**
     * 存储的是i+1到j+1的最小乘次，因为是从0开始
     */
    static int[][] min_part = new int[count][count];

    /**
     * 计算矩阵最小乘次数
     * @param p 保存矩阵行列的数组
     * @param n 矩阵的个数
     * @param min_part 保存最小乘次数
     * @return
     */
    public static int function(int[] p, int n, int[][]min_part) {
        int j = 0;

        for (int i = 0; i < n; i++) {
            min_part[i][i] = 0;
        }

        //r为连乘矩阵的个数
        for (int r = 2; r <= n; r++) {
            //i表示连乘矩阵的第一个,从连乘矩阵个数为2开始计算 需要算n-r个
            for (int i = 0; i <= n - r; i++) {
                //j表示连乘矩阵中的最后一个
                j = i + r - 1;
                min_part[i][j] = Integer.MAX_VALUE;

                for (int k = i; k <= j-1; k++) {
                    //在第一个与最后一个之间寻找最合适的断开点
                    int tmp = min_part[i][k] + min_part[k+1][j] + p[i]*p[k+1]*p[j+1];

                    if (tmp < min_part[i][j]) {
                        min_part[i][j] = tmp;
                    }
                }
            }
        }
        return min_part[0][n-1];
    }

    public static void main(String[] args) {
        int[] p = new int[count+1];
        p[0] = 30;
        p[1] = 35;
        p[2] = 15;
        p[3] = 5;
        p[4] = 10;
        p[5] = 20;
        p[6] = 25;

        int ans = function(p,count,min_part);
        System.out.println(ans);
    }
}


