package IO;

import java.io.StringReader;
import java.io.StringWriter;

public class testStringNode
{
	public static void main(String[] args)
	{
		String str = "111\n" + "222\n" + "333\n" + "444\n" + "555\n" + "666\n";
		char[] buffer = new char[32];
		int hasRead = 0;
		try
		{
			StringReader strReader = new StringReader(str);
			while ((hasRead = strReader.read(buffer)) > 0)
			{
				System.out.print(new String(buffer, 0, hasRead));
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		try
		{
			StringWriter strWriter = new StringWriter();
			strWriter.write("aaa");
			strWriter.write("bbb");
			strWriter.write("ccc");
			strWriter.write("ddd");
			System.out.println("--------content in strWriter---------");
			System.out.println(strWriter.toString());

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
