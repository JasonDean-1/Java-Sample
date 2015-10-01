interface Eatable
{
	void taste();
}
interface Flyable
{
	void fly(String weather);
}
interface Addable
{
	int add(int a, int b);
}

public class testLambda
{
	public void eat(Eatable e)
	{
		System.out.println(e);
		e.taste();
	}
	public void drive(Flyable f)
	{
		System.out.println(f);
		f.fly("flying!");
	}
	public void add(Addable a)
	{
		System.out.println(a.add(5, 3));
	}
	public static void main(String[] args)
	{
		testLambda tl =new testLambda();
		tl.eat(()->System.out.println("EEEEEEEEEE"));
	}
}
