package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;

import javax.swing.Box;
import javax.swing.BoxLayout;

public class testDialog
{
	Frame frame = new Frame();
	Dialog dialog1 = new Dialog(frame , "modeDialog",true);
	Dialog dialog2 = new Dialog(frame , "nonModeDialog",false);
	FileDialog fileDialog1 = new FileDialog(frame, "Open File", FileDialog.LOAD);
	FileDialog fileDialog2 = new FileDialog(frame, "Save File", FileDialog.SAVE);
	Button button1 = new Button("open modeDialog");
	Button button2 = new Button("open nonModeDialog");
	Button button3 = new Button("Open File");
	Button button4 = new Button("Save File");
	public void init()
	{
		dialog1.setBounds(20,30,300,400);
		dialog1.setBackground(Color.BLUE);
		dialog2.setBounds(20,30,300,400);
		dialog1.setBackground(Color.GREEN);

		button1.addActionListener(e->
		{
			dialog1.setVisible(true);
		});

		button2.addActionListener(e->
		{
			dialog2.setVisible(true);
		});
		
		button3.addActionListener(e->
		{
			fileDialog1.setVisible(true);
			System.out.println(fileDialog1.getDirectory()+fileDialog1.getFile());
		});
		button4.addActionListener(e->
		{
			fileDialog2.setVisible(true);
			System.out.println(fileDialog2.getDirectory()+fileDialog2.getFile());
		});
		frame.setLayout(new BoxLayout(frame, BoxLayout.X_AXIS));
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(button4);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args_)
	{
		new testDialog().init();
	}
}
