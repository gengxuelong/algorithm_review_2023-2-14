package code.b_分治法.合并排序;

import java.util.Arrays;

/**
 * @author GengXuelong
 * @version 1.0
 * {@code Mail} 3349495429@qq.com
 * {@code time} 2023/2/26 18:04
 * {@code className} Result
 * {@code description}:
 */
public class Result {
    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * {code description}:
     *     合并排序基本思想:
     *     将待排序元素分成大小大致相同的2个子集合，分
     *      别对2个子集合进行排序，最终将排好序的子集合合并成为所
     *      要求的排好序的集合。
     *      start and end is index and both reached
     */
    public static void getResult(int[] array,int start,int end){
        if(start == end) return;
        if(start<end){
            int middle = (start+end)/2;
            getResult(array,start,middle);
            getResult(array,middle+1,end);
            int[] ints = new int[end-start+1];
            int index = 0;
            int start1 = start;
            int middle1 = middle+1;
            while(start1<=middle&&middle1<=end){
                if(array[start1] < array[middle1]){
                    ints[index++] = array[start1];
                    start1++;
                }else{
                    ints[index++] = array[middle1];
                    middle1++;
                }
            }
            if(start1<=middle){
                while(start1<=middle){
                    ints[index++] = array[start1++];
                }
            }
            if(middle1<=end){
                while(middle1<=end){
                    ints[index++] = array[middle1++];
                }
            }
            for(int i = start;i<=end;i++){
                array[i] = ints[i-start];
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,4,2,12,5,3,56,3,2};
        getResult(ints,0,ints.length-1);
        System.out.println(Arrays.toString(ints));
    }
}
