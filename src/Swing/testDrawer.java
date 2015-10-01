package Swing;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class testDrawer
{
	private final int AREA_WIDTH = 500;
	private final int AREA_HEIGHT = 400;
	private int previousAxisX = -1;
	private int previousAxisY = -1;
	JPopupMenu popupMenu = new JPopupMenu();
	JMenuItem chooseColor = new JMenuItem("Choose Color");
	BufferedImage image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT,
	        BufferedImage.TYPE_INT_RGB);
	Graphics graphics = image.getGraphics();

	private JFrame jFrame = new JFrame("test");
	private DrawCanvas drawArea = new DrawCanvas();
	private Color foreColor = new Color(255, 0, 0);
	public void init()
	{
		chooseColor.addActionListener(actionListener ->
		{
			final JColorChooser colorPanel = new JColorChooser(foreColor);
			JDialog jDialog = JColorChooser.createDialog(jFrame, "Ñ¡Ôñ»­±ÊÑÕÉ«", false,
		            colorPanel, new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					foreColor = colorPanel.getColor();
				}
			}, null);
			jDialog.setVisible(true);
		});
		popupMenu.add(chooseColor);
		drawArea.setComponentPopupMenu(popupMenu);
		graphics.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);
		drawArea.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
		drawArea.addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent e)
			{
				if (previousAxisX > 0 && previousAxisY > 0)
				{
					graphics.setColor(foreColor);
					graphics.drawLine(previousAxisX, previousAxisY, e.getX(),
		                    e.getY());
				}
				previousAxisX = e.getX();
				previousAxisY = e.getY();
				drawArea.repaint();
			}
		});
		drawArea.addMouseListener(new MouseAdapter()
		{
			public void mouseReleased(MouseEvent e)
			{
				previousAxisX = -1;
				previousAxisY = -1;
			}
		});
		jFrame.add(drawArea);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);
	}

	class DrawCanvas extends JPanel
	{
		public void paint(Graphics graphics)
		{
			graphics.drawImage(image, 0, 0, null);
		}
	}
	public static void main(String[] args)
	{
		new testDrawer().init();
	}
}
