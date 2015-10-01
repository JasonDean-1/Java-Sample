package Swing;


import javax.swing.*;
import java.applet.*;
import java.awt.*;

public class testApplet extends JApplet
{


	//��ʼ��Applet�ķ���
	public void init()
	{
		setLayout(new FlowLayout());
		add(new JButton("XXX"));
		add(new JButton("YYY"));
	}
	//����Applet�ķ���
	public void start()
	{
		System.out.println("start����");
	}
	//����Applet����ķ���
	public void paint(Graphics g)
	{
		super.paint(g);
		System.out.println("paint����");
		g.drawLine(3 , 3 , 200 , 300);
	}
	//ֹͣApplet�ķ���
	public void stop()
	{
		System.out.println("stop����");
	}
	//����Applet�ķ���
	public void destroy()
	{
		System.out.println("destroy����");
	}
	public static void main(String[] args)
	{
		JFrame jf = new JFrame();
		JApplet panel = new testApplet();
		panel.setPreferredSize(new Dimension(300, 400));
		//��ʽ����HelloApplet�����init��start����
		panel.init();
		panel.start();
		jf.add(panel);
		jf.pack();
		jf.setVisible(true);
	}
}

