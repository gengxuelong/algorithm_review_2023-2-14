package code.c_动态规划.图像压缩问题;

/**
 * @author GengXuelong
 * @version 1.0
 * {@code Mail} 3349495429@qq.com
 * {@code time} 2023/2/27 1:33
 * {@code className} Result
 * {@code description}:
 */
public class Result {
    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * {code description}:
     *     p为输入的像素值,
     *     n为需处理前n个像素.
     *     s[i]代表p1-pi像素值的最小存储空间.
     *     l[i]代表第i个分段有几个像素,
     *     b[i]代表第i个分度采用的存储位数
     */
    public static void getResult(int[] p,int n,int[] s){
        s[0] = 0;
        int head = 11;
        for (int i = 1; i <=n; i++) {//分别计算s[i]的值
            int min = Integer.MAX_VALUE;
            for(int k = 0;k<i;k++){//切点为前k个像素
                s[i] = s[k]+(i-k)*getStorageBit(p,k+1,i)+head;
                if(s[i]<min)min = s[i];
            }
            s[i]= min;
        }
        System.out.println(s[n]);
    }

    public static void main(String[] args) {
        int[] p = new int[]{10,12,15,255,1,2};
        getResult(p,p.length,new int[p.length+1]);
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * {code description}:
     *     start and end both begin with 1,not index;both are reached;
     */
    private static int getStorageBit(int[] p, int start, int end) {
        int max = -1;
        for (int i = start; i <= end; i++) {
            int bit = getBit(p[i-1]);
            if(bit>max)max = bit;
        }
        return max;
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * {code description}:
     *     得到i用二进制表示的最小位数
     */
    private static int getBit(int i) {
        int k = 0;
        while(i>0){
            i = i/2;
            k++;
        }
        return k;
    }
}
