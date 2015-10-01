import java.io.IOException;

public class testRunTime
{
	public static void main(String[] args)
	{
		Runtime rt = Runtime.getRuntime();
		System.out.println(rt.availableProcessors());
		System.out.println(rt.freeMemory());
		System.out.println(rt.totalMemory());
		System.out.println(rt.maxMemory());
		try
		{
			rt.exec("notepad.exe");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
