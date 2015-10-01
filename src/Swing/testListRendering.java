package Swing;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class testListRendering
{
	private JFrame mainWin = new JFrame("好友列表");
	private String[] friends = new String[]
	{
		"李清照",
		"苏格拉底",
		"李白",
		"弄玉",
		"虎头"
	};
	//定义一个JList对象
	private JList friendsList = new JList(friends);

	public void init()
	{
		//设置该JList使用ImageCellRenderer作为单元格绘制器
		friendsList.setCellRenderer(new ImageCellRenderer()); 

		mainWin.add(new JScrollPane(friendsList));
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}

	public static void main(String[] args) 
	{
		new testListRendering().init();
	}
}


class ImageCellRenderer extends JPanel implements ListCellRenderer
{
	private ImageIcon icon;
	private String name;
	//定义绘制单元格时的背景色
	private Color background;
	//定义绘制单元格时的前景色
	private Color foreground;

	public Component getListCellRendererComponent(JList list, Object value, int index, 
	  boolean isSelected, boolean cellHasFocus)
	{
		icon = new ImageIcon("ico/" + value + ".gif");
		name = value.toString();
		background = isSelected ? list.getSelectionBackground() : list.getBackground();
		foreground = isSelected ? list.getSelectionForeground() : list.getForeground();
		//返回该JPanel对象作为单元格绘制器
		return this;
	}
	//重写paintComponent方法，改变JPanel的外观
	public void paintComponent(Graphics g)
	{
		int imageWidth = icon.getImage().getWidth(null);
		int imageHeight = icon.getImage().getHeight(null);
		g.setColor(background);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(foreground);
		//绘制好友图标
		g.drawImage(icon.getImage() , getWidth() / 2 - imageWidth / 2 , 10 , null);
		g.setFont(new Font("SansSerif" , Font.BOLD , 18));
		//绘制好友用户名
		g.drawString(name, getWidth() / 2 - name.length() * 10 , imageHeight + 30 );
	}
	//通过该方法来设置该ImageCellRenderer的最佳大小
	public Dimension getPreferredSize()
	{  
		return new Dimension(60, 80);
	}
}
