package code.d_回溯法.货郎担问题;

import java.util.Arrays;

/**
 * @author GengXuelong
 * @version 1.0
 * {@code Mail} 3349495429@qq.com
 * {@code time} 2023/2/27 4:18
 * {@code className} Result
 * {@code description}:
 *      货郎担问题,回溯法
 *      解向量: x[i] 表示符合要求的路线中第i个到达的城市编号
 *      显示约束: x[i] = {1,2,3,4}
 *      隐式约束: x[i] != x[j] ,x[1] = 1,x[i]-x[i-1] 存在边  x[n]-x[1] 存在边
 */
public class Result {
    private final static int n = 4;
    private final static int[] x = new int[]{0,1,2,3,4}; //从1 开始算
    private final static int[][] edge = new int[][]{{0,0,0,0,0},{0,0,10,6,4},{0,10,0,5,10},{0,6,5,0,20},{0,4,10,20,0}};
    private  static int minPathNum=Integer.MAX_VALUE;
    private  static int cc=0;
    private  static int[] minPath=new int[n+1];
    public static void getResult(int t){
        if(t>n){
            System.out.println(Arrays.toString(x));
            minPathNum = cc;
            for (int i = 0; i < n + 1; i++) {
                minPath[i] = x[i];
            }
        }else{
            for(int i = start(t,n);i <= end(t,n);i++){
                swap(x,t,i);
                if(constraints(x,t)){
                    if(t>1){
                        int last = x[t-1];
                        int now = x[t];
                        cc += edge[last][now];
                        if(t==n){
                            cc += edge[now][1];
                        }
                    }
                    getResult(t+1);
                    if(t>1){
                        int last = x[t-1];
                        int now = x[t];
                        cc -= edge[last][now];
                        if(t==n){
                            cc -= edge[now][1]; //还原机制
                        }
                    }
                }
                swap(x,t,i);;
            }
        }
    }

    public static void main(String[] args) {
        getResult(1);
        System.out.println(minPathNum);
        System.out.println(Arrays.toString(minPath));
    }

    private static boolean constraints(int[] x, int t) {
        if(t == 1) return true;
        int last = x[t-1];
        int now = x[t];
        if(cc>=minPathNum)return false;
        if(t!=n){
            return edge[last][now] > 1;
        }else{
            return edge[last][now] > 1 && edge[1][now] > 1;
        }
    }

    private static void swap(int[] x, int t, int i) {
        int temp = x[t];
        x[t] = x[i];
        x[i] = temp;
    }

    private static int end(int t, int n) {
        if(t==1)return 1;
        return n;
    }

    private static int start(int t, int n) {
        return t;
    }
}
