package 算法实验.并查集;

import java.util.Scanner;

/**
 * @author hjy
 * @create 2017/10/30
 **/
public class Test {

    public static int[] father = new int[1005];

    public static int Find(int x) {
        //递归实现
        if (x != father[x]) {
            x = Find(father[x]);
        }
        /*非递归实现
        while(x != father[x]) {
            x = father[x];
        }*/
        return x;
    }

    public static void Combine(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) {
            father[fa] = fb;
        }
    }

    public static void main(String[] args) {
        int n,m;
        int a,b;
        int sum = 0;
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            sum = 0;
            n = sc.nextInt(); //城镇数
            if (n == 0) {
                break;
            }

            m = sc.nextInt(); //路的条数

            //初始化城镇
            for (int i = 1; i <= n; i++) {
                father[i] = i;
            }

            for (int j = 0; j < m; j++) {
                a = sc.nextInt();
                b = sc.nextInt();
                Combine(a, b);
            }

            //找出所有独立的集合
            for (int i = 1; i <= n ; i++) {
                if (father[i] == i) {
                    sum++;
                }
            }
            //sum-1为还需的连通的路
            System.out.println("sum:" + (sum-1));
        }
        sc.close();
    }
}
