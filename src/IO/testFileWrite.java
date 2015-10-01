package IO;

import java.io.FileWriter;
import java.io.IOException;

public class testFileWrite
{
	public static void main(String[] args) throws IOException
	{
		FileWriter fileWrite = null;
		try
		{
			fileWrite = new FileWriter("./src/IO/poem.txt");
			fileWrite.write("1111111111\r\n");
			fileWrite.write("2222222222\r\n");
			fileWrite.write("3333333333\r\n");
			fileWrite.write("4444444444\r\n");
			System.out.println("success");
		} 
		catch (IOException IoE)
		{
			IoE.printStackTrace();
		}
		finally {
			if(fileWrite!=null)
			{
				fileWrite.close();
			}
		}
	}
}
