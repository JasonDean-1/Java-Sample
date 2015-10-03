package IO;

import java.io.*;
import java.util.*;

class People
	implements java.io.Serializable
{
	private String name;
	private int age;

	public People(String name , int age)
	{
		System.out.println("�в����Ĺ�����");
		this.name = name;
		this.age = age;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		 return this.name;
	}

	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		 return this.age;
	}

	private Object writeReplace() throws ObjectStreamException
	{
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(name);
		list.add(age);
		return list;
	}
}
public class testSerializable_Replace
{
	public static void main(String[] args) 
	{
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try
		{
			//����һ��ObjectOutputStream������
			oos = new ObjectOutputStream(
				new FileOutputStream("replace.txt"));
			People per = new People("�����", 500);
			//ϵͳ�Ὣper����ת���ֽ����в����
			oos.writeObject(per);
			//����һ��ObjectInputStream������
			ois = new ObjectInputStream(
				new FileInputStream("replace.txt"));
			ArrayList list = (ArrayList)ois.readObject();
			System.out.println(list);
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
