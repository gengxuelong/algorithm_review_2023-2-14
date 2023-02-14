package code.a_算法概述.a_在给定序列中查找元素;

/**
 * @author GengXuelong
 * @version 1.0
 * {@code @Mail} 3349495429@qq.com
 * {@code @time} 2023/2/14 17:58
 * {@code @className} SequentialSearch
 * {@code @description:}
 */
public class SequentialSearch {
    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * {code description}:
     *     序列查找
     *  第一步：初始化下标变量i指向序列a的第一个元素;
     * 第二步：比较a[i]和x;
     * 第三步：若a[i]等于x ，返回i值；否则进入第四步;
     * 第四步：i值加1，若i增量小于a的长度返回第二步；否则返回-1。
     */
    public static int sequentialSearch(int[] ints,int e){
        int i = 0;//index
        while(i<ints.length){
            if(ints[i] == e){
                return i;
            }else{
                i++;
            }
        }
        return -1;
    }
}
