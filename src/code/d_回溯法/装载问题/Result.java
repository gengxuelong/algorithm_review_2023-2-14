package code.d_回溯法.装载问题;

import java.util.Arrays;

/**
 * @author GengXuelong
 * @version 1.0
 * {@code Mail} 3349495429@qq.com
 * {@code time} 2023/2/27 10:27
 * {@code className} Result
 * {@code description}:
 * 装载问题
 *      解向量: x[i] 为第i个元素是否出现,1代表出现,0代表不出现
 *      显示约束: x[i] = {0,1}
 *      隐式约束: 当x[i] ==1 时,w[i]之和小于c 且|c-wi之和|最小,也就是将第一艘船尽可能装满
 *
 *
 *
 */
public class Result {
    private static final int n = 3;
    private static final int c = 50;
    private static  int minValue = Integer.MAX_VALUE;
    private static  int maxCC = -1;
    private static  int cc = 0;
    private static  int[] minPath = new int[4];
    private static final int[] w = new int[]{0,10,40,50};//从1 开始
    private static final int[] x = new int[4];//从1开始

    public static void getResult(int t){
        if(t>n){
            System.out.println(Arrays.toString(x));
            System.out.println(c-cc);//如果以cc来看,是求尽可能大的值,需要上界函数限制.上界函数为: cc + w[i]x[i] + r[i] > maxCC;r[i] 为i后面所有集装箱重量之和
            System.arraycopy(x, 0, minPath, 0, 4);// 不要直接minPath = x;这样发生未知错误
            minValue = c-cc;
        }else{
            for(int i = 0;i<=1;i++){
                x[t] = i;
                cc += x[t]*w[t];
                if(cc<=c){
                    if(c-cc<= minValue) //把x[1]=1这一整只都减掉了
                        getResult(t+1);
                }
                cc -= x[t]*w[t];
            }
        }
    }

    private static int r = 0;
    static {
        for (int i = 1; i < w.length; i++) {
            r+=w[i];
        }
    }
    public static void getResult2(int t){
        if(t>n){
            System.out.println(Arrays.toString(x));
            System.out.println(cc);//如果以cc来看,是求尽可能大的值,需要上界函数限制.上界函数为: cc + w[i]x[i] + r[i] > maxCC;r[i] 为i后面所有集装箱重量之和
            Result.maxCC = cc;
        }else{
            r -= w[t];
            for(int i = 0;i<=1;i++){
                x[t] = i;
                cc += x[t]*w[t];
                if(cc<=c){
                    if(cc+r>maxCC)
                        getResult(t+1);
                }
                cc -= x[t]*w[t];//恢复现场
            }
        }
        r+= w[t];//恢复现场
    }

    public static void main(String[] args) throws InterruptedException {
        getResult2(1);
        System.out.println(Arrays.toString(minPath));
        System.out.println(maxCC);
    }
}
