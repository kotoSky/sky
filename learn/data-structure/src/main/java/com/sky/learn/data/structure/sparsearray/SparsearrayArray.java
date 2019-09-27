package com.sky.learn.data.structure.sparsearray;

/**
 * @Auther: HJH
 * @Date: 2019/9/27
 * @Description: TODO
 */
public class SparsearrayArray {

    public static void main(String[] args) {
        // 创建一个原始的二维数组 11*11
        // 0表示没有棋子， 1 黑子 2 蓝子
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][5] = 2;

        // 输出原始二维数组
        System.out.println("原始数组~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 创建对应的稀疏数组
        int sparsseArr[][] = new int[sum + 1][3];
        sparsseArr[0][0] = 11;
        sparsseArr[0][1] = 11;
        sparsseArr[0][2] = sum;

        int index = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    index++;
                    sparsseArr[index][0] = i;
                    sparsseArr[index][1] = j;
                    sparsseArr[index][2] = chessArr[i][j];
                }
            }
        }

        System.out.println("得到稀疏数组！");

        for (int[] row : sparsseArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }
}
