package code.c_动态规划.最长公共子序列;

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

    private static void printInts(int[][] c) {
        for (int[] ints : c) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
    }
}
