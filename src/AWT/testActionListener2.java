package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import java.util.Scanner;import javax.swing.border.Border;

public class testActionListener2
{
	private Frame frame = new Frame("test");
	private TextArea textArea = new TextArea();
	private Button firstButton = new Button("firstButton");
	private Button secondButton = new Button("secondButton");
	public void init()
	{
		FirstListener firstListener = new FirstListener();
		firstButton.addActionListener(firstListener);
		firstButton.addActionListener(new SecondListener());
		secondButton.addActionListener(firstListener);
		frame.add(textArea);
		Panel panel = new Panel();
		panel.add(firstButton);
		panel.add(secondButton);
		frame.add(panel,BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}

	class FirstListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			textArea.append("The first listener is trigged,and the source is :"
			        + e.getActionCommand() + "\n");

		}
	}
	class SecondListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			textArea.append("The second listener is trigged,and the source is :"
			        + e.getActionCommand() + "\n");

		}
	}

	public static void main(String[] args)
	{
		new testActionListener2().init();
	}
}
