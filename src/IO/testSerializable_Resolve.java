package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

class Orientation
implements Serializable
{
public static final Orientation HORIZONTAL = new Orientation(1);
public static final Orientation VERTICAL = new Orientation(2);
private int value;
private Orientation(int value)
{
	this.value = value;
}
private Object readResolve() throws ObjectStreamException
{
	if (value == 1)
	{
		return HORIZONTAL;
	}
	if (value == 2)
	{
		return VERTICAL;
	}
	return null;
}
}

public class testSerializable_Resolve
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
			oos.writeObject(Orientation.HORIZONTAL);
			//创建一个ObjectInputStream输入流
			ois = new ObjectInputStream(
				new FileInputStream("transient.txt"));
			Orientation ori = (Orientation)ois.readObject();
			System.out.println(ori == Orientation.HORIZONTAL);
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
