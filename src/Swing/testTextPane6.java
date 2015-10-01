package Swing;


import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class testTextPane6
{
	JFrame mainWin = new JFrame("测试JTextPane");
	JTextPane txt = new JTextPane();
	StyledDocument doc = txt.getStyledDocument();
	//定义三个属性
	SimpleAttributeSet ror = new SimpleAttributeSet();
	SimpleAttributeSet struts2 = new SimpleAttributeSet();
	SimpleAttributeSet j2ee = new SimpleAttributeSet();


	public void init()
	{
		//为ror属性集设置颜色、字体大小、字体和下划线
        StyleConstants.setForeground(ror, Color.RED);
		StyleConstants.setFontSize(ror, 24);
		StyleConstants.setFontFamily(ror, "Dialog");
		StyleConstants.setUnderline(ror, true);

		//为struts2属性集设置颜色、字体大小、字体和粗体字
        StyleConstants.setForeground(struts2, Color.BLUE);
		StyleConstants.setFontSize(struts2, 30);
		StyleConstants.setFontFamily(struts2, "Arial Black");
		StyleConstants.setBold(struts2, true);


		//为j2ee属性集设置颜色、字体大小、斜体字
		StyleConstants.setForeground(j2ee, Color.GREEN);
		StyleConstants.setFontSize(j2ee, 32);
		StyleConstants.setItalic(j2ee, true);

		 
		//设置不允许编辑
		txt.setEditable(false);
	
		txt.setText("ROR敏捷开发最佳实践\n"
			+ "Struts2权威指南\n"
			+ "轻量级J2EE企业应用实战\n");
	
		//分别为文档中三段文字设置不同的外观样式
		doc.setCharacterAttributes(0 , 12 , 
			ror, true);
		doc.setCharacterAttributes(12 , 12 , 
			struts2, true);
		doc.setCharacterAttributes(24 , 30 , 
			j2ee, true);	

		mainWin.add(new JScrollPane(txt), BorderLayout.CENTER);

		//获取屏幕尺寸
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int inset = 100;
		//设置主窗口的大小
        mainWin.setBounds ( inset, inset, 
			screenSize.width - inset * 2, screenSize.height - inset * 2 );
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.setVisible(true);
   }

	public static void main(String[] args) 
	{
		new testTextPane6().init();
	}
}
