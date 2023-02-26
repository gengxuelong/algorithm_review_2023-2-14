package code.c_动态规划.最长公共子序列;

/**
 * @author GengXuelong
 * @version 1.0
 * {@code Mail} 3349495429@qq.com
 * {@code time} 2023/2/15 15:37
 * {@code className} Main
 * {@code description}:
 */
public class Main {
    public static void main(String[] args) {
        char[] a = "hello,howayoudoing".toCharArray();
        char[] b = "dshahhahelloyagengxuelong".toCharArray();
        MaxLongSequence.maxLongSequence(a,b);
        System.out.println();
        System.out.println();
        System.out.println();
        MaxLongSequence.getResult(a,b);
    }
}
