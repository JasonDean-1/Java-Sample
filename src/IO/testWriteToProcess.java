package IO;

import java.util.*;
import java.io.*;

public class testWriteToProcess
{
	public static void main(String[] args) 
	{
		PrintStream ps = null;
		try
		{
			//����java ReadStandard����������и�������ӽ���
			Process p = Runtime.getRuntime().exec("java ReadStandard");
			//��p���̵����������PrintStream����
			//���������Ա����������������p����������������
			ps = new PrintStream(p.getOutputStream());
			//��ReadStandard����д�����ݣ���Щ���ݽ���ReadStandard��ȡ
			ps.println("��ͨ�ַ���");
			ps.println(new testWriteToProcess());
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if (ps != null)
				ps.close();
		}
	}
}
//����һ��ReadStandard�࣬������Խ��ܱ�׼���룬
//������׼����д��out.txt�ļ���
class ReadStandard
{
	public static void main(String[] args) throws Exception
	{

		//ʹ��System.in����Scanner�������ڻ�ȡ��׼����
		Scanner sc = new Scanner(System.in);
		PrintStream ps = new PrintStream(
			new FileOutputStream("./src/IO/out.txt"));
		//��������һ�н�ֻ�ѻس���Ϊ�ָ���
		sc.useDelimiter("\n");
		//�ж��Ƿ�����һ��������
		while(sc.hasNext())
		{
			//���������
			ps.println("��������������ǣ�" + sc.next());
		}
		ps.close();
	}
}
