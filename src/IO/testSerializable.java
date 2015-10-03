package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

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

public class testSerializable
{
	static void writeObject() throws FileNotFoundException, IOException
	{
		ObjectOutputStream oos = new ObjectOutputStream(
		        new FileOutputStream("./src/IO/object.txt"));
		Person person = new Person("jason", 20);
		oos.writeObject(person);
	}
	static void readObject() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		ObjectInputStream ois = new ObjectInputStream(
		        new FileInputStream("./src/IO/object.txt"));
		Person person = (Person)ois.readObject();
		System.out.println("Name: "+person.getName()+"\nAge:"+person.getAge());
	}
	public static void main(String[] args)
	{
		try
		{
			writeObject();
			readObject();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
