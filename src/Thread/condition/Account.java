package Thread.condition;
import java.util.concurrent.locks.*;

public class Account
{
	//显示定义Lock对象
	private final Lock lock = new ReentrantLock();
	//获得指定Lock对象对应的条件变量
	private final Condition cond  = lock.newCondition(); 

	private String accountNo;
	private double balance;

	//标识账户中是否已经存款的旗标
	private boolean flag = false;

	public Account(){}

	public Account(String accountNo , double balance)
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
		//加锁
		lock.lock();
		try
		{
			//如果账户中还没有存入存款，该线程等待
			if (!flag)
			{
				cond.await();
			}
			else
			{
				//执行取钱操作
				System.out.println(Thread.currentThread().getName() + 
					" 取钱:" +  drawAmount);
				balance -= drawAmount;
				System.out.println("账户余额为：" + balance);
				//将标识是否成功存入存款的旗标设为false
				flag = false;
				//唤醒该Lock对象对应的其他线程
				cond.signalAll();
			}
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
		//使用finally块来确保释放锁
		finally
		{
			lock.unlock();
		}
	}
	public void deposit(double depositAmount)
	{
		lock.lock();
		try
		{
			//如果账户中已经存入了存款，该线程等待
			if(flag)
			{
				cond.await();				
			}
			else
			{
				//执行存款操作
				System.out.println(Thread.currentThread().getName() + 
					" 存款:" +  depositAmount);
				balance += depositAmount;
				System.out.println("账户余额为：" + balance);
				//将标识是否成功存入存款的旗标设为true
				flag = true;
				//唤醒该Lock对象对应的其他线程
				cond.signalAll();
			}
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
		//使用finally块来确保释放锁
		finally
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
			Account target = (Account)obj;
			return target.getAccountNo().equals(accountNo);
		}
		return false;
	}
}