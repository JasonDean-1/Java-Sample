package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/*
class Person implements Serializable
{
	private String name;
	private int age;
	public Person(String name, int age)
	{
		System.out.println("Constructor with param");
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
}
*/
class Teacher implements Serializable
{
	private String name;
	private Person student;

	public Teacher(String name, Person student)
	{
		this.name = name;
		this.student = student;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	public void setStudent(Person student)
	{
		this.student = student;
	}
	public Person getStudent()
	{
		return this.student;
	}
}

public class testSerializable_Reference
{
	static void writeObject()
	{
		ObjectOutputStream oos = null;
		try
		{
			// 创建一个ObjectOutputStream输出流
			oos = new ObjectOutputStream(new FileOutputStream("teacher.txt"));
			Person per = new Person("孙悟空", 500);
			Teacher t1 = new Teacher("唐僧", per);
			Teacher t2 = new Teacher("菩提祖师", per);
			// 依次将四个对象写入输出流
			oos.writeObject(t1);
			oos.writeObject(t2);
			oos.writeObject(per);
			oos.writeObject(t2);

		} catch (IOException ex)
		{
			ex.printStackTrace();
		} finally
		{
			try
			{
				if (oos != null)
					oos.close();
			} catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
	static void readObject()
	{
		ObjectInputStream ois = null;
		try
		{
			// 创建一个ObjectInputStream输入流
			ois = new ObjectInputStream(new FileInputStream("teacher.txt"));
			// 依次读取ObjectInputStream输入流中的四个对象
			Teacher t1 = (Teacher) ois.readObject();
			Teacher t2 = (Teacher) ois.readObject();
			Person p = (Person) ois.readObject();
			Teacher t3 = (Teacher) ois.readObject();
			// 输出true
			System.out.println("t1的student引用和p是否相同：" + (t1.getStudent() == p));
			// 输出true
			System.out.println("t2的student引用和p是否相同：" + (t2.getStudent() == p));
			// 输出true
			System.out.println("t2和t3是否是同一个对象：" + (t2 == t3));
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			try
			{
				if (ois != null)
					ois.close();
			} catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
	public static void main(String[] args)
	{
		writeObject();
		readObject();
	}

}
