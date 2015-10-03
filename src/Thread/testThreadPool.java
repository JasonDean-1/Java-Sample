package Thread;

import java.util.concurrent.*;

class testPoolThread implements Runnable
{
	public void run()
	{
		for (int i = 0; i < 100 ; i++ )
		{
			System.out.println(Thread.currentThread().getName()
				+ "��iֵΪ:" + i);
		}
	}
}

public class testThreadPool
{
	public static void main(String[] args) 
	{
		//����һ�����й̶��߳�����6�����̳߳�
		ExecutorService pool = Executors.newFixedThreadPool(6);
		//���̳߳����ύ2���߳�
		pool.submit(new testPoolThread());
		pool.submit(new testPoolThread());
		pool.submit(new testPoolThread());
		//�ر��̳߳�
		pool.shutdown();
	}
}
