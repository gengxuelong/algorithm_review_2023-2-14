package code.b_分治法.整数划分;

/**
 * @author GengXuelong
 * @version 1.0
 * {@code Mail} 3349495429@qq.com
 * {@code time} 2023/2/14 22:32
 * {@code className} IntegerDivide
 * {@code description}:
 */
public class IntegerDivide {
    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * {code description}:
     *     n: 划分整数   m:子数最大值。。均必须为正数
     */
    public static int integerDivide(int n,int m){
        if(n<=0||m<=0)throw  new RuntimeException("输入参数必须为正数");
        if(n==1||m==1)return 1; //出口
        if(n==m){
            return integerDivide(n,m-1)+1;
        }else if(n>m){
            return integerDivide(n,m-1)+integerDivide(n-m,m);//关键步骤，既：不含最大值的所有和定包含最大值的情况
        }else {
            return integerDivide(n,n);
        }
    }
}
