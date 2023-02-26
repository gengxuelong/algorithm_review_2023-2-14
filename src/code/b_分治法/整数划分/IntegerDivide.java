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


    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * {code description}:
     *     当m>n: result(m,n)  = result(n,n)
     *     当 m<=n: 当m = 1 or n = 1 : result = 1
     *            else: result(m,n) = result(m-1,n) + result( m,n-m)
     *
     */
    public static int getResult(int m,int n){
        if(n==1||m==1)return 1;
        else if(m>n)return getResult(n,n);
        else if(n!=m){
            return getResult(m-1,n) + getResult(m,n-m);//当n==m的时候，就不行了n-m可不能大于零呀
        }else{
            return getResult(m-1,n)+1;
        }
    }
}
