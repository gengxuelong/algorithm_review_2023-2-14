package code.c_动态规划.最大子段和问题;

/**
 * @author GengXuelong
 * @version 1.0
 * {@code Mail} 3349495429@qq.com
 * {@code time} 2023/2/15 16:11
 * {@code className} MaxSum
 * {@code description}:
 */
public class MaxSum {
    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * {code description}:
     *     left and right都是index，都可以取到
     *     分治法
     */
    public static int maxSum(int[] ints,int left,int right){
        int sum = 0;
        if(left == right) sum = Math.max(ints[left], 0);
        else{
            int center = (left+right)/2;
            int leftSum = maxSum(ints,left,center);
            int rightSum = maxSum(ints,center+1,right);
            int s1=0;
            int temp1=0;
            for(int i = center;i>=left;i--){
                temp1 += ints[i];
                if(temp1>s1){
                    s1 = temp1;
                }
            }
            int s2 = 0;
            int temp2 = 0;
            for(int i = center+1;i<=right;i++){
                temp2 += ints[i];
                if(temp2>s2){
                    s2 = temp2;
                }
            }
            sum = s1 + s2;
            if(sum<leftSum)sum = leftSum;
            if(sum<rightSum)sum = rightSum;
        }
        return sum;
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * {code description}:
     *     left and right都是index，都可以取到
     *     动态规划
     */
    public static int maxSum2(int[] ints){
        int sum = 0;
        int lastSum = 0;
        for (int i = 0; i < ints.length; i++) {
            if(lastSum>0)lastSum+=ints[i];
            else{
                lastSum = ints[i];
            }
            if(lastSum>sum)sum = lastSum;
        }
        return sum;
    }

}
