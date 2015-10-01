import java.awt.List;
import java.util.ArrayList;

public class testList
{
	public static void main(String[] args)
	{
		ArrayList list = new ArrayList();
		for (int i = 0; i < 10; ++i)
		{
			list.add(Integer.toString(i));
		}
		System.out.println(list);
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(list.size() - i - 1));
		}
		list.remove(4);
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(list.size() - i - 1));
		}
	}
}
