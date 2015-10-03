package AOP.DynaProxy;

import java.lang.reflect.*;

public class MyProxyFactory
{
	// Ϊָ��target���ɶ�̬�������
	public static Object getProxy(Object target) throws Exception
	{
		// ����һ��MyInvokationHandler����
		MyInvokationHandler handler = new MyInvokationHandler();
		// ΪMyInvokationHandler����target����
		handler.setTarget(target);
		// ������������һ����̬����
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
	}
}
