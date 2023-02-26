package code.c_动态规划.矩阵连乘;

/**
 * @author GengXuelong
 * @version 1.0
 * {@code Mail} 3349495429@qq.com
 * {@code time} 2023/2/26 21:56
 * {@code className} Result
 * {@code description}:
 */
public class Result {
    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * {code description}:
     *     解释:
     *     m[i][j]的值为从第i个矩阵到第j个矩阵相乘的最小次数
     *     n代表前n个矩阵相乘
     *     p[]代表多个矩阵相乘的矩阵的列数,最后一个数为最后一个矩阵的行数
     *     s[i][j]的值为从第i个矩阵到第j个矩阵相乘最佳切割点
     */
    public static int getResult(int[] p,int n,int[][] m,int[][] s){
        for (int i = 0; i < n; i++) {
            m[i][i] = 0;//只有一个矩阵相乘的时候其相乘最下数量肯定为0;
        }
        for(int l = 2;l<=n;l++){//链长为l的矩阵连乘
            for(int i = 0;i<n-l+1;i++){//求m[][]中各个休斜对角线的值,挨个求长度为l的m[][]中的值
                int max = -1;
                int j = i+l-1;
                for(int k = 1;k<=j-1;k++){ //最佳分割点

                    m[i][j] =
                            m[i][i+k-1]+m[i+k][j]
                                    + p[i]*p[k+1]*p[j+1];
                    if(m[i][j]>max){
                        s[i][j] = k;
                    }
                }
            }
        }
        return m[0][n-1];
    }

    public static void main(String[] args) {
        int n = 6;
        int[] p = new int[]{30,35,15,5,10,20,25};
        int[][] m= new int[6][6];
        int[][] s= new int[6][6];
        System.out.println(getResult(p,n,m,s));
    }
}
