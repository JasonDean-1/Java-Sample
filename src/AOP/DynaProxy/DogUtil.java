package AOP.DynaProxy;

public class DogUtil
{
	// 第一个拦截器方法
	public void method1()
	{
		System.out.println("=====模拟第一个通用方法=====");
	}

	// 第二个拦截器方法
	public void method2()
	{
		System.out.println("=====模拟通用方法二=====");
	}
}
