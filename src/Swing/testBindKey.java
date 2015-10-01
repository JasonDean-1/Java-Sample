package Swing;

import java.awt.BorderLayout;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class testBindKey
{
	JFrame jFrame = new JFrame("testBindKey");
	JTextArea textArea = new JTextArea(5, 30);
	JButton sendButton = new JButton("send");
	JTextField textField = new JTextField(15);
	public void init()
	{
		jFrame.add(textArea);
		JPanel panel = new JPanel();
		panel.add(textField);
		panel.add(sendButton);
		jFrame.add(panel, BorderLayout.SOUTH);
		AbstractAction sendMsg = new AbstractAction()
		{
			public void actionPerformed(ActionEvent e)
			{
				textArea.append(textField.getText() + "\n");
				textField.setText("");
			}
		};
		sendButton.addActionListener(sendMsg);
		textField.getInputMap().put(KeyStroke.getKeyStroke('\n',
		        java.awt.event.InputEvent.CTRL_MASK), "send");
		textField.getActionMap().put("send", sendMsg);
		jFrame.pack();
		jFrame.setVisible(true);
	}
	public static void main(String[] args)
	{
		new testBindKey().init();
	}
}
