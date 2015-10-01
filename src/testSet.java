import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.concurrent.LinkedBlockingDeque;

class R
{
	int count = 0;
	public R(int count)
	{
		this.count = count;
	}
	public String toString()
	{
		return "R[Count:" + count + "]";
	}
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj != null && obj.getClass() == R.class)
		{
			R r = (R) obj;
			return this.count == r.count;
		}
		return false;
	}
	public int hashCode()
	{
		return this.count;
	}
}


public class testSet
{
	public static void main(String[] args)
	{
		HashSet nums = new HashSet();
		for (int i = 0; i < 10; i++)
		{
			nums.add(i);
		}
		System.out.println(nums);
		
		HashSet hashSet = new HashSet();
		hashSet.add(new R(5));
		hashSet.add(new R(-3));
		hashSet.add(new R(9));
		hashSet.add(new R(-2));
		System.out.println(hashSet);
		System.out.println(hashSet.hashCode());
		System.out.println(hashSet.equals(5));
		
		Iterator it = hashSet.iterator();
		R firstNum = (R)it.next();
		firstNum.count=-3;
		System.out.println(hashSet);
		hashSet.remove(new R(-3));
		System.out.println(hashSet);
		
		
		LinkedHashSet linkedHashSet = new LinkedHashSet();
		linkedHashSet.add("Java");
		linkedHashSet.add("Books");
		System.out.println(linkedHashSet);
		
		
		TreeSet treeSet = new TreeSet();
		for (int i = 0; i < 10; i++)
		{
			treeSet.add(i);
		}
		System.out.println(treeSet);
		System.out.println(treeSet.first());
		System.out.println(treeSet.last());
		System.out.println(treeSet.headSet(4));
		System.out.println(treeSet.tailSet(4));
		System.out.println(treeSet.subSet(3, 8));
		
	}
}
