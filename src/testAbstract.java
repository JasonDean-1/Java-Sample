abstract class speedMeter
{
	private double turnRate;
	public speedMeter()
	{

	}
	public abstract double getRadius();
	public void setTurnRate(double turnRate)
	{
		this.turnRate = turnRate;
	}
	public double getSpeed()
	{
		return java.lang.Math.PI * 2 * getRadius() * turnRate;
	}
}

public class testAbstract extends speedMeter
{
	public double getRadius()
	{
		return 0.28;
	}
	public static void main(String[] args)
	{
		testAbstract ta = new testAbstract();
		ta.setTurnRate(100);
		System.out.print(ta.getRadius() + "   " + ta.getSpeed());
	}
}
