package AWT;

import java.awt.BorderLayout;
import java.awt.CheckboxMenuItem;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Action;
import javax.swing.border.Border;

public class testPopupMenu
{
	private TextArea textArea = new TextArea();
	private Frame frame = new Frame();
	PopupMenu popupMenu =new PopupMenu();
	CheckboxMenuItem autoWrap = new CheckboxMenuItem("Auto Wrap");
	MenuItem copyItem = new MenuItem("Copy");
	MenuItem pasteItem = new MenuItem("Paste");
	Menu format = new Menu("Format");
	MenuItem commentItem = new MenuItem("Comment",new MenuShortcut(KeyEvent.VK_SLASH));
	MenuItem cancleItem =new MenuItem("Revert");
	public void init()
	{
		ActionListener menuListener = e->
		{
			String cmd = e.getActionCommand();
			textArea.append(cmd +" has pressed!");
			if(cmd.equals("exit"))
			{
				System.exit(0);
			}
		};
	commentItem.addActionListener(menuListener);
	popupMenu.add(autoWrap);
	popupMenu.addSeparator();
	popupMenu.add(copyItem);
	popupMenu.add(pasteItem);
	
	format.add(commentItem);
	format.add(cancleItem);
	
	popupMenu.add(new MenuItem("-"));
	popupMenu.add(format);
	final Panel panel =new Panel();
	panel.setPreferredSize(new Dimension(300, 160));
	panel.add(popupMenu);
	panel.addMouseListener(new MouseAdapter()
	{
		public void mouseReleased(MouseEvent e)
		{
			if(e.isPopupTrigger())
			{
				popupMenu.show(panel,e.getX(),e.getY());
			}
		}
	});
	frame.add(panel);
	frame.add(textArea,BorderLayout.NORTH);
	frame.addWindowListener(new WindowAdapter()
	{
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);
		}
	});
	frame.pack();
	frame.setVisible(true);
	}
	public static void main(String [] args)
	{
		new testPopupMenu().init();
	}
}
