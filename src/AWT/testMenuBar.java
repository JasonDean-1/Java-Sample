package AWT;

import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class testMenuBar
{
	private Frame frame = new Frame();
	private MenuBar menuBar = new MenuBar();
	Menu file = new Menu("File");
	Menu edit = new Menu("Edit");
	MenuItem newItem = new MenuItem("New..");
	MenuItem saveItem = new MenuItem("Save");
	MenuItem exitItem = new MenuItem("exit", new MenuShortcut(KeyEvent.VK_X));
	CheckboxMenuItem autoWrap = new CheckboxMenuItem("Auto Wrap");
	MenuItem copyItem = new MenuItem("Copy");
	MenuItem pasteItem = new MenuItem("paste");
	Menu format = new Menu("Format");
	MenuItem commentItem =new MenuItem("Comment",new MenuShortcut(KeyEvent.VK_SLASH,true));
	MenuItem cancelItem = new MenuItem("Revert");
	private TextArea textArea = new TextArea(6,40);
	public void init()
	{
		ActionListener menuListener = e->
		{
			String cmd = e.getActionCommand();
			textArea.append("Click "+cmd+" Menu"+"\n");
			if(cmd.equals("exit"))
			{
				System.exit(0);
			}
		};
		commentItem.addActionListener(menuListener);
		exitItem.addActionListener(menuListener);
		file.add(newItem);
		file.add(saveItem);
		file.add(exitItem);
		
		edit.add(autoWrap);
		edit.addSeparator();
		edit.add(copyItem);
		edit.add(pasteItem);
		
		format.add(commentItem);
		format.add(cancelItem);
		
		edit.add(new MenuItem("-"));
		edit.add(format);

		menuBar.add(file);
		menuBar.add(edit);
		
		frame.setMenuBar(menuBar);
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		frame.add(textArea);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new testMenuBar().init();
	}
}
