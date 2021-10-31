package struct;

import java.util.Scanner;

public class SwitchTest01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int season = scanner.nextInt();
        switch (season){
            case 3:
                System.out.println("春天");
                break;
            case 4:
                System.out.println("春天");
                break;
            case 5:
                System.out.println("春天");
                break;
            case 6:
                System.out.println("夏天");
                break;
            case 7:
                System.out.println("夏天");
                break;
            case 8:
                System.out.println("夏天");
                break;
            case 9:
                System.out.println("秋天");
                break;
            case 10:
                System.out.println("秋天");
                break;
            case 11:
                System.out.println("秋天");
                break;
            case 12:
                System.out.println("冬天");
                break;
            case 1:
                System.out.println("冬天");
                break;
            case 2:
                System.out.println("冬天");
                break;
        }
    }
}
