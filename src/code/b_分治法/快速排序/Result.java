package code.b_分治法.快速排序;

import java.util.Arrays;

/**
 * @author GengXuelong
 * @version 1.0
 * {@code Mail} 3349495429@qq.com
 * {@code time} 2023/2/26 20:53
 * {@code className} Result
 * {@code description}:
 */
public class Result {
    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * {code description}:
     *     start and end is index and both is reached;
     */
    public static void getResult(int[] array,int start,int end){
        if(end<=start)return;
        int key = soloRun(array,start,end);
        getResult(array,start,key-1);
        getResult(array,key+1,end);

    }
    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * {code description}:
     *     单次排序,返回哨兵的index
     */
    private static int soloRun(int[] array,int start,int end){
        int guard = array[start];
        int p = start;
        int q = end;
       while(p<q){
           while(p<q&&array[q] > guard){
               q--;
           }
           if(p<q){
               array[p] = array[q];
               p++;
           }
           while(p<q&&array[p] < guard){
               p++;
           }
           if(p<q){
               array[q] = array[p];
               q--;
           }
       }
       array[p] = guard;
       return p;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,2,1,2,3,5,645,23,232};
        getResult(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
