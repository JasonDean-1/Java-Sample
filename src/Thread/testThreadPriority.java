package Thread;

public class testThreadPriority extends Thread
{
	public testThreadPriority(String name)
	{
		super(name);
	}
	public void run()
	{
		for (int i = 0; i < 50; i++)
		{
			System.out.println(
			        getName() + " priority is: " + getPriority() + " i = " + i);
		}
	}
	public static void main(String [] args)
	{
		Thread.currentThread().setPriority(6);
		for(int i =0;i<30;i++)
		{
			if(i==10)
			{
				testThreadPriority lowPriority = new testThreadPriority("lowPriority");
				lowPriority.start();
				System.out.println("Init Priority: "+lowPriority.getPriority());
				lowPriority.setPriority(Thread.MIN_PRIORITY);
			}
			if(i==20)
			{
				testThreadPriority highPriority = new testThreadPriority("highPriority");
				highPriority.start();
				System.out.println("Init Priority: "+highPriority.getPriority());
				highPriority.setPriority(Thread.MIN_PRIORITY);
			}
		}
	}
}
