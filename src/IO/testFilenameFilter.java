package IO;

import java.io.File;

public class testFilenameFilter
{
	public static void main(String[] args)
	{
		File file =new File(".");
		String[] nameList= file.list((dir,name)->name.endsWith(".java")||new File(name).isDirectory());
		for(String name : nameList)
		{
			System.out.println(name);
		}
	}
}
