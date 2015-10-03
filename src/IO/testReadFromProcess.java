package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class testReadFromProcess
{
	public static void main(String[] args) throws IOException
	{
		Process p = Runtime.getRuntime().exec("javac");
		try
		{
			BufferedReader br = new BufferedReader(
			        new InputStreamReader(p.getErrorStream()));
			String buffer = null;
			while ((buffer = br.readLine()) != null)
			{
				System.out.println(buffer);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
