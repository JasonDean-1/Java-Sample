
public class testString
{
	public static void main(String[] args)
	{
		StringBuilder sb= new StringBuilder();
		sb.append("java");
		sb.insert(0, "heelo");
		sb.reverse();
		
		System.out.println(sb.length());
		
		System.out.println(sb);
		
	}
}
