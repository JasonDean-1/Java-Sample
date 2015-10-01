package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.util.Random;

public class testDraw
{
	private final String RECT_SHAPE = "rect";
	private final String OVAL_SHAPE = "oval";
	private Frame frame = new Frame("testDraw");
	private Button rectButton = new Button("draw a rectangle");
	private Button ovalButton = new Button("draw a oval");
	private MyCanvas drawArea = new MyCanvas();
	private String shape = "";
	public void init()
	{
		Panel panel = new Panel();
		rectButton.addActionListener(e ->
		{
			shape = RECT_SHAPE;
			drawArea.repaint();
		});
		ovalButton.addActionListener(e ->
		{
			shape = OVAL_SHAPE;
			drawArea.repaint();
		});
		panel.add(rectButton);
		panel.add(ovalButton);
		drawArea.setPreferredSize(new Dimension(250, 180));
		frame.add(drawArea);
		frame.add(panel,BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}

	class MyCanvas extends Canvas
	{
		public void paint(Graphics grap)
		{
			Random rand = new Random();
			if (shape.equals(RECT_SHAPE))
			{
				grap.setColor(new Color(80, 100, 200));
				grap.fillRect(rand.nextInt(200), rand.nextInt(120), 40, 60);
			}
			if (shape.equals(OVAL_SHAPE))
			{
				grap.setColor(new Color(80, 100, 200));
				grap.fillOval(rand.nextInt(200), rand.nextInt(120), 50, 40);
			}

		}
	}

	public static void main(String[] args)
	{
		new testDraw().init();
	}
}
