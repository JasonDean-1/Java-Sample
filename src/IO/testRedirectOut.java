package IO;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class testRedirectOut
{
	public static void main(String[] args)
	{
		try
		{
			// ����׼����ı䣬�Ӷ�System.out.println������������console������������ı���
			PrintStream ps = new PrintStream(
			        new FileOutputStream("testRedirectOut.txt"));
			System.setOut(ps);
			System.out.println("String:");
			System.out.println(new testRedirectOut());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
