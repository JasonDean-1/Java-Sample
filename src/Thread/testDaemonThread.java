package Thread;

public class testDaemonThread extends Thread
{
	public void run()
	{
		for (int i = 0; i < 1000; i++)
		{
			System.out.println(getName() + " " + i);
		}
	}
	public static void main(String[] args) throws InterruptedException
	{
		testDaemonThread thread = new testDaemonThread();
		thread.setDaemon(true);
		thread.start();
		for (int i = 0; i < 10; i++)
		{
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
		Thread.sleep(10);
	}
}
