package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class testThread_Callable
{
	public static void main(String[] args)
	{
		testThread_Callable thread = new testThread_Callable();
		FutureTask<Integer> task = new FutureTask<Integer>(
		        (Callable<Integer>) () ->
		        {
			        int i = 0;
			        for (; i < 100; i++)
			        {
				        System.out.println(
		                        Thread.currentThread().getName() + " i: " + i);
			        }
			        return i;
		        });
		for (int i = 0; i < 100; i++)
		{
			System.out.println(Thread.currentThread().getName() + " i: " + i);
			if (i == 20)
			{
				new Thread(task, "Thread Callable: ").start();
			}
		}
		try
		{
			System.out.println("child Thread Get i =:" + task.get());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
