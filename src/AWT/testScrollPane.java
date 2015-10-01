package AWT;
import java.awt.Button;
import java.awt.Frame;
import java.awt.ScrollPane;
import java.awt.TextField;

public class testScrollPane
{
	public static void main(String[] args)
	{
		Frame frame = new Frame("Test");
		ScrollPane scrollPane = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
		scrollPane.add(new TextField(20));
		scrollPane.add(new Button("hit me"));
		frame.add(scrollPane);
		frame.setBounds(100,100,250,250);
		frame.setVisible(true);
	}
}
