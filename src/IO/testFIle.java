package IO;

import java.io.File;
import java.io.IOException;

public class testFIle
{
	public static void main(String []args)throws IOException
	{
		File file =new File(".");
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getAbsoluteFile());
		System.out.println(file.getAbsoluteFile().getParent());
		
		File tempFile = File.createTempFile("test", ".txt", file);
		tempFile.deleteOnExit();
		File newFile = new File(System.currentTimeMillis()+"");
		System.out.println("file is existed:"+newFile.exists());
		newFile.createNewFile();
		newFile.mkdir();
		String[] fileList = file.list();
		System.out.println("---------------Local File List-------------");
		for(String fileName :fileList)
		{
			System.out.println(fileName);
		}
		File[] roots = File.listRoots();
		System.out.println("--------------Sys Path-----------------");
		for(File root:roots)
		{
			System.out.println(root);
		}
	}
}
