package code.a_算法概述.a_在给定序列中查找元素;

/**
 * @author GengXuelong
 * @version 1.0
 * {@code Mail} 3349495429@qq.com
 * {@code time} 2023/2/14 18:09
 * {@code className} Main
 * {@code description}:
 */
public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(SequentialSearch.sequentialSearch(a,-3));
        System.out.println(BinarySearch.binarySearch_recursion(a,3,0,9));
    }
}
