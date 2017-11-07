package 算法实验;

import java.util.Scanner;

/**
 * @author hjy
 * @create 2017/11/07
 **/
public class Test3 {
    private static final int MAX = Integer.MAX_VALUE;
    private static final int N = 105;
    private static int[][] arr = new int[N][N];
    private static int n;

    public static int prim(int[][] arr , int n) {

        int[] lowcost = new int[n+1];
        int[] mst = new int[n+1];
        int min, k = 0, count = 0;

        //最小生成树总权值
        int sum = 0;

        //初始化
        for (int i = 1; i <= n; i++) {
            lowcost[i] = arr[1][i];     //最初顶点到别点的距离
        }

        for (int i = 1; i <= n; i++) {
            min = MAX;
            //找出最小边的权值
            for (int j = 1; j <= n; j++) {
                if (lowcost[j]!=0 && lowcost[j] < min) {
                    min = lowcost[j];
                    k = j;
                }
            }

            //加入
            mst[count++] = lowcost[k];
            sum += lowcost[k];

            //更新lowcost
            lowcost[k] = 0;
            for (int j = 1; j <= n; j++) {
                if ( lowcost[j]!=0 && arr[k][j]<lowcost[j] ) {
                    lowcost[j] = arr[k][j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (sc.hasNext()) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = prim(arr, n);
            System.out.println(ans);
        }
    }
}
