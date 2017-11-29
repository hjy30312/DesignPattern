package 算法实验.回溯m图着色;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author hjy
 * @create 2017/11/26
 **/

/**
 5 4
 0 1 1 1 0
 1 0 1 1 1
 1 1 0 1 0
 1 1 1 0 1
 0 1 0 1 0
 */
public class Test {

    static int[][] arr;  //邻接矩阵
    static int[] color;  //顶点对应的使用颜色种数
    static int count = 0;
    static int n;       //顶点数
    static int m;       //最多颜色数

    /**
     * 判断是否相邻顶点颜色互异
     * @param k
     * @param n
     * @return
     */
    public static boolean judge(int k, int n) {
        for (int i = 1; i <= n; i++) {
            //先判断是否邻接  再判断颜色是否相同
            if (arr[k][i] ==1  && color[i] == color[k]) {
                return false;
            }
        }
        return true;
    }

    /**
     * DFS：判断上色条件进行减枝，
     * 通过控制每个点上色的颜色进行判断回溯
     * @param k
     */
    public static void graphColor(int k) {
        if (k > n) {  //递归结束条件： 满足全部点都上色
            count++;
            return;
        } else {
                for (int i = 1; i <= m; i++) {
                    color[k] += i;
                    //通过判断减枝
                    if (judge(k, n)) {
                        graphColor(k + 1);
                    }
                    color[k] = 0;
                }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
       // System.out.println("请输入顶点数和颜色种类数：");
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n+1][n+1];
        color = new int[n+1];

        //图初始化
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        graphColor(1);
        if (count != 0) {
            System.out.println(count);
        } else {
            System.out.println("失败");
        }
    }
}
