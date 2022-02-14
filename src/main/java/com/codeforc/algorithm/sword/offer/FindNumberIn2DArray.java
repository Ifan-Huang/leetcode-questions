package com.codeforc.algorithm.sword.offer;

//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
//请完成一个高效的函数，输入这样的一个二维数组 和 一个整数，判断数组中是否含有该整数。
public class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++) {
            int[] arr = matrix[i];
            if(binarySearch(arr, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(target == arr[mid]) {
                return true;
            }
            if(target > arr[mid]) {
                left = mid + 1;
            }
            if(target < arr[mid]) {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] ar = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        FindNumberIn2DArray findNumberIn2DArray = new FindNumberIn2DArray();
        boolean numberIn2DArray = findNumberIn2DArray.findNumberIn2DArray(ar, 5);
        System.out.println(numberIn2DArray);
    }
}
