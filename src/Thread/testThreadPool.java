package Thread;

import java.util.concurrent.*;

class testPoolThread implements Runnable
{
	public void run()
	{
		for (int i = 0; i < 100 ; i++ )
		{
			System.out.println(Thread.currentThread().getName()
				+ "的i值为:" + i);
		}
	}
}

public class testThreadPool
{
	public static void main(String[] args) 
	{
		//创建一个具有固定线程数（6）的线程池
		ExecutorService pool = Executors.newFixedThreadPool(6);
		//向线程池中提交2个线程
		pool.submit(new testPoolThread());
		pool.submit(new testPoolThread());
		pool.submit(new testPoolThread());
		//关闭线程池
		pool.shutdown();
	}
}
