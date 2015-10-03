package Net.UDP;
import java.awt.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class UdpClient
{
	//���巢�����ݱ���Ŀ�ĵ�
	public static final int DEST_PORT = 30000;
	public static final String DEST_IP = "127.0.0.1";

	//����ÿ�����ݱ�������СΪ4K
	private static final int DATA_LEN = 4096;
	//����ÿͻ���ʹ�õ�DatagramSocket
	private DatagramSocket socket = null;
	//��������������ݵ��ֽ�����
	byte[] inBuff = new byte[DATA_LEN];
	//��ָ���ֽ����鴴��׼���������ݵ�DatagramPacket����
	private DatagramPacket inPacket = 
		new DatagramPacket(inBuff , inBuff.length);
	//����һ�����ڷ��͵�DatagramPacket����
	private DatagramPacket outPacket = null;
	public void init()throws IOException
	{
		try
		{
			//����һ���ͻ���DatagramSocket��ʹ������˿�
			socket = new DatagramSocket();
			//��ʼ�������õ�DatagramSocket��������һ������Ϊ0���ֽ�����
			outPacket = new DatagramPacket(new byte[0] , 0 ,
				InetAddress.getByName(DEST_IP) , DEST_PORT);
			//��������������
			Scanner scan = new Scanner(System.in);
			//���϶�ȡ��������
			while(scan.hasNextLine())
			{
				//�����������һ���ַ���ת���ֽ�����
				byte[] buff = scan.nextLine().getBytes();
				//���÷����õ�DatagramPacket����ֽ�����
				outPacket.setData(buff);
				//�������ݱ�
				socket.send(outPacket);
				//��ȡSocket�е����ݣ����������ݷ���inPacket����װ���ֽ������
				socket.receive(inPacket);
				System.out.println(new String(inBuff , 0 , 
					inPacket.getLength()));
			}
		}
		//ʹ��finally�鱣֤�ر���Դ
		finally
		{
			if (socket != null)
			{
				socket.close();
			}
		}
	}

	public static void main(String[] args) 
		throws IOException
	{
		new UdpClient().init();
	}
}