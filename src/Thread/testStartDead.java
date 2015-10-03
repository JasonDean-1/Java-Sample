package Thread;

public class testStartDead extends Thread
{
	private int i;
	public void run()
	{
		for (; i < 100; i++)
		{
			System.out.println(getName() + " " + i);
		}
	}
	public static void main(String[] args)
	{
		testStartDead thread = new testStartDead();
		for (int i = 0; i < 100; i++)
		{
			System.out.println(Thread.currentThread().getName()+ " " + i);
			if(i==20)
			{
				thread.start();
				System.out.println(thread.isAlive());
			}
			if(i>20&&!thread.isAlive())
			{
				thread.start();  //Exception 
			}
		}
	}
}
