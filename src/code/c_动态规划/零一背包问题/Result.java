package code.c_动态规划.零一背包问题;

/**
 * @author GengXuelong
 * @version 1.0
 * {@code Mail} 3349495429@qq.com
 * {@code time} 2023/2/27 2:53
 * {@code className} Result
 * {@code description}:
 */
public class Result {
    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * {code description}:
     *     0-1背包  动态规划
     *     设m[i][j]是0-i个物品可供选择,背包容量为j 时可以装的最大价值,也就是最优值
     */
    public static void getResult(int[] w,int[] v,int c){
        int n = w.length;
        int[][] m = new int[n+1][c+1];
        for(int i = 0;i<=n;i++)m[i][0]=0;
        for(int i = 0;i<=c;i++)m[0][i]=0;//初始化
        for(int i = 1;i<=n;i++){
            for(int j= 1;j<=c;j++){
                if(j-w[i-1]>=0)
                    m[i][j] = Math.max(m[i-1][j-w[i-1]]+v[i-1],m[i-1][j]);
                else
                    m[i][j] =m[i-1][j];
            }
        }
        System.out.println(m[n][c]);
    }

    public static void main(String[] args) {
        int[] w = new int[]{2,2,6,5,4};
        int[]v = new int[]{6,3,5,4,6};
        int c = 10;
        getResult(w,v,c);
    }
}
