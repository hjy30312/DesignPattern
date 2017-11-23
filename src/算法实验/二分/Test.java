package 算法实验.二分;

import java.util.Arrays;

/**
 * @author hjy
 * @create 2017/11/23
 **/
public class Test {

    public static void main(String[] args) {

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }
        int ans = bSearch(arr,10,6);
        System.out.println(ans);
    }

    public static int bSearch(int[] A, int n, int val) {
        int left = 0, right = n-1, mid;

        while (left <= right) {
            mid = (left + right) >> 1;
            /*YES_LEFT或者NO_RIGHT
            if (A[mid] >= val) {
                right = mid -1;
            } */

            //YES_RIGHT或者NO_LEFT
            if (A[mid] > val) {
                right = mid -1;
            }else {
                left = mid +1;
            }

        }
        return left;
    }
}
