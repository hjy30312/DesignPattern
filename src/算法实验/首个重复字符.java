package 算法实验;

/**
 * 对于一个字符串，请设计一个高效算法，找到第一次重复出现的字符。
 给定一个字符串(不一定全为字母)A及它的长度n。请返回第一个重复出现的字符。
 保证字符串中有重复字符，字符串的长度小于等于500。
 测试样例：
 "qywyer23tdd",11
 返回：y
 *
 *
 *
 * 哈希的思想
 * @author hjy
 * @create 2017/11/23
 **/



import javax.swing.table.AbstractTableModel;
public class 首个重复字符 {

    public char findFirstRepeat(String A, int n) {
        // write code here
        char[] charArr = A.toCharArray();   //String分割成char数组
        int[] arr = new int[256]; //ASCLL范围
        for (int i = 0; i < n; i++) {
            if (arr[charArr[i]] == 1) {
                return charArr[i];
            } else {
                arr[charArr[i]] = 1;
            }
        }
        return 0;

    }
}
