package IO;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class testRedirectOut
{
	public static void main(String[] args)
	{
		try
		{
			// 将标准输出改变，从而System.out.println结果不在输出到console，而是输出到文本中
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
