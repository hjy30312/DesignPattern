package 算法实验;

import java.util.*;


class Arr implements Comparable<Arr>{
	public int start;
	public int end;
	/**
	 * 按结束时间递增排序
	 * @param o
	 * @return
	 */
	@Override
	public int compareTo(Arr o) {
		// TODO Auto-generated method stub
		if (o.end > this.end) {
			return -1;
		} else if (o.end < this.end) {
			return 1;
		} else {
			return 0;
		}
	}
}

public class Test2 {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Arr[] arr = new Arr[n];

		for (int i = 0; i < n; i++) {
			arr[i] = new Arr();
			arr[i].start = sc.nextInt();
			arr[i].end = sc.nextInt();
		}
		sc.close();
		
		Arrays.sort(arr);

		//保存结束时间，与下一个开始时间作比较
		int flag = 0;
		for (int i = 0; i < n; i++) {
			if (flag <= arr[i].start) {
				flag = arr[i].end;
				System.out.println("start:" + arr[i].start + " end:" + arr[i].end);
			}
		}
	}
}
