package Thread.Lock;
public class DrawThread extends Thread
{
	// 模拟用户账户
	private Account account;
	// 当前取钱线程所希望取的钱数
	private double drawAmount;

	public DrawThread(String name, Account account, double drawAmount)
	{
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}

	// 当多条线程修改同一个共享数据时，将涉及到数据安全问题。
	public void run()
	{
		account.draw(drawAmount);
	}
}