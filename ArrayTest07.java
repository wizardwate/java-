package array;

import java.util.Arrays;

public class ArrayTest07 {
    public static void main(String[] args) {
        /*
        首先定义一个5X8的二维数组，然后使用随机数填充满。
借助Arrays的方法对二维数组进行排序。
参考思路：
先把二维数组使用System.arraycopy进行数组复制到一个一维数组
然后使用sort进行排序
最后再复制回到二维数组
         */
        int[][] array = new int[5][8];
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array[i].length ; j++) {
                array[i][j] = (int)(Math.random()*100);
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        int[] a = new int[40];
        int b[] = new int[array.length * array[0].length];
        //通过for循环，把每行每列的元素放进一维数组
        for (int i = 0; i <array.length ; i++) {
            System.arraycopy(array[i],0,b,i*array[i].length,array[i].length);
        }
        Arrays.sort(b);
        System.out.println(Arrays.toString(b));
        //一维数组放到二维去
        for (int i = 0; i <array.length ; i++) {
            //意思是，一开始先把一维数组的八个数字放进二维数组的第一行，二维数组第一行的位置是array[0]的1-8位置
            System.arraycopy(b, array[i].length * i, array[i], 0, array[i].length);
        }
        for (int[] i:array
             ) {
            System.out.println(Arrays.toString(i));
        }
    }
}
