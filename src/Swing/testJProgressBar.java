package Swing;

import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

public class testJProgressBar
{
	JFrame jFrame = new JFrame("testJProgressBar");
	JProgressBar indecateBar = new JProgressBar(JProgressBar.VERTICAL);
	JCheckBox indeterminate = new JCheckBox("indetermined Process");
	JCheckBox noBorder = new JCheckBox("noBorder");
	public void init()
	{
		Box box = new Box(BoxLayout.Y_AXIS);
		box.add(indeterminate);
		box.add(noBorder);
		jFrame.setLayout(new FlowLayout());
		jFrame.add(box);
		jFrame.add(indecateBar);
		indecateBar.setMinimum(0);
		indecateBar.setMaximum(100);
		indecateBar.setStringPainted(true);
		noBorder.addActionListener(e->
		{
			indecateBar.setIndeterminate(indeterminate.isSelected());
			indecateBar.setStringPainted(!indeterminate.isSelected());
		});
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);
		
		for(int i=0;i<=100;i++)
		{
			indecateBar.setValue(i);
			try
			{
				Thread.sleep(100);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args)
	{
		new testJProgressBar().init();
	}
	
}
