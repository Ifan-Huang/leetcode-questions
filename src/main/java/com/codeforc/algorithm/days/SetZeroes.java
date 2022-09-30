package com.codeforc.algorithm.days;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 */
public class SetZeroes {

    /**
     * 需要存储记录当前行和当前列的信息。
     */
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0) return;
        if(matrix[0].length == 0) return;
        HashMap<String, Boolean> hashMap = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            int[] cols = matrix[i];

            for (int j = 0; j < cols.length; j++) {
                int col = cols[j];
                Boolean f = hashMap.get(i + "_" + j);

                if (col == 0 &&  (null == f || !f)) {
                    for (int x = 0; x < cols.length; x++) {
                        if(cols[x] != 0) {
                            cols[x] = 0;
                            hashMap.put(i + "_" + x, true);
                        }
                    }
                    for (int x = 0; x < matrix.length; x++) {
                        if(matrix[x][j]!=0) {
                            matrix[x][j] = 0;
                            hashMap.put(x + "_" + j, true);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SetZeroes setZeroes = new SetZeroes();
//        int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};
//        int[][] matrix = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        int[][] matrix = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};

        System.out.println(Arrays.deepToString(matrix));
        setZeroes.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));


        System.out.println("---");
        System.out.println("[[0,0,0,0],[0,4,5,0],[0,3,1,0]]");
    }
}
