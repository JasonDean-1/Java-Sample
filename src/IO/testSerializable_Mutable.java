package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class testSerializable_Mutable
{
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try
		{
			//����һ��ObjectOutputStream������
			oos = new ObjectOutputStream(
				new FileOutputStream("mutable.txt"));
			Person per = new Person("�����", 500);
			//ϵͳ��per����ת���ֽ����в����
			oos.writeObject(per);
			//�ı�per�����name����
			per.setName("��˽�");
			//ϵͳֻ��������л���ţ����Ըı���name���ᱻ���л�
			oos.writeObject(per);
			//����һ��ObjectInputStream������
			ois = new ObjectInputStream(
				new FileInputStream("mutable.txt"));
			Person p1 = (Person)ois.readObject();
			Person p2 = (Person)ois.readObject();
			//�������true���������л���p1����p2
			System.out.println(p1 == p2);
			//������Ȼ�������������ա������ı�������û�б����л�
			System.out.println(p2.getName());
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
