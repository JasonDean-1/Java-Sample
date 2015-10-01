package IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class testPrintStream
{
	public static void main(String[] args) throws IOException
	{
		try
		{
			FileOutputStream fos = new FileOutputStream("./src/IO/test.txt");
			PrintStream ps  = new PrintStream(fos);
			ps.println("test!!!!!!!");
			ps.println(new testPrintStream());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
