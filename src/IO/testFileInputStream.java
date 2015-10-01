package IO;

import java.io.FileInputStream;
import java.io.IOException;

public class testFileInputStream
{
	public static void main(String[] args) throws IOException
	{
		FileInputStream fileInputStream = new FileInputStream("./src/IO/testFileInputStream.java");
		byte[] byteBuffer = new byte[1024];
		int hasRead= 0;
		while((hasRead = fileInputStream.read(byteBuffer))>0)
		{
			System.out.println(new String(byteBuffer,0,hasRead));
		}
		fileInputStream.close();
	}
}
