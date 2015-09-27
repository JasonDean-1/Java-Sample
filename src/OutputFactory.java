
public class OutputFactory
{
	public Output getOutput()
	{
		return new Printer();
	}
	public static void main(String[] args)
	{
		OutputFactory of = new OutputFactory();
		Computer c= new Computer(of.getOutput());
		c.keyIn("test1");
		c.keyIn("test2");
		c.keyIn("test3");
		c.print();
	}
}
