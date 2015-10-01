package Swing;


import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.net.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;


public class testAppletSc extends Applet
{
	final String testStr = "Java����棬ѧϰ����Ȥ��";
	//���ڱ����ַ�����һ�γ��ֵ�����
	private int nextX;
	private int nextY;
	private Color nextColor;
	private Font nextFont;
	java.util.Random rand = new java.util.Random(System.currentTimeMillis());
	public void init()
	{
		Timer timer = new Timer(200 , new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//���������һ�����ꡢ��ɫ�������С
				nextX = rand.nextInt(400);
				nextY = rand.nextInt(300);
				nextColor = new Color(rand.nextInt(255) , rand.nextInt(255) , rand.nextInt(255));
				nextFont = new Font("Times" , Font.BOLD , rand.nextInt(60));
				//ǿ���ػ�
				repaint();
			}
		});
		timer.start();
	}
	//����Applet����ķ���
	public void paint(Graphics g)
	{
		g.setColor(nextColor);
		g.setFont(nextFont);
		g.drawString(testStr, nextX, nextY);
	}

	public static void main(String[] args)
	{
		JFrame jf = new JFrame();
		testAppletSc panel = new testAppletSc();
		panel.setPreferredSize(new Dimension(400, 300));
		panel.init();
		panel.start();
		jf.add(panel);
		jf.pack();
		jf.setVisible(true);
	}
}
