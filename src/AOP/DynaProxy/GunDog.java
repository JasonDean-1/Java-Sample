package AOP.DynaProxy;

public class GunDog implements Dog
{
	// info����ʵ�֣�������ӡһ���ַ���
	public void info()
	{
		System.out.println("����һֻ�Թ�");
	}

	// run����ʵ�֣�������ӡһ���ַ���
	public void run()
	{
		System.out.println("�ұ���Ѹ��");
	}
}
