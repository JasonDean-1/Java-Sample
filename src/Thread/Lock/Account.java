package Thread.Lock;
import java.util.concurrent.locks.*;

public class Account
{
	// 定义锁对象
	private final ReentrantLock lock = new ReentrantLock();
	private String accountNo;
	private double balance;

	public Account()
	{
	}

	public Account(String accountNo, double balance)
	{
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public void setAccountNo(String accountNo)
	{
		this.accountNo = accountNo;
	}
	public String getAccountNo()
	{
		return this.accountNo;
	}

	public double getBalance()
	{
		return this.balance;
	}
	public void draw(double drawAmount)
	{
		lock.lock();
		try
		{
			// 账户余额大于取钱数目
			if (balance >= drawAmount)
			{
				// 吐出钞票
				System.out.println(Thread.currentThread().getName()
				        + "取钱成功！吐出钞票:" + drawAmount);
				try
				{
					Thread.sleep(1);
				} catch (InterruptedException ex)
				{
					ex.printStackTrace();
				}
				// 修改余额
				balance -= drawAmount;
				System.out.println("\t余额为: " + balance);
			} else
			{
				System.out.println(
				        Thread.currentThread().getName() + "取钱失败！余额不足！");
			}
		} finally
		{
			lock.unlock();
		}
	}

	public int hashCode()
	{
		return accountNo.hashCode();
	}
	public boolean equals(Object obj)
	{
		if (obj != null && obj.getClass() == Account.class)
		{
			Account target = (Account) obj;
			return target.getAccountNo().equals(accountNo);
		}
		return false;
	}
}