package decade.bank;
import java.util.Scanner;
public class BankManger {
    String anme;
    String apwd;
    int id;
     Scanner scanner = new Scanner(System.in);
     //定义一个ACCOUNT类的对象数组，有三个,每个数组都包含ID 账号密码 余额四个属性
     Account[] accounts = new Account[3];
    /*登录功能执行,进入之前必须要先登录，登录的身份以管理员登录的身份，并不是个人，相当于银行窗口的工作人员，登录机会只有三次，超过三次则退出程序
    ，成功登陆后显示主菜单
     */
    public void login(){
        System.out.println("欢迎登录系统");
        int count=0;
        //判断账号的用户名跟密码是不是admin管理员
//        for (int i = 0; i < 3 ; i++) {
//            System.out.println("请输入账户");
//            anme = scanner.next();
//            System.out.println("请输入密码");
//            apwd = scanner.next();
//            if("admin".equals(anme)&&"admin".equals(apwd)){
//                menu();
//                break;
//            }else {
//                System.out.println("账号错误");
//            }
//        }
        //方法二
//        do{
//            System.out.println("请输入账户");
//           anme = scanner.next();
//           System.out.println("请输入密码");
//            apwd = scanner.next();
//            if("admin".equals(anme)&&"admin".equals(apwd)){
//                menu();
//                break;
//           }else {
//               System.out.println("登录失败");
//               count++;
//                System.out.println("登录失败还有"+(3-count));
//               if(count==3){
//                   System.out.println("超过三次，登录失败");
//               }
//           }
//        }while (count<3);
//        System.out.println(count);
        for (int i = 0; i <3 ; i++) {
            System.out.println("请输入账户");
            anme = scanner.next();
            System.out.println("请输入密码");
            apwd = scanner.next();
            if("admin".equals(anme)&&"admin".equals(apwd)){
                System.out.println("成功");
                menu();
                //只要判断出账号密码正确就直接跳出这个判断
                break;
            }else {
                count++;
                System.out.println("还有"+(3-count));
                if (count==3){
                    System.out.println("退出");
                }
            }
//            if (count==3){
//                System.out.println("退出");
//            }
        }

    }
    //结束跳出的方法
    public void back(){
        System.out.println("请输入8返回主菜单");
        int x = scanner.nextInt();
        if(x==8){
            menu();
        }

    }
    //展示所有账户的方法
    public void showAllAccountInfo(){
        for (int i = 0; i <accounts.length ; i++) {
            //accounts[i]=new Account();
            if(accounts[i]!=null){
                System.out.println("编号"+(i+1));
                System.out.println("账号"+accounts[i].aneme);
                System.out.println("id"+accounts[i].aid);
                System.out.println("余额"+accounts[i].balance);
                System.out.println();
            }else {
                break;
            }
        }
        back();
    }
    //添加账户的方法
    public void addAccountInfo(){
        int flag = 0;//检测是否有空位，有空位就为1
        System.out.println("请输入ID");
          id  = scanner.nextInt();
          //这部分是为了把下标为0的对象new出来
            for (int i = 0; i < accounts.length; i++) {
                //为了避免一开始空的时候就在比较了
                if(accounts[i]!=null) {
                    if (id == accounts[i].getAid()) {
                        System.out.println("ID重复，不允许添加");
                        back();
                    }
                }
        }
        System.out.println("账户ID合法");
        for (int i = 0; i <accounts.length ; i++) {
            //这里如果判断accounts[i]==null的话，因为一开始赋值ID了，所以不是NULL，没法执行第一个IF判断
            if(accounts[i]==null){
                flag=1;
                System.out.println("请输入账号");//
                //accounts[i]：代表一个对象的位置，需要NEW一下才能给该位置生成一个对象，否则报空指针异常的错误.
                accounts[i] = new Account();
                accounts[i].aneme=scanner.next();
                accounts[i].aid=id;
                System.out.println("请输入密码");
                accounts[i].apwd=scanner.next();
                System.out.println("请输入账户余额");
                accounts[i].balance=scanner.nextInt();
                break;
            }
        }
        System.out.println("flag"+flag);
        if (flag == 0) {
            Account[] newaccounts = new Account[accounts.length+2];//扩容两个的操作
            //把accounts数组的从0开始位置的数据，复制到new数组里的0号位置上开始，长度为account的长度
            System.arraycopy(accounts,0,newaccounts,0,accounts.length);
            for (int i = 0; i <newaccounts.length ; i++) {
                if(newaccounts[i]==null){
                   newaccounts[i] = new Account();
                    System.out.println("请输入账号");
                    newaccounts[i].aneme=scanner.next();
                    newaccounts[i].aid=id;
                    System.out.println("请输入密码");
                    newaccounts[i].apwd=scanner.next();
                    System.out.println("请输入账户余额");
                    newaccounts[i].balance=scanner.nextInt();
                    break;
                }
            }
            accounts = newaccounts;
        }
        back();
    }
     //存钱方法
    public void savemoney(){
        System.out.println("请输入要存钱的账户ID");
        id=scanner.nextInt();
        for (int i = 0; i <accounts.length ; i++) {
            if(id==accounts[i].aid){
                System.out.println("Id合法,存钱操作开始");
                System.out.println("输入你要存的金额");
                int money = scanner.nextInt();
                if(money<0){
                    System.out.println("输入金额不合法");
                    back();
                }else {
                    System.out.println("输入密码");
                    apwd = scanner.next();
                    if(apwd.equals(accounts[i].apwd)){
                        System.out.println("请再次输入密码进行确认");
                        String password =scanner.next();
                        if (password.equals(accounts[i].apwd)){
                            System.out.println("密码确认成功，进行存钱");
                            accounts[i].balance+=money;
                            System.out.println("当前余额"+accounts[i].balance);
                            back();
                        }else {
                            System.out.println("确认密码失败");
                            back();
                        }
                    }else {
                        System.out.println("密码错误");
                        back();
                    }
                }
            }
        }
    }
    //取钱方法
    public void getmoney(){
        System.out.println("请输入账号ID");
        id = scanner.nextInt();
        for (int i = 0; i <accounts[i].aid; i++) {
            if(id==accounts[i].aid){
                System.out.println("输入取钱金额");
                int money = scanner.nextInt();
                //取钱金额小于0或者大于当前账户余额判定不合法
                if(money<0||money>accounts[i].balance){
                    System.out.println("取钱金额不合法");
                    back();
                }else {
                    System.out.println("输入密码");
                    apwd=scanner.next();
                    if(apwd.equals(accounts[i].apwd)){
                        System.out.println("再输入一次密码,确认密码");
                       String password=scanner.next();
                        if(password.equals(accounts[i].apwd)){
                            System.out.println("确认密码成功");
                            accounts[i].balance-=money;
                            System.out.println("账户余额"+accounts[i].balance);
                            back();
                        }else {
                            System.out.println("密码输入错误");
                        }
                    }
                }
            }else {
                System.out.println("账号不存在");
                back();
            }
        }
    }
    //转账
    public void transMoney(){
        System.out.println("请输入本人 账户ID");
        id = scanner.nextInt();
        for (int i = 0; i <accounts.length ; i++) {
            if(accounts[i]!=null) {
                if (id == accounts[i].getAid()) {
                    System.out.println("输入对方账户存在与否");
                    int id2 = scanner.nextInt();
                    for (int j = 0; j < accounts.length; j++) {
                        if(accounts[j]!=null) {
                            if (id2 == accounts[j].getAid()) {
                                System.out.println("输入转账金额");
                                int money = scanner.nextInt();
                                if (money < 0 || money >= accounts[i].getBalance()) {
                                    System.out.println("余额不足");
                                    back();
                                } else {
                                    System.out.println("请输入密码");
                                    apwd = scanner.next();
                                    if (accounts[i].apwd.equals(apwd)) {
                                        System.out.println("再次输入密码确认");
                                        String password = scanner.next();
                                        if (password.equals(accounts[i].apwd)) {
                                            accounts[i].balance -= money;
                                            accounts[j].balance += money;
                                            System.out.println("转出账号ID的余额" + accounts[i].balance);
                                            System.out.println("转入账号ID的余额" + accounts[i].balance);
                                            back();
                                        } else {
                                            System.out.println("密码错误");
                                            back();
                                        }
                                    } else {
                                        System.out.println("密码错误");
                                        back();
                                    }
                                }
                            }
                            } else {
                                System.out.println("对方账号ID不存在");
                                back();
                                break;
                            }

                    }
                } else {
                    System.out.println("本人账号ID错误");
                    back();
                }
            }
        }
    }
    //修改密码
    public void updatePwd(){
        System.out.println("输入要修改密码的账户ID");
         id = scanner.nextInt();
        for (int i = 0; i <accounts.length ; i++) {
            if(id==accounts[i].aid){
                System.out.println("请输入原密码");
                apwd = scanner.next();
                if(apwd.equals(accounts[i].apwd)){
                    System.out.println("再次输入密码确定");
                    String password = scanner.next();
                    if(password.equals(accounts[i].apwd)){
                        System.out.println("修改密码");
                        String newpassword = scanner.next();
                       if(newpassword.equals(accounts[i].apwd)){
                           System.out.println("密码跟原密码相同");
                       }else {
                               System.out.println("输入新密码确认");
                               String newpassword1 = scanner.next();
                               if(newpassword1!=newpassword){
                                   System.out.println("再次输入确认新密码");
                               }else {
                                   System.out.println("两次密码一致，修改密码成功");
                                   accounts[i].apwd = newpassword1;
                                   back();
                               }
                       }
                    }else {
                        System.out.println("确认密码输入错误");
                        back();
                    }
                }else {
                    System.out.println("密码输入错误");
                    back();
                }
            }else {
                System.out.println("账号不存在");
                back();
            }
        }
    }
    //销户
    public void deletePwd(){
        System.out.println("输入账户ID");
        id = scanner.nextInt();
        for (int i = 0; i <accounts.length ; i++) {
            if(accounts[i]!=null) {
                if (id == accounts[i].getAid()) {
                    System.out.println("输入密码");
                    apwd = scanner.next();
                    if (apwd.equals(accounts[i].apwd)) {
                        System.out.println("登录成功");
                        //建立一个新的空数组
                        Account[] newaccounts = new Account[accounts.length - 1];
                        for (int j = id; j < accounts.length; j++) {
                            accounts[j - 1] = accounts[j];
                        }
                        for (int j = 0; j < newaccounts.length; j++) {
                            newaccounts[j] = new Account();
                            newaccounts[j] = accounts[j];
                        }
                        System.out.println("删除成功");
                        back();
                    } else {
                        System.out.println("密码输入错误");
                        back();
                    }
                } else {
                    System.out.println("账号ID不存在");
                    back();
                }
            }
        }
    }
    //菜单方法
    public void menu(){
        System.out.println("====================================");
        System.out.println("0、显示所有账户");
        // 方法名: showAllAccountInfo();
        System.out.println("1、添加账户");
        //方法名：addAccountInfo();
        System.out.println("2、存钱");
        //方法名：saveAccountMoney();
        System.out.println("3、取钱");
        // 方法名：getMoney();
        System.out.println("4、转账");
        //方法名：transMoney();
        System.out.println("5、修改密码");
        // 方法名：updatePwd();
        System.out.println("6、销户");
        //方法名：deletePwd();
        System.out.println("====================================");
        System.out.println("请选择：");
        int choice = scanner.nextInt();
        switch (choice) {
            case 0:
                showAllAccountInfo();
                break;
            case 1:
                addAccountInfo();
                break;
            case 2:
                savemoney();
                break;
            case 3:
                getmoney();
                break;
            case 4:
                transMoney();
                break;
            case 5:
                updatePwd();
                break;
            case 6:
                deletePwd();
                break;
            default:
                System.out.println("违法输入");
                break;
        }
    }
}
