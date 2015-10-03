package Net.SimpleCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class testClient
{
	public static void main(String[] args) throws IOException
	{
		/*
		Socket socket = new Socket("127.0.0.1", 30000);
		socket.setSoTimeout(10000);
		*/		
		Socket socket = new Socket("127.0.0.1" , 30000);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line = br.readLine();
		System.out.println(line);
		br.close();
		socket.close();
	}
}
