package com.example.sparsearray;

/**
 * 稀疏数组:当一个数组中大部分元素为０，或者为同一个值的数组时，可以使用稀疏数组来保存该数组。
 *
 * 稀疏数组的处理方法是:
 *      1) 记录数组一共有几行几列，有多少个不同的值
 *      2) 把具有不同值的元素的行列及值记录在一个小规模的数组中，从而缩小程序的规模
 */





/**
 * @program: DataStructures->SparseArray
 * @description: 稀疏数组
 * @author: hunyiha
 * @create: 2020-10-29 04:34
 **/
public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 1;

        System.out.println("原始的二维数组~~~~");
        for (int[] rows : chessArr) {
            for (int row : rows) {
                System.out.printf("%d\t" , row);
            }
            System.out.println();
        }


        // 将二维数组转稀疏数组的思路
        // 1.统计原二维数组中非0(或有效数据的个数)
        int count = 0;
        for (int[] rows : chessArr) {
            for (int row : rows) {
                if(row != 0){
                    count++;
                }
            }
        }

        // 2.定义稀疏数组
        int[][] sparseArray = new int[count+1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = count;

        int num = 1;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArr[i][j] != 0){
                    sparseArray[num][0] = i;
                    sparseArray[num][1] = j;
                    sparseArray[num][2] = chessArr[i][j];
                    num++;
                }
            }
        }

        System.out.println("转化为的稀疏数组~~~");

        for (int[] rows : sparseArray) {
            for (int row : rows) {
                System.out.printf("%d\t", row);
            }
            System.out.println();
        }

        System.out.println("将稀疏数组转化为二维数组");
        int[][] arr = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i <= count; i++) {
            arr[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("还原的数组~~~~");

        for (int[] rows : arr) {
            for (int row : rows) {
                System.out.printf("%d\t", row);
            }
            System.out.println();
        }
    }


}
