package Net.CS_Log;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerThread extends Thread
{
	private Socket socket;
	BufferedReader br = null;
	PrintStream ps = null;

	// ����һ�������������ڽ���һ��Socket������ServerThread�߳�
	public ServerThread(Socket socket)
	{
		this.socket = socket;
	}

	public void run()
	{
		try
		{
			// ��ȡ��Socket��Ӧ��������
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// ��ȡ��Socket��Ӧ�������
			ps = new PrintStream(socket.getOutputStream());
			String line = null;
			while ((line = br.readLine()) != null)
			{
				// �������������MyProtocol.USER_ROUND��ʼ�������������
				// ����ȷ�����������û���½���û���
				if (line.startsWith(customProtocol.USER_ROUND) && line.endsWith(customProtocol.USER_ROUND))
				{
					// �õ���ʵ��Ϣ
					String userName = getRealMsg(line);
					// ����û����ظ�
					if (Server.clients.containsKey(userName))
					{
						System.out.println("�ظ�");
						ps.println(customProtocol.NAME_REP);
					} else
					{
						System.out.println("�ɹ�");
						ps.println(customProtocol.LOGIN_SUCCESS);
						Server.clients.put(userName, ps);
					}
				}
				// �������������YeekuProtocol.PRIVATE_ROUND��ʼ�������������
				// ����ȷ����˽����Ϣ��˽����Ϣֻ���ض������������
				else if (line.startsWith(customProtocol.PRIVATE_ROUND) && line.endsWith(customProtocol.PRIVATE_ROUND))
				{
					// �õ���ʵ��Ϣ
					String userAndMsg = getRealMsg(line);
					// ��SPLIT_SIGN���ָ��ַ�����ǰ�沿����˽���û������沿����������Ϣ
					String user = userAndMsg.split(customProtocol.SPLIT_SIGN)[0];
					String msg = userAndMsg.split(customProtocol.SPLIT_SIGN)[1];
					// ��ȡ˽���û���Ӧ���������������˽����Ϣ
					Server.clients.get(user).println(Server.clients.getKeyByValue(ps) + "���ĵض���˵��" + msg);
				}
				// ����Ҫ��ÿ��Socket����
				else
				{
					// �õ���ʵ��Ϣ
					String msg = getRealMsg(line);
					// ����clients�е�ÿ�������
					for (PrintStream clientPs : Server.clients.valueSet())
					{
						clientPs.println(Server.clients.getKeyByValue(ps) + "˵��" + msg);
					}
				}
			}
		}
		// ��׽���쳣�󣬱�����Socket��Ӧ�Ŀͻ����Ѿ�����������
		// ���Գ������Ӧ���������Map��ɾ��
		catch (IOException e)
		{
			Server.clients.removeByValue(ps);
			System.out.println(Server.clients.size());
			// �ر����硢IO��Դ
			try
			{
				if (br != null)
				{
					br.close();
				}
				if (ps != null)
				{
					ps.close();
				}
				if (socket != null)
				{
					socket.close();
				}
			} catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}

	// ������������ȥ��ǰ���Э���ַ����ָ�����ʵ����
	public String getRealMsg(String line)
	{
		return line.substring(customProtocol.PROTOCOL_LEN, line.length() - customProtocol.PROTOCOL_LEN);
	}
}
