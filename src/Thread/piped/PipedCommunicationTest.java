package Thread.piped;
import java.io.*;

class ReaderThread extends Thread
{
	private PipedReader pr;
	// 用于包装管道流的BufferReader对象
	private BufferedReader br;
	public ReaderThread()
	{
	}
	public ReaderThread(PipedReader pr)
	{
		this.pr = pr;
		this.br = new BufferedReader(pr);
	}
	public void run()
	{
		String buf = null;
		try
		{
			// 逐行读取管道输入流中的内容
			while ((buf = br.readLine()) != null)
			{
				System.out.println(buf);
			}
		} catch (IOException ex)
		{
			ex.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally
		{
			try
			{
				if (br != null)
				{
					br.close();
				}
			} catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
class WriterThread extends Thread
{
	String[] books = new String[]{"Struts2权威指南", "ROR敏捷开发指南", "基于J2EE的Ajax宝典",
	        "轻量级J2EE企业应用指南"};
	private PipedWriter pw;
	public WriterThread()
	{
	}
	public WriterThread(PipedWriter pw)
	{
		this.pw = pw;
	}
	public void run()
	{
		try
		{
			// 循环100次，向管道输出流中写入100个字符串
			for (int i = 0; i < 100; i++)
			{
				pw.write(books[i % 4] + "\n");
			}
		} catch (IOException ex)
		{
			ex.printStackTrace();
		}
		// 使用finally块来关闭管道输出流
		finally
		{
			try
			{
				if (pw != null)
				{
					pw.close();
				}
			} catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}

public class PipedCommunicationTest
{
	public static void main(String[] args)
	{
		PipedWriter pw = null;
		PipedReader pr = null;
		try
		{
			// 分别创建两个独立的管道输出流、输入流
			pw = new PipedWriter();
			pr = new PipedReader();
			// 连接管道输出流、出入流
			pw.connect(pr);

			// 将连接好的管道流分别传入2个线程，
			// 就可以让两个线程通过管道流进行通信
			new WriterThread(pw).start();
			new ReaderThread(pr).start();
		} catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
}
