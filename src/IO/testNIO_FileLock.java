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
			//ʹ��FileOutputStream��ȡFileChannel
			channel = new FileOutputStream("a.txt")
				.getChannel();
			//ʹ�÷�����ʽ��ʽ��ָ���ļ�����
			FileLock lock = channel.tryLock();
			//������ͣ5s
			Thread.sleep(5000);
			//�ͷ���
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
