package Thread;

public class testThread extends Thread
{
	private int i =0;
	public void run()
	{
		for(;i<100;i++)
		{
			System.out.println(getName()+" "+i);
		}
	}
	public static void  main(String[] args)
	{
		for(int i=0;i<100;i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i==20)
			{
				new testThread().setName("T-A");
				new testThread().setName("T-B");
				/*
				Thread ta =new testThread();
				Thread tb =new testThread();
				ta.setName("T-A");
				tb.setName("T-B");
				ta.start();
				tb.start();
				*/
			}
		}
	}
}
