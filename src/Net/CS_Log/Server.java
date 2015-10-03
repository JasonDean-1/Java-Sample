package Net.CS_Log;

import java.net.*;
import java.io.*;
import java.util.*;

public class Server
{
	private static final int SERVER_PORT = 30000;
	// ʹ��MyMap����������ÿ���ͻ����ֺͶ�Ӧ�����֮��Ķ�Ӧ��ϵ��
	public static customMap<String, PrintStream> clients = new customMap<String, PrintStream>();

	public void init()
	{
		ServerSocket ss = null;
		try
		{
			// ����������ServerSocket
			ss = new ServerSocket(SERVER_PORT);
			// ������ѭ�������Ͻ������Կͻ��˵�����
			while (true)
			{
				Socket socket = ss.accept();
				new ServerThread(socket).start();
			}
		}
		// ����׳��쳣
		catch (IOException ex)
		{
			System.out.println("����������ʧ�ܣ��Ƿ�˿�" + SERVER_PORT + "�ѱ�ռ�ã�");
		}
		// ʹ��finally�����ر���Դ
		finally
		{
			try
			{
				if (ss != null)
				{
					ss.close();
				}
			} catch (IOException ex)
			{
				ex.printStackTrace();
			}
			System.exit(1);
		}
	}

	public static void main(String[] args)
	{
		Server server = new Server();
		server.init();
	}
}