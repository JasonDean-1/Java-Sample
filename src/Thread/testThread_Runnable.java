package Thread;

public class testThread_Runnable implements Runnable
{
	private int i = 0;
	public static void main(String[] args)
	{
		for (int i = 0; i < 100; i++)
		{
			System.out.println(Thread.currentThread().getName() + " " + i);
			if(i==20)
			{
				testThread_Runnable thread = new testThread_Runnable();
				new Thread(thread,"TA").start();
				new Thread(thread,"TB").start();
				
			}
		}
	}

	@Override
	public void run()
	{
		for (; i < 100; i++)
		{
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}
