package Thread;

import java.lang.Thread.UncaughtExceptionHandler;

class ExHandler implements Thread.UncaughtExceptionHandler 
{
	//实现uncaughtException方法，该方法将处理线程的未处理异常
	public void uncaughtException(Thread t, Throwable e)
	{
		System.out.println(t + " 线程出现了异常：" + e);
	} 
}
public class testExHandler
{
	public static void main(String[] args) 
	{
		//设置主线程的异常处理器
		Thread.currentThread().setUncaughtExceptionHandler(
			(UncaughtExceptionHandler) new ExHandler());
		int a = 5 / 0;
	}
}