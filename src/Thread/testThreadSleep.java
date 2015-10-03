package Thread;

import java.util.Date;

public class testThreadSleep
{
	public static void main(String[] args) throws InterruptedException
	{
		for(int i =0;i<10;i++)
		{
			System.out.println("Time: "+ new Date());
			Thread.sleep(1000);
		}
	}
}
