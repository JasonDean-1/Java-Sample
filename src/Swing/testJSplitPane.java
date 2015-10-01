package Swing;

import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class testJSplitPane
{
	Book[] books = new Book[]{
			new Book("Struts2Ȩ��ָ��" , new ImageIcon("ico/struts2.jpg") , 
				"ȫ�����Struts2�ĸ���\n��֪ʶ"),
			new Book("������J2EE��ҵӦ��ʵս" , new ImageIcon("ico/j2ee.jpg") ,
				"����Struts��Spring��\nHibernate���Ͽ�����֪ʶ"),
			new Book("����J2EE��Ajax����" , new ImageIcon("ico/ajax.jpg") , 
				"ȫ�����J2EEƽ̨��Ajax\n�����ĸ�����֪ʶ")};
	JFrame jFrame = new JFrame();
	JList<Book> bookList = new JList<>(books);
	JLabel bookCover = new JLabel();
	JTextArea bookDesc = new JTextArea();
	public void init()
	{
		bookList.setPreferredSize(new Dimension(150, 300));
		bookCover.setPreferredSize(new Dimension(300, 150));
		bookDesc.setPreferredSize(new Dimension(300, 150));
		bookList.addListSelectionListener(new ListSelectionListener()
		{
			@Override
			public void valueChanged(ListSelectionEvent event)
			{
				Book book = (Book) bookList.getSelectedValue();
				bookCover.setIcon(book.getIco());
				bookDesc.setText(book.getDesc());
			}
		});
	JSplitPane left = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true , 
			bookCover, new JScrollPane(bookDesc));
		//�򿪡�һ����չ��������
		left.setOneTouchExpandable(true);
		//����������÷ָ����Ĵ�С��
		//left.setDividerSize(50); 
		//���ø÷ָ��������������������Ѵ�С���������� 
		left.resetToPreferredSizes();
		//����һ��ˮƽ�ķָ����
		//��left���������ߣ���bookList��������ұ�
		JSplitPane content = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
			left, bookList);
		jFrame.add(content);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);
	}
	public static void main(String[] args)
	{
		new testJSplitPane().init();
	}
}

class Book
{
	private String name;
	private Icon ico;
	private String desc;

	public Book()
	{
	}

	public Book(String name, Icon ico, String desc)
	{
		this.name = name;
		this.ico = ico;
		this.desc = desc;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	public void setIco(Icon ico)
	{
		this.ico = ico;
	}
	public Icon getIco()
	{
		return this.ico;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	public String getDesc()
	{
		return this.desc;
	}
	public String toString()
	{
		return name;
	}
}