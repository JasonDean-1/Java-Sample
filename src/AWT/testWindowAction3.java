package AWT;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class testWindowAction3
{
	private Frame frame = new Frame();
	private TextArea textArea = new TextArea();
	public void init()
	{
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.out.println("The window is closed!");
				System.exit(0);
			}
		});
		frame.add(textArea);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args)
	{
		new testWindowAction3().init();
	}
}
