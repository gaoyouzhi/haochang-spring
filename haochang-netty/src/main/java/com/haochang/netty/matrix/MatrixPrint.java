package com.haochang.netty.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 描述：打印螺旋矩阵
 * @author: youzhi.gao
 * @date: 2021-02-03 14:42
 */
public class MatrixPrint {
    public static void main(String[] args) {
        int len = 5;
        int[][] ints = new int[len][len];
        int num = 1;
        for (int i = 0; i < len; i ++){
            for (int j = 0; j < len; j ++){
                System.out.println(num);
                ints[i][j] = num++;
            }
        }
        List<Integer> list = matrix(ints);

        System.out.println(Arrays.toString(list.toArray()));
    }

    private static List<Integer> matrix(int[][] ints) {
        List<Integer> result = new ArrayList<>();
        if (ints == null || ints.length == 0 || ints[0].length == 0){
            return result;
        }
        int rows = ints.length;
        int columns = ints[0].length;
        int total = rows * columns;

        //四个方向右 下 左 上
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        int row = 0;
        int column = 0;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < total; i++){
            result.add(ints[row][column]);

            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            visited[row][column] = true;

            //到达临界 或者已遍历过 换方向
            if(nextRow >= rows || nextColumn >= columns || nextRow < 0 || nextColumn < 0 || visited[nextRow][nextColumn]){
                directionIndex = (directionIndex + 1) % 4;
            }

            row += directions[directionIndex][0];
            column += directions[directionIndex][1];

        }

        return result;
    }

    public  List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }
}
