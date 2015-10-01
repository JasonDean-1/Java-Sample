import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class testCollection
{
	public static void main(String[] args)
	{
		Collection collection = new ArrayList();
		for (int i =0 ;i<10;i++)
		{
			collection.add(i);
		}
		System.out.println(collection);
		
		Collection collection2 = new HashSet();
		for (int i =0 ;i<10;i++)
		{
			collection2.add(i);
		}
		System.out.println(collection2);
		System.out.println(collection.containsAll(collection2));

		System.out.println(collection2.toString());
		for (int i =0 ;i<10;i++)
		{
			collection2.add(i+10);
		}
		System.out.println(collection2.toString());
		collection2.forEach(obj -> System.out.print(obj)); //Lambda
		
		Iterator it = collection.iterator();
		while(it.hasNext())
		{
			String num = it.next().toString();
			System.out.println(num.toString());
		}
		
	}
}
