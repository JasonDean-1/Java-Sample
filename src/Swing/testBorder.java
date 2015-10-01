package Swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public class testBorder
{
	private JFrame jFrame = new JFrame("testBorder");
	
	public void init()
	{
		Border bevelBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED,
		        Color.RED, Color.GREEN, Color.BLUE, Color.GRAY);
		jFrame.setLayout(new GridLayout(2,4));
		jFrame.add(getPanelWithBorder(bevelBorder,"BevelBorder"));
		Border lineBorder = BorderFactory.createLineBorder(Color.ORANGE,10);
		jFrame.add(getPanelWithBorder(lineBorder, "LineBorder"));
		Border emptyBorder= BorderFactory.createEmptyBorder(20,5,10,30);
		jFrame.add(getPanelWithBorder(emptyBorder, "EmptyBorder"));
		Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED,Color.RED,Color.GREEN);
		jFrame.add(getPanelWithBorder(etchedBorder, "EtchedBorder"));
		TitledBorder titleBorder = new TitledBorder(lineBorder,"testTitle",TitledBorder.LEFT,TitledBorder.BOTTOM,new Font("StSong", Font.BOLD, 18),Color.BLUE);
		jFrame.add(getPanelWithBorder(titleBorder, "TitleBorder"));
		MatteBorder matteBorder = new MatteBorder(20, 5,10,30,Color.GREEN);
		jFrame.add(getPanelWithBorder(matteBorder, "MatteBorder"));
		CompoundBorder compoundBorder = new CompoundBorder(new LineBorder(Color.RED,8), titleBorder);
		jFrame.add(getPanelWithBorder(compoundBorder, "CompoundBorder"));
		jFrame.pack();
		jFrame.setVisible(true);
	}

	public JPanel getPanelWithBorder(Border border, String borderName)
	{
		JPanel panel = new JPanel();
		panel.add(new JLabel(borderName));
		panel.setBorder(border);
		return panel;
	}
	
	public static void main(String[] args)
	{
		new testBorder().init();
	}
}

