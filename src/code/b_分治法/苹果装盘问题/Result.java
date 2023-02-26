package code.b_分治法.苹果装盘问题;

/**
 * @author GengXuelong
 * @version 1.0
 * {@code Mail} 3349495429@qq.com
 * {@code time} 2023/2/26 17:30
 * {@code className} Result
 * {@code description}:
 */
public class Result {
    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * {code description}:
     *     问题：把m个苹果放入n个盘子中，允许有的盘子为空，共有多少种方法？
     * 注：
     * 5,1,1和1 5 1属同一种方法
     * m,n均小于10
     */
    public static int getResult(int m,int n){
        if(n == 1 || m == 1)return 1;
        if(n>m) return getResult(m,m);
        if(m==n) return getResult(m,m-1)+1; //最多放m-1个盘子的情况，加上放m个盘子的情况
        return getResult(m, n - 1) + getResult(m - n, n); //当m>n时
    }


    public static void main(String[] args) {
        System.out.println(getResult(6,6));
    }
}
