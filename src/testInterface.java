interface interface1
{
	int if1 = 5;
	void test1();
}
interface interface2
{
	int if2 = 10;
	void test2();
}
interface interface3 extends interface1, interface2
{
	int if3 = 15;
	void test3();
}
class test implements interface1, interface2, interface3
{
	test()
	{
		System.out.println("test");
	}
	public void test3()
	{
		System.out.println("test3");
	}

	public void test2()
	{
		System.out.println("test2");
	}
	public void test1()
	{
		System.out.println("test1");
	}
}
public class testInterface
{
	public static void main(String[] args)
	{
		System.out.println(interface1.if1);
		System.out.println(interface2.if2);
		System.out.println(interface3.if3);
		test t = new test();
		t.test1();
		t.test2();
		t.test3();
	}
}
