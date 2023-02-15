package code.c_动态规划.最大子段和问题;

/**
 * @author GengXuelong
 * @version 1.0
 * {@code Mail} 3349495429@qq.com
 * {@code time} 2023/2/15 16:11
 * {@code className} Main
 * {@code description}:
 */
public class Main {
    public static void main(String[] args) {
        int[] ints = new int[]{-2,11,-4,13,-5,-2};
        System.out.println(MaxSum.maxSum(ints, 0, ints.length - 1));
        System.out.println(MaxSum.maxSum2(ints));
    }
}
