package IO;

import java.io.FileReader;
import java.io.PushbackReader;

public class testPushback
{
	public static void main(String[] args)
	{
		try
		{
			PushbackReader pbReader = new PushbackReader(
			        new FileReader("./src/IO/testPushback.java"), 64);
			char[] buffer = new char[32];
			String lastContent = "";
			int hasRead = 0;
			while ((hasRead = pbReader.read(buffer)) > 0)
			{
				String content = new String(buffer, 0, hasRead);
				int targetIndex = 0;
				if ((targetIndex = (lastContent + content)
				        .indexOf("new PushbackReader")) > 0)
				{
					pbReader.unread((lastContent+content).toCharArray());
					if(targetIndex>32)
					{
						buffer=new char[targetIndex];
					}
					pbReader.read(buffer,0,targetIndex);
					System.out.println(new String(buffer,0,targetIndex));
					System.exit(0);
				}
				else
				{
					System.out.print(lastContent);
					lastContent=content;
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
