import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class testScanner
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		int number = Integer.parseInt(sc.nextLine());
		ArrayList list = new ArrayList(number);
		String[] detailSplited = sc.nextLine().split(" ");
		System.out.println(detailSplited);
		for (int i = 0; i < number; i++)
		{
            list.add(detailSplited[i]);
		}
		System.out.println(list);
	}
}
