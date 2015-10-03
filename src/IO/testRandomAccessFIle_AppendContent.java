package IO;

import java.io.RandomAccessFile;

public class testRandomAccessFIle_AppendContent
{
	public static void main(String[] args)
	{
		try
		{
			RandomAccessFile raf = new RandomAccessFile("./src/IO/out.txt",
			        "rw");
			raf.seek(raf.length());
			raf.write("Append content: 111111111\r\n".getBytes());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
