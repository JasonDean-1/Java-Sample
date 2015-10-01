package AWT;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

public class testPanel
{
	public static void main(String[] args)
	{
		Frame frame = new Frame();
		Panel panel = new Panel();
		panel.add(new TextField(20));
		panel.add(new Button("Hit me!!!"));
		frame.setTitle("MyFrame");
		frame.add(panel);
		frame.setBounds(100,100,250,250);
		frame.setVisible(true);
	}
}
