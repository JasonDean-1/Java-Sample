package IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class testKeyin
{
	public static void main(String[] args)
	{
		try
		{
			InputStreamReader reader = new InputStreamReader(System.in);
			BufferedReader bufferReader = new BufferedReader(reader);
			String line = null;
			while ((line = bufferReader.readLine()) != null)
			{
				if (line.equals("exit"))
				{
					System.exit(0);
				}
				System.out.println("Tap in :" + line);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
