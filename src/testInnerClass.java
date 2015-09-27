class Cow
{
	private double weight;
	public Cow()
	{

	}
	public Cow(double weight)
	{
		this.weight = weight;
	}
	public void testCowLeg()
	{
		CowLeg cowLeg = new CowLeg(123.456,"BLUE");
		cowLeg.info();
	}
	private class CowLeg
	{
		private double length;
		private String color;
		public CowLeg()
		{

		}
		public CowLeg(double length, String color)
		{
			this.length = length;
			this.color = color;
		}
		public void info()
		{
			System.out.println("Color: " + this.color + "   Length: " + this.length);
		}
	}
}

public class testInnerClass
{
	public static void main(String[] args)
	{
		Cow cow = new Cow(121.1);
		cow.testCowLeg();
	}
}
