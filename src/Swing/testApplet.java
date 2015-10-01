package Swing;


import javax.swing.*;
import java.applet.*;
import java.awt.*;

public class testApplet extends JApplet
{


	//初始化Applet的方法
	public void init()
	{
		setLayout(new FlowLayout());
		add(new JButton("XXX"));
		add(new JButton("YYY"));
	}
	//启动Applet的方法
	public void start()
	{
		System.out.println("start方法");
	}
	//绘制Applet界面的方法
	public void paint(Graphics g)
	{
		super.paint(g);
		System.out.println("paint方法");
		g.drawLine(3 , 3 , 200 , 300);
	}
	//停止Applet的方法
	public void stop()
	{
		System.out.println("stop方法");
	}
	//销毁Applet的方法
	public void destroy()
	{
		System.out.println("destroy方法");
	}
	public static void main(String[] args)
	{
		JFrame jf = new JFrame();
		JApplet panel = new testApplet();
		panel.setPreferredSize(new Dimension(300, 400));
		//显式调用HelloApplet对象的init、start方法
		panel.init();
		panel.start();
		jf.add(panel);
		jf.pack();
		jf.setVisible(true);
	}
}

