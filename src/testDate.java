
import java.util.Calendar;
import java.util.Date;
public class testDate
{
	private static final int YEAR = 0;
	private static final int DATE = 0;

	public static void main(String[] args)
	{
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		System.out.println(date);
		
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(2015,3,1,0,0,0);
		System.out.println(calendar2.getTime());
		System.out.println(calendar2.get(YEAR));
		System.out.println(calendar2.get(DATE));
		
	}
}
