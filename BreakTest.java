package struct;

public class BreakTest {
    public static void main(String[] args) {
        //1.第一个循环。需要累加每年的金额
        //2。第二个循环。用来计算当年的复利率
        int benjin = 12000;
        float rate = 0.20f;
        int sum = 0 ;
        int account = 0;
        int year = 0;
        //放在这里利率会一直全局改变,所以需要放在下方的 for循环里去改变
        //double compoundInterestRate = 1;
        //人寿命按照100年算，算每年的累计总额
        for (int i = 1; i < 100 ; i++) {
            double compoundInterestRate = 1;
            //计算当年的金额
            year = i;
            //第二个for循环用来当前year年份的12000复利收入  第一年12000*1.2 第二年12000*1.2*1.2
            for (int j = 1; j <=year ; j++) {
                //下列代码放在下面就已经被写死了，会报错
                //double compoundInterestRate = 1;
                //表示出当年的本金率
                compoundInterestRate = compoundInterestRate*1.2;
            }
            //用本金率表示出当前年份12000的复利收入
            account = (int) (benjin*compoundInterestRate);
            sum= (sum+account);
            System.out.println("第"+year+"年"+"总收入为"+sum);
            if(sum>=1000000){
                System.out.println("一共需要"+year+"年完成100W目标");
                break;
            }
        }
    }
}
