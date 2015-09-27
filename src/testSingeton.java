class dog
{
	private static dog instance;
	private dog ()
	{
		
	}
	public static dog getInstance()
	{
		if(instance == null)
		{
			instance = new dog();
		}
		return instance;
	}
}

public class testSingeton
{
	public static void main(String[] args)
	{
		dog d1 = dog.getInstance();
		dog d2 = dog.getInstance();
		System.out.println(d1 == d2);
		
		String str1 = new String ("hello");
		String str2 = new String ("hello");
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str1 == str2);
		String str3 = "hello";
		String str4 = "hello";
		System.out.println(str3 == str4);
		System.out.println(str3 .equals(str4));
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
		
        
	}
}
