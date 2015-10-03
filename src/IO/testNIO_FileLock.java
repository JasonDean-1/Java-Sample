package IO;
import java.nio.*;
import java.nio.channels.*;

import java.io.*;
public class testNIO_FileLock
{
	public static void main(String[] args) 
	{
		FileChannel channel = null;
		try
		{
			//使用FileOutputStream获取FileChannel
			channel = new FileOutputStream("a.txt")
				.getChannel();
			//使用非阻塞式方式对指定文件加锁
			FileLock lock = channel.tryLock();
			//程序暂停5s
			Thread.sleep(5000);
			//释放锁
			lock.release();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if (channel != null)
					channel.close();
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
