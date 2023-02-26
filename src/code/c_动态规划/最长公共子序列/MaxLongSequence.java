package code.c_动态规划.最长公共子序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author GengXuelong
 * @version 1.0
 * {@code Mail} 3349495429@qq.com
 * {@code time} 2023/2/15 15:36
 * {@code className} MaxLongSequence
 * {@code description}:
 */
public class MaxLongSequence {
    public static void maxLongSequence(char[] seq1,char[] seq2){
        int[][] c = new int[seq1.length+1][seq2.length+1];
        int[][] b = new int[seq1.length+1][seq2.length+1];
        for (int i = 1; i < seq1.length+1; i++) {
            for (int j = 1; j < seq2.length+1; j++) {
                if(seq1[i-1]==seq2[j-1]){
                    c[i][j] = c[i-1][j-1]+1;
                    b[i][j] = 1;//记录本子问题的结果由那个子问题得出
                }else if(c[i][j-1]>c[i-1][j]){
                    c[i][j] = c[i][j-1];
                    b[i][j] = 2;
                }else{
                    c[i][j] = c[i-1][j];
                    b[i][j] = 3;
                }
            }
        }
        printInts(c);
        System.out.println("---------------------------");
        printInts(b);
    }

    /**
     * @author GengXuelong
     * <p> 函数功能描述如下:
     * {code description}:
     *      最长公共子序列,动态规划
     */
    public static void getResult(char[] chars1,char[] chars2){
        int m = chars1.length;
        int n = chars2.length;
        int[][] doubleArray = new int[m+1][n+1];// doubleArray[i][j]代表chars1前i个,和chars2前j个的最长子序列
        int[][] s = new int[m+1][n+1];// s[i][j]代表chars1前i个,和chars2前j个的最长子序列取决于那个子序列,1代表[i-1][j],2代表[i][j-1] 3:[i-1][j-1]
        for (int i = 0; i <= m; i++) {
            doubleArray[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            doubleArray[0][i] = 0;
        }//第一行和第一列肯定都是零
        for(int i=1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(chars1[i-1]==chars2[j-1]){
                    s[i][j] = 3;
                    doubleArray[i][j] = doubleArray[i-1][j-1]+1;
                }else{
                    if(doubleArray[i-1][j]>doubleArray[i][j-1]){
                        s[i][j] = 1;
                        doubleArray[i][j] = doubleArray[i-1][j];
                    }else{
                        s[i][j] = 2;
                        doubleArray[i][j] = doubleArray[i][j-1];
                    }
                }
            }
        }
        printInts(doubleArray);
        System.out.println("==========================");
        printInts(s);
        ArrayList<Character> characterArrayList = new ArrayList<>();
        int x = m;
        int y = n;
        while(x>0&&y>0){
            if(s[x][y]==3){
                characterArrayList.add(chars1[x-1]);
                x-=1;
                y-=1;
            }else if(s[x][y] == 1){
                x-=1;
            }else{
                y-=1;
            }
        }
        Object[] objects = characterArrayList.toArray();
        char[] chars = new char[objects.length];
        for (int i = 0; i < objects.length; i++) {
            chars[objects.length-i-1] = (char) objects[i];
        }
        System.out.println(chars);
    }


    private static void printInts(int[][] c) {
        for (int[] ints : c) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
    }
}
