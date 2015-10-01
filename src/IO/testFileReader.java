package IO;

import java.io.FileReader;

public class testFileReader
{
	public static void main(String[] args)
	{
		try
		{
			FileReader fileReader = new FileReader("./src/IO/testFileReader.java");
			char[] charBuffer = new char[32];
			int hasRead= 0;
			while((hasRead = fileReader.read(charBuffer))>0)
			{
				System.out.print(new String(charBuffer,0,hasRead));
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
