package code.a_算法概述.a_在给定序列中查找元素;

/**
 * @author GengXuelong
 * @version 1.0
 * {@code Mail} 3349495429@qq.com
 * {@code time} 2023/2/14 18:12
 * {@code className} BinarySearch
 * {@code description}:
 */
public class BinarySearch {
    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * {code description}:
     *     二分法查找
     */
    public static int binarySearch(int[] a,int e){
        int head = 0;
        int tail = a.length;
        int temp;
        while(head <= tail){
            temp = (tail+head)>>1;
            if(a[temp] < e){
                head = temp + 1;
            }else if(a[temp]>e){
                tail = temp - 1;
            }else{
                return temp;
            }
        }
        return -1;
    }
    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * {code description}:
     *     二分法，递归，tail 取不到，head可以取到
     */
    public static int binarySearch_recursion(int[] a,int e,int head,int tail){
        int temp = (head+tail)>>2;
        if(head>tail)return -1;
        if(a[temp]>e){
            return binarySearch_recursion(a,e,head,temp-1);
        }else if(a[temp]<e){
            return binarySearch_recursion(a,e,temp+1,tail);
        }else{
            return temp;
        }
    }

}
