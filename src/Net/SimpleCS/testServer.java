package Net.SimpleCS;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class testServer
{
	public static void main(String[] args)throws IOException
	{
		ServerSocket ss = new ServerSocket(30000);
		while(true)
		{
			Socket s=  ss.accept();
			PrintStream ps = new PrintStream(s.getOutputStream());
			ps.println("The server has sent u a meg");
			ps.close();
			s.close();
		}
	}
}
