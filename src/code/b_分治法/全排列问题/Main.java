package code.b_分治法.全排列问题;

/**
 * @author GengXuelong
 * @version 1.0
 * {@code Mail} 3349495429@qq.com
 * {@code time} 2023/2/14 22:09
 * {@code className} Main
 * {@code description}:
 */
public class Main {
    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,4,5};
        Perm.perm(ints,0,ints.length-1);
        System.out.println(5 * 4 * 3 * 2);
    }
}
