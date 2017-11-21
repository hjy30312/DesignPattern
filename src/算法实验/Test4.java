package 算法实验;

/**
 * 题目描述
 风口之下，猪都能飞。当今中国股市牛市，真可谓“错过等七年”。
 给你一个回顾历史的机会，已知一支股票连续n天的价格走势，以长度为n的整数数组表示，数组中第i个元素（prices[i]）代表该股票第i天的股价。
 假设你一开始没有股票，但有至多两次买入1股而后卖出1股的机会，并且买入前一定要先保证手上没有股票。若两次交易机会都放弃，收益为0。
 设计算法，计算你能获得的最大收益。 输入数值范围：2<=n<=100,0<=prices[i]<=100
 示例1
 输入

 3,8,5,1,7,8
 输出

 12

 **/
public class Test4 {
    /**
     * 得到数组 一次买卖最大收益
     * @param prices
     * @param start
     * @param end
     * @return
     */
    public static int getMax(int[] prices, int start, int end) {
        int max = 0;
        int min = prices[start];
        for (int i = start+1; i < end; i++) {
            if (prices[i] - min > max ) {
                max = prices[i] - min;
            }
            if (min > prices[i]) {
                min = prices[i];
            }
        }
        return max;
    }
    public static int calculateMax(int[] prices) {
        /*解法一：时间复杂度O(n), 空间复杂度O(1)。
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;
        int i = 0;
        for (int curPrice : prices) {
            firstBuy = Math.max(firstBuy, -curPrice);
            firstSell = Math.max(firstSell, firstBuy + curPrice);
            secondBuy = Math.max(secondBuy,firstSell - curPrice);
            secondSell = Math.max(secondSell, secondBuy + curPrice);
        }
        return secondSell;
        */

        //解法二
        int max = 0;
        for (int i = 1; i+1 != prices.length;  i++) {
            int temp = getMax(prices,0,i) + getMax(prices,i+1,prices.length);
            max = Math.max(max, temp);
        }

        return max;
    }
    public static void main(String[] args) {
        int[] arr = new int[6];
        arr[0] = 3;
        arr[1] = 8;
        arr[2] = 5;
        arr[3] = 1;
        arr[4] = 7;
        arr[5] = 8;
        int ans = calculateMax(arr);
        System.out.println(ans);
    }

}
