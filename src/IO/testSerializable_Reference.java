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
			// ����һ��ObjectOutputStream�����
			oos = new ObjectOutputStream(new FileOutputStream("teacher.txt"));
			Person per = new Person("�����", 500);
			Teacher t1 = new Teacher("��ɮ", per);
			Teacher t2 = new Teacher("������ʦ", per);
			// ���ν��ĸ�����д�������
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
			// ����һ��ObjectInputStream������
			ois = new ObjectInputStream(new FileInputStream("teacher.txt"));
			// ���ζ�ȡObjectInputStream�������е��ĸ�����
			Teacher t1 = (Teacher) ois.readObject();
			Teacher t2 = (Teacher) ois.readObject();
			Person p = (Person) ois.readObject();
			Teacher t3 = (Teacher) ois.readObject();
			// ���true
			System.out.println("t1��student���ú�p�Ƿ���ͬ��" + (t1.getStudent() == p));
			// ���true
			System.out.println("t2��student���ú�p�Ƿ���ͬ��" + (t2.getStudent() == p));
			// ���true
			System.out.println("t2��t3�Ƿ���ͬһ������" + (t2 == t3));
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
