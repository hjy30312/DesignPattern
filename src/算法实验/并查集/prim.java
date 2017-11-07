package 算法实验.并查集;

import java.util.Arrays;

/**
 * @author hjy
 * @create 2017/11/07
 **/
public class prim {

    private static final int MAX = Integer.MAX_VALUE;

    public static void prim(int[][] arr , int n) {

        int[] lowcost = new int[n];
        int[] mst = new int[n];
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
    }
}
