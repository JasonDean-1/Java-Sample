package AWT;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class testWindowAction
{
	private Frame frame = new Frame();
	private TextArea textArea = new TextArea();
	public void init()
	{
		frame.addWindowListener(new MyWindowListener());
		frame.add(textArea);
		frame.pack();
		frame.setVisible(true);
	}

	class MyWindowListener implements WindowListener
	{
		public void windowActivated(WindowEvent e)
		{
			textArea.append("The window is actived"+"\n");
		}
		public void windowClosed(WindowEvent e)
		{
			textArea.append("The window is closed"+"\n");
		}
		public void windowClosing(WindowEvent e)
		{
			textArea.append("The window is closing"+"\n");
			System.exit(0);
		}
		public void windowDeactivated(WindowEvent e)
		{
			textArea.append("The window is deactived"+"\n");
		}
		public void windowDeiconified(WindowEvent e)
		{
			textArea.append("The window is deiconified"+"\n");
		}
		public void windowIconified(WindowEvent e)
		{
			textArea.append("The window is iconified"+"\n");
		}
		public void windowOpened(WindowEvent e)
		{
			textArea.append("The window is opened"+"\n");
		}
	}
	public static void main(String[] args)
	{
		new testWindowAction().init();
	}
}
