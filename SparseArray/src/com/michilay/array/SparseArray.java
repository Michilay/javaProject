package com.michilay.array;

/**
 * @author Michilay
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个11*11的二位数组
        int[][] arrayx = new int[11][11];
        arrayx[1][2] = 22;
        arrayx[2][3] = 34;
        arrayx[7][9] = 15;
        arrayx[6][6] = 6;
        arrayx[10][10] = 2;
        System.out.println("输出原始数组");
        show(arrayx);
        System.out.println("转换的稀疏数组");
        int[][] arrays = tTd(arrayx);
        show(arrays);
        System.out.println("还原为二维数组");
        int[][] arrayt = dTt(arrays);
        show(arrayt);
    }
    //显示二维数组
    static void show(int[][] array){
        for (int[] ints : array){
            for (int anInt: ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
    //二维数组转换为稀疏数组
    static int[][] tTd(int[][] array){

        //sum为有效值的个数
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[i][j] != 0){
                    sum++;
                }
            }
        }
        //创建稀疏数组
        int[][] array1 = new int[sum+1][3];
        array1[0][0] = array.length;
        array1[0][1] = array.length;
        array1[0][2] = sum;

        //遍历二位数组，将非零的值，放在系数数组中
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0){
                    count++;
                    array1[count][0] = i;
                    array1[count][1] = j;
                    array1[count][2] = array[i][j];
                }
            }
        }
        return array1;
    }

    //稀疏数组转换为二维数组
    static int[][] dTt(int[][] array){
        int[][] array1 = new int[array[0][0]][array[0][1]];
        //从第一行开始
        for (int i = 1; i < array.length; i++) {
            array1[array[i][0]][array[i][1]] = array[i][2];
        }
        return array1;
    }
}
