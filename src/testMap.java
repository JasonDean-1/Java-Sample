import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

class A
{
	int count;
	public A(int count)
	{
		this.count = count;
	}
	public boolean equals(Object obj)
	{
		if (obj == this)
		{
			return true;
		}
		if (obj != null && obj.getClass() == A.class)
		{
			A a = A(obj);
			return this.count == a.count;
		}
		return false;
	}
	private A A(Object obj)
	{
		// TODO Auto-generated method stub
		return null;
	}
	public int hashCode()
	{
		return this.count;
	}
}
class B
{
	public boolean equals(Object obj)
	{
		return true;
	}
}

public class testMap
{
	public static void main(String[] args)
	{
		Map map = new HashMap();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d", 4);
		System.out.println(map);
		map.replace("c", 33);
		System.out.println(map);

		Hashtable hashTable = new Hashtable();
		hashTable.put(new A(100),"aaa");
		hashTable.put(new A(200),"bbb");
		hashTable.put(new A(300),"ccc");
		System.out.println(hashTable);
	}
}
