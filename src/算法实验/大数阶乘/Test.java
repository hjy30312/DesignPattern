package 算法实验.大数阶乘;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author hjy
 * @create 2017/12/03
 **/
public class Test {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigDecimal ans = new BigDecimal(1);
        BigDecimal a;
        for (int i = 1; i <= n; i++) {
            a = new BigDecimal(i);
            ans = ans.multiply(a);
        }
        System.out.println(ans);
    }

}
