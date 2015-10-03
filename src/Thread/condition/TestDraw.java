package Thread.condition;
public class TestDraw
{
	public static void main(String[] args)
	{
		// 创建一个账户
		Account acct = new Account("1234567", 0);
		new DrawThread("取钱者", acct, 800).start();
		new DepositThread("存钱者甲", acct, 800).start();
		new DepositThread("存钱者乙", acct, 800).start();
		new DepositThread("存钱者丙", acct, 800).start();
	}
}
