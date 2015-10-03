package IO;


import java.io.*;

public class testSerializable_Transient
{
	public static void main(String[] args) 
	{
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try
		{
			//创建一个ObjectOutputStream输入流
			oos = new ObjectOutputStream(
				new FileOutputStream("transient.txt"));
			Person per = new Person("孙悟空", 500);
			//系统会per对象转换字节序列并输出
			oos.writeObject(per);
			//创建一个ObjectInputStream输入流
			ois = new ObjectInputStream(
				new FileInputStream("transient.txt"));
			Person p = (Person)ois.readObject();
			System.out.println(p.getAge());
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if (ois != null)
					ois.close();
				if (oos != null)
					oos.close();
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
