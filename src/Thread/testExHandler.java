package Thread;

import java.lang.Thread.UncaughtExceptionHandler;

class ExHandler implements Thread.UncaughtExceptionHandler 
{
	//ʵ��uncaughtException�������÷����������̵߳�δ�����쳣
	public void uncaughtException(Thread t, Throwable e)
	{
		System.out.println(t + " �̳߳������쳣��" + e);
	} 
}
public class testExHandler
{
	public static void main(String[] args) 
	{
		//�������̵߳��쳣������
		Thread.currentThread().setUncaughtExceptionHandler(
			(UncaughtExceptionHandler) new ExHandler());
		int a = 5 / 0;
	}
}