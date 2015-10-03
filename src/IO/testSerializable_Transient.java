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
			//����һ��ObjectOutputStream������
			oos = new ObjectOutputStream(
				new FileOutputStream("transient.txt"));
			Person per = new Person("�����", 500);
			//ϵͳ��per����ת���ֽ����в����
			oos.writeObject(per);
			//����һ��ObjectInputStream������
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
