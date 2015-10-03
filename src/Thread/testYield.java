package Thread;

public class testYield extends Thread
{
	public testYield(String name)
	{
		super(name);
	}
	public void run()
	{
		for(int i =0;i<50;i++)
		{
			System.out.println(getName()+" "+i);
			if(i==20)
			{
				Thread.yield();
			}
		}
	}
	public static void main(String [] args)
	{
		testYield yield = new testYield("YieldThread:");
		yield.setPriority(Thread.MIN_PRIORITY);
		yield.start();
		testYield yield2 = new testYield("YieldThread2:");
		yield2.setPriority(Thread.MAX_PRIORITY);
		yield2.start();
		
	}
}
