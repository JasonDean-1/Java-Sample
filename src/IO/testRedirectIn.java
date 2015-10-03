package IO;

import java.io.FileInputStream;
import java.util.Scanner;

public class testRedirectIn
{
	public static void main(String[] args)
	{
		try
		{
			FileInputStream fis = new FileInputStream("./src/IO/testRedirectIn.java");
			System.setIn(fis);
			Scanner scanner = new Scanner(System.in);
			scanner.useDelimiter("\n");
			while (scanner.hasNext())
			{
				System.out.println(scanner.next());
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
