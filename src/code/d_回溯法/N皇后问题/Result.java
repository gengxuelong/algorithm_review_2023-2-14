package code.d_回溯法.N皇后问题;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author GengXuelong
 * @version 1.0
 * {@code Mail} 3349495429@qq.com
 * {@code time} 2023/2/27 3:59
 * {@code className} Result
 * {@code description}:
 *      n皇后问题:
 *      解向量: 每一行只有一个皇后,设x[i]的值为第i行皇后的列数
 *      显示约束:1<= x[i] <= n;
 *      隐式约束: 不同行,不同列,不同正斜线 x[i] != x[j]  && |i-j| != |x[i]-x[j]|
 *      子集问题
 *
 */
public class Result {
    private static final int n = 8;
    private static final int[] x = new int[8];
    public static void getResult(int t){
        if(t>n){
            System.out.println(Arrays.toString(x));
        }else{
            for(int i = 1;i<= n;i++){
                x[t-1] = i;
                if(constraint(x,t,i)){
                    getResult(t+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        getResult(1);
    }


    private static boolean constraint(int[] x, int t, int result) {
        t = t-1;
        for(int i = 0;i<t;i++){
            if(x[i] == result || Math.abs(t-i)==Math.abs(result-x[i]))return false;
        }
        return true;
    }
}
