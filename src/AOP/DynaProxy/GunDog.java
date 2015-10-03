package AOP.DynaProxy;

public class GunDog implements Dog
{
	// info方法实现，仅仅打印一个字符串
	public void info()
	{
		System.out.println("我是一只猎狗");
	}

	// run方法实现，仅仅打印一个字符串
	public void run()
	{
		System.out.println("我奔跑迅速");
	}
}
