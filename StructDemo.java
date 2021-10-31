package struct;
public class StructDemo {
    public static void main(String[] args) {
        //寻找某两个数相除，其结果 离黄金分割点 0.618最近
        //
        //分母和分子不能同时为偶数
        //分母和分子 取值范围在[1-20]
        /*1.1到20找两个数，第一个FOR循环
          2.IF语句判断是不是同时为偶数，continue跳出回到kaitou
         */
        //找两个数字

        double breakpoint = 0.618;
        double a = 1;//定义一个中间值存储变量
        int fenzi = 0;
        int fenmu = 0;
        for (int i = 1; i <= 20 ; i++) {
            for (int j = 1; j <= 20 ; j++) {
                //不能同时为偶数
               if(i%2==0 && j%2==0){
                   continue;
               }else {
                   //取值
                   //i j都是整数类型 ,直接除会得0
                   double result = (float)i/j;
                   //两者的差值,绝对值表示
                   double difference = result - breakpoint;
                   difference=Math.abs(difference);
                   //difference=difference<0?0-difference:difference;
                   //比较大小，用中间值存储变量
                   if(a>difference){
                       a=difference;
                       fenzi = i;
                       fenmu = j;
                   }
               }
            }
        }
        System.out.println("离黄金分割点"+breakpoint+"最近的两个数相除是"+fenzi+"/"+fenmu+"="+((double)fenzi/fenmu));
    }
}
