import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;


class Apple<T extends Number>
{
	T col;
}

public class testGeneric
{
	public static void main(String[] args)
	{
		ArrayList<String> strList = new ArrayList<>();
		strList.add("aaaa");
		strList.add("bbbb");
		strList.add(Integer.toString(0));
		System.out.println(strList);
		
		Apple<Integer> apple = new Apple<>();
		Apple<Double> apple2 = new Apple();

		System.out.println(apple.col);
		System.out.println(apple2.col);
	}
}
