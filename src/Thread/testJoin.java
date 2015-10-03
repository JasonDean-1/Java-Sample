package Thread;

public class testJoin extends Thread
{
	public testJoin(String name)
	{
		super(name);
	}
	public void run()
	{
		for (int i = 0; i < 100; i++)
		{
			System.out.println(getName() + " " + i);
		}
	}
	public static void main(String[] args) throws InterruptedException
	{
		new testJoin("T").start();
		for (int i = 0; i < 100; i++)
		{
			if(i ==50)
			{
			testJoin thread = new testJoin("Thread was Joined");
			thread.start();
			thread.join();
			}
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}
