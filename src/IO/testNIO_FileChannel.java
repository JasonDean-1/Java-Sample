package IO;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class testNIO_FileChannel
{

	public static void main(String[] args)
	{
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		try
		{
			File f = new File("./src/IO/testNIO_FileChannel.java");
			//创建FileInputStream，以该文件输入流创建FileChannel
			inChannel = new FileInputStream(f)
				.getChannel();
			//将FileChannel里的全部数据映射成ByteBuffer
			MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY,
				0 , f.length());
			//使用GBK的字符集来创建解码器
			Charset charset = Charset.forName("GBK");
			//以文件输出流创建FileBuffer，用以控制输出
			outChannel = new FileOutputStream("a.txt")
				.getChannel();
			//直接将buffer里的数据全部输出
			outChannel.write(buffer);
			//再次调用buffer的clear()方法，复原limit、position的位置
			buffer.clear();
			//创建解码器(CharsetDecoder)对象
			CharsetDecoder decoder = charset.newDecoder();
			//使用解码器将ByteBuffer转换成CharBuffer
			CharBuffer charBuffer =  decoder.decode(buffer);
			//CharBuffer的toString方法可以获取对应的字符串
			System.out.println(charBuffer);
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if (inChannel != null)
					inChannel.close();
				if (outChannel != null)
					outChannel.close();	
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}