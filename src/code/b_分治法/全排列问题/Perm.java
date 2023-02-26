package code.b_分治法.全排列问题;

import java.util.Arrays;

/**
 * @author GengXuelong
 * @version 1.0
 * {@code Mail} 3349495429@qq.com
 * {@code time} 2023/2/14 21:57
 * {@code className} Perm
 * {@code description}:
 */
public class Perm {
    private static int count;
    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * {code description}:
     *     start and end 都是坐标，都可以取到。
     *     获取结合的全排列
     */
    public static void perm(int[] a,int start,int end){
        if(start == end){
            System.out.print(Arrays.toString(a));
            System.out.println(++count);
        }
        for (int i = start; i <= end; i++) {
            swap(a,start,i);
            perm(a,start+1,end);
            swap(a,start,i);//一定要换回去
        }
    }
    private static void swap(int[]a,int i,int j){
        if(i>=a.length||j>=a.length||i<0||j<0)
            throw new RuntimeException("超出数组范围");
        int temp = a[i];
        a[i] = a[j] ;
        a[j] = temp;
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * {code description}:
     *     start and end都是坐标，从零开始。左闭右闭
     *     出口：要明白这个算法到底是为了干什么：当只要求对start = end的情况下进行全排序的时候，你会做什么
     *     那肯定是全排列只有一种情况呀，直接输出就好了
     *     合并：需要O(n)的复杂度，因为分成了n份，只需要挨个执行这n个就行了，也就是执行了n次
     */
    public static void perm2(int[] a,int start,int end){
        if(start == end){
            System.out.println(Arrays.toString(a));
        }else if(start<end){
            for (int i = start; i <= end; i++) {
                swap(a,start,i);
                perm2(a,start+1,end);
                swap(a,start,i);
            }
        }
    }
}
