package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class testActionListener
{
	private Frame frame = new Frame("testActionHandler");
	private Button okButton = new Button("OK");
	private TextField textField = new TextField(30);
	public void init()
	{
		okButton.addActionListener(new OkListener());
		frame.add(textField);
		frame.add(okButton,BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}
	class OkListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("OK button is pressed");
			textField.setText("Hello World");
		}
	}
	
	public static void main(String[] args)
	{
		new testActionListener().init();
	}
}
