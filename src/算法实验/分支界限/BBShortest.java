package 算法实验.分支界限;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class BBShortest {
    public static class Heapnode implements Comparable{
        int id;//顶点编号
        int length;//当前路长
        public Heapnode(int ii,int ll){
            id=ii;
            length=ll;
        }

        /**
         * 优先队列规则：length小的在前  结点按length升序
         */
        @Override
        public int compareTo(Object x) {
            int xl=((Heapnode)x).length;
            if(length<xl) return -1;
            if(length==xl) return 0;
            return 1;
        }


    }


    /**
     * ans[j]保存从源到顶点j的距离;p[j]记录从源到顶点j的路径上的前驱顶点
     * @param arr
     * @param v
     * @param ans
     * @param p
     */
    public static void shortest(int[][] arr,int v,int[] ans,int[] p){
        int n=p.length;
        LinkedList<Heapnode> nodes=new LinkedList<Heapnode>();//用LinkedList存储最小堆
        Heapnode enode=new Heapnode(v,0);

        //初始化   源点到j的距离都为最大
        for(int j=0;j<n;j++){
            ans[j] =Integer.MAX_VALUE;
        }

        while(true){//搜索问题解空间
            for(int j=1;j<n;j++){

                //通过与到达点的最短路径进行比较达到剪枝
                if(arr[enode.id][j]!=-1 && enode.length+arr[enode.id][j]<ans[j]){
                    //顶点i到j可达，同时长度小于ans[j]
                    ans[j]=enode.length+arr[enode.id][j];    //更改点J的最短路径
                    p[j]=enode.id;          //解编号 放入保存前驱结点数组
                    Heapnode e=new Heapnode(j,ans[j]);
                    nodes.add(e);

                    Collections.sort(nodes);
                }
            }
            //取下一个扩展结点 若没有结点则完成搜索
            if(nodes.isEmpty()) {
                break;
            } else {
                enode=(Heapnode) nodes.poll();
            }

        }
        for(int i=1;i<n;i++){
            System.out.println(i+"节点的最短距离是："+ans[i]+"；前驱点是："+p[i]);
        }

        /**
         * 输出最短路径
         */
        int i = n-1; //终点
        System.out.print(i);

        while (i != 0) {
            System.out.print("->");
            System.out.print(p[i]);
            i = p[i];
        }

    }
    public static void main(String[] args) {
        System.out.println("请输入图顶点的个数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("请输入图的路径长度：");
        int[][] arr = new int[n][n];//下标从1开始，以下都是
        int[] ans = new int[n];    //存放源点到结点的最短路径
        int[] prev = new int[n];   //保持前驱结点数字

        for(int i=0; i < n;i++){

            for(int j = 0; j < n; j++){
                arr[i][j]= sc.nextInt();
            }
        }
        int v = 0;//顶点从1开始

        shortest(arr, v, ans, prev);
    }
}
/**
 * 以下为输入输出
 *
 * 输入：

 7
 -1 2 8 5 -1 -1 -1
 -1 -1 3 -1 3 -1 -1
 -1 -1 -1 -1 3 4 -1
 -1 -1 -1 -1 -1 6 9
 -1 -1 -1 -1 -1 5 7
 -1 -1 -1 -1 -1 -1 2
 -1 -1 -1 -1 -1 -1 -1

 * 输出：
 1节点的最短距离是：2；前驱点是：0
 2节点的最短距离是：5；前驱点是：1
 3节点的最短距离是：5；前驱点是：0
 4节点的最短距离是：5；前驱点是：1
 5节点的最短距离是：9；前驱点是：2
 6节点的最短距离是：11；前驱点是：5
 6->5->2->1->0
 */