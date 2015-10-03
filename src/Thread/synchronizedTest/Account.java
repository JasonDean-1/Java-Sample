package Thread.synchronizedTest;

public class Account
{
	private String accountNo;
	private double balance;
	//��ʶ�˻����Ƿ����д������
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
	public synchronized void draw(double drawAmount)
	{
		try
		{
			//���flagΪ�٣������˻��л�û���˴�Ǯ��ȥ����ȡǮ��������
			if (!flag)
			{
				wait();
			}
			else
			{
				//ִ��ȡǮ
				System.out.println(Thread.currentThread().getName() + 
					" ȡǮ:" +  drawAmount);
				balance -= drawAmount;
				System.out.println("�˻����Ϊ��" + balance);
				//����ʶ�˻��Ƿ����д��������Ϊfalse��
				flag = false;
				//���������߳�
				notifyAll();
			}
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
	}
	public synchronized void deposit(double depositAmount)
	{
		try
		{
			//���flagΪ�棬�����˻��������˴�Ǯ��ȥ�����Ǯ��������
			if (flag)
			{
				wait();
			}
			else
			{
				//ִ�д��
				System.out.println(Thread.currentThread().getName() + 
					" ���:" +  depositAmount);
				balance += depositAmount;
				System.out.println("�˻����Ϊ��" + balance);
				//����ʾ�˻��Ƿ����д��������Ϊtrue
				flag = true;
				//���������߳�
				notifyAll();
			}
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
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