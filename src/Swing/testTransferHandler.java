package Swing;

import java.awt.*;
import javax.swing.*;

public class testTransferHandler

{
	private JFrame jf = new JFrame("测试TransferHandler");
	JColorChooser chooser = new JColorChooser();
	JTextArea txt = new JTextArea("测试TransferHandler\n" + 
		"直接将上面颜色拖入以改变文本颜色");
	public void init()
	{
		chooser.setDragEnabled(true);
		jf.add(chooser, BorderLayout.SOUTH);
		txt.setDragEnabled(true);
		txt.setTransferHandler(new TransferHandler("foreground"));
		jf.add(new JScrollPane(txt));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	public static void main(String[] args) 
	{
		new testTransferHandler().init();
	}
}
