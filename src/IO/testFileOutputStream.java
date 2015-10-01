package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class testFileOutputStream
{

	public static void main(String[] args)
	{
		try
		{
			FileInputStream fileInputStream = new FileInputStream("./src/IO/testFileOutputStream.java");
			FileOutputStream fileOutputStream = new FileOutputStream("./src/IO/testOutput.txt");
			byte[] byteBuffer = new byte[32];
			int hasRead=0;
			while((hasRead=fileInputStream.read(byteBuffer))>0)
			{
				fileOutputStream.write(byteBuffer,0,hasRead);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
