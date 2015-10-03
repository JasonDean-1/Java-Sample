package IO;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
public class testNIO_RandomFileChannel
{
	public static void main(String[] args)
	{
		FileChannel randomChannel = null;
		try
		{
			File f = new File("a.txt");
			//创建一个RandomAccessFile对象
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			//获取RandomAccessFile对应的Channel
			randomChannel = raf.getChannel();
			//将Channel中所有数据映射成ByteBuffer
			ByteBuffer buffer = randomChannel.map(FileChannel.MapMode.READ_ONLY,
				0 , f.length());
			//把Channel的记录指针移动到最后
			randomChannel.position(f.length());
			//将buffer中所有数据输出
			randomChannel.write(buffer);
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if (randomChannel != null)
					randomChannel.close();
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
