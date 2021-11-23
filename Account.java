package decade.bank;

public class Account {
    String aneme;//账户名
    int balance;//账户余额
    String apwd;//账户密码
    int aid;//账户ID，不允许重复

    public String getAneme() {
        return aneme;
    }

    public void setAneme(String aneme) {
        this.aneme = aneme;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getApwd() {
        return apwd;
    }

    public void setApwd(String apwd) {
        this.apwd = apwd;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }
}
