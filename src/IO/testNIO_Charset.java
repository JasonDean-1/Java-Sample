package IO;

import java.nio.charset.Charset;
import java.util.*;
public class testNIO_Charset
{
	public static void main(String[] args) 
	{
		//��ȡȫ���ַ���
		SortedMap<String,Charset>  map = Charset.availableCharsets();
		for (String alias : map.keySet())
		{
			//����ַ����ı����Ͷ�Ӧ��Charset����
			System.out.println(alias + "----->" 
				+ map.get(alias));
		}
	}
}