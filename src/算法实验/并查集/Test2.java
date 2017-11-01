package 算法实验.并查集;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * @author hjy
 * @create 2017/11/01
 **/
public class Test2 {
    private static final int MAX = Integer.MAX_VALUE;
    private static final int N = 505;
    private static int[][] arr = new int[N][N];
    private static int n;
    private static int[] lowcost = new int[N];

    public static void prim() {
        int[] sum = new int[n];  //最小生成树的各个权
        int min,k = 0,s=0;
        for (int i = 1; i <= n; i++) {
            lowcost[i] = arr[1][i];    //最初顶点到别点的距离
        }
        for (int i = 1; i <= n; i++) {
            min = MAX;
            for (int j = 1; j <= n; j++) {
                if (lowcost[j]!=0 && lowcost[j] < min) {
                    min = lowcost[j];
                    k = j;
                }
            }

            sum[s] = lowcost[k];
            s++;
            lowcost[k] = 0;

            for (int j = 1; j <= n; j++) {
                if ( lowcost[j]!=0 && arr[k][j] < lowcost[j] ) {
                    lowcost[j] = arr[k][j];
                }
            }
        }
        Arrays.sort(sum);
        System.out.println(sum[s-1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //城镇个数
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
        prim();
    }
}
