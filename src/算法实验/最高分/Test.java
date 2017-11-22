package 算法实验.最高分;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 输入包括多组测试数据。
 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 学生ID编号从1编到N。
 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，
 他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 输出描述:
 对于每一次询问操作，在一行里面输出最高成绩.
 **/
public class Test {
    public static int getMax(int start, int end, int[] arr) {
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }

        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            max = max > arr[i] ? max : arr[i];
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringTokenizer st;
        while ((line = br.readLine()) != null) {
            //学生的数目
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] arr = new int[n + 1];

            //初始成绩
            if ((line=br.readLine()) != null) {
                st = new StringTokenizer(line);
                for (int i = 1; i < arr.length; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 1; i <= m; i++) {
                if((line=br.readLine())!=null) {
                    st = new StringTokenizer(line);
                    String str = st.nextToken();
                    //询问
                    if ("Q".equals(str)) {
                        int start = Integer.parseInt(st.nextToken());
                        int end = Integer.parseInt(st.nextToken());
                        int ans = getMax(start, end, arr);
                        System.out.println(ans);
                    } else {
                        //修改
                        int position = Integer.parseInt(st.nextToken());
                        int newScore = Integer.parseInt(st.nextToken());
                        arr[position] = newScore;
                    }
                }
            }
        }
    }
}
