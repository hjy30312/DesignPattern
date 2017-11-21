package 算法实验;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FilterInputStream;
/**
 * 设有n=2k个运动员要进行网球循环赛。
 * 现要设计一个满足以下要求的比赛日程表：
 * ⑴每个选手必须与其他n-1个选手各赛一次；
 * ⑵每个选手一天只能赛一次；⑶循环赛一共进行n-1天。
 * 按此要求可将比赛日程表设计－成有n行和n-l列的一个表。
 * @author hjy
 * @create 2017/10/23
 **/
public class Test1 {


    public static void f(int[][] map, int x, int y, int k) {
        if (k == 1){
            return;
        }
        k /= 2;
        //左上
        f(map,x,y,k);
        //右上
        f(map,x,y+k,k);

        for (int i = 0; i < k; i++) {
            //第一重循环控制y轴
            for (int j = 0; j < k; j++) {
                //右下角等于左上角
                map[x+k+i][y+k+j] = map[x+i][y+j];
                //左下角等于右上角
                map[x+k+i][y+j] = map[x+i][y+k+j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        //因2的幂次方总是最高位为1 其余为0
        if ((n&(n-1)) != 0) {
            System.out.println("请输入2的幂次方！");
            return;
        }

        int[][] map = new int[n][n];
        //赛程表初始化
        for (int i = 0; i < n; i++)
        {
            map[0][i] = i+1;
        }

        f(map,0,0,n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
