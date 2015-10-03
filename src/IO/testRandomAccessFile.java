package IO;

import java.io.IOException;
import java.io.RandomAccessFile;

public class testRandomAccessFile
{
	public static void main(String[] args) throws IOException
	{
		try
		{
			RandomAccessFile raf = new RandomAccessFile(
			        "./src/IO/testRandomAccessFile.java", "r");
			System.out.println("Pointer location: " + raf.getFilePointer());
			raf.seek(300);
			byte[] bbuf = new byte[1024];
			int hasRead = 0;
			while ((hasRead = raf.read(bbuf)) > 0)
			{
				System.out.print(new String(bbuf, 0, hasRead));
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
