package IO;

import java.nio.charset.Charset;
import java.util.*;
public class testNIO_Charset
{
	public static void main(String[] args) 
	{
		//获取全部字符集
		SortedMap<String,Charset>  map = Charset.availableCharsets();
		for (String alias : map.keySet())
		{
			//输出字符集的别名和对应的Charset对象
			System.out.println(alias + "----->" 
				+ map.get(alias));
		}
	}
}