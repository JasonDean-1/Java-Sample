package Net.CS_HalfClose;

import java.net.*;
import java.io.*;
import java.util.*;

public class Client
{
	public static void main(String[] args) throws IOException
	{
		Socket s = new Socket("localhost", 30000);
		Scanner scan = new Scanner(s.getInputStream());
		if (scan.hasNextLine())
		{
			System.out.println(scan.nextLine());
		}
		PrintStream ps = new PrintStream(s.getOutputStream());
		ps.println("�ͻ��˵ĵ�һ������");
		ps.println("�ͻ��˵ĵڶ�������");
		ps.close();
		scan.close();
		s.close();
	}
}
