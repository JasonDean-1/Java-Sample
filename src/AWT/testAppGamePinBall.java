package AWT;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.Timer;

public class testAppGamePinBall
{
	private final int TABLE_WIDTH = 300;
	private final int TABLE_HEIGHT = 400;
	private final int RACKET_Y = 340;
	private final int RACKET_HEIGHT = 20;
	private final int RACKET_WIDTH = 60;
	private final int BALL_SIZE = 16;
	private Frame frame = new Frame("Game - PinBall");
	Random rand = new Random();
	private int ballSpeedAtVertical = 10;
	private double ballSpeedRatio = rand.nextDouble() - 0.5;
	private int ballSpeedAtHorizen = (int) (ballSpeedAtVertical * ballSpeedRatio
	        * 2);
	private int ballAxisX = rand.nextInt(200) + 20;
	private int ballAxisY = rand.nextInt(10) + 20;
	private int racketAxisX = rand.nextInt(200);
	private MyCanvas tableArea = new MyCanvas();
	Timer timer;
	private boolean isLose = false;
	public void init()
	{
		tableArea.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
		frame.add(tableArea);
		KeyAdapter keyProcessor = new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke)
			{
				if (ke.getKeyCode() == KeyEvent.VK_LEFT)
				{
					if (racketAxisX > 10)
						racketAxisX -= 10;
				}
				if (ke.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					if (racketAxisX < TABLE_WIDTH - RACKET_WIDTH)
						racketAxisX += 10;
				}
			}
		};
		frame.addKeyListener(keyProcessor);
		tableArea.addKeyListener(keyProcessor);
		ActionListener taskPerformer = e ->
		{
			if (ballAxisX <= 0 || ballAxisX >= TABLE_WIDTH - BALL_SIZE)
			{
				ballSpeedAtHorizen = -ballSpeedAtHorizen;
			}
			if ((ballAxisY >= RACKET_Y - BALL_SIZE) && (ballAxisY < racketAxisX
		            || ballAxisX > racketAxisX + RACKET_WIDTH))
			{
				timer.stop();
				isLose = true;
				tableArea.repaint();
			} else
		        if (ballAxisY <= 0 || (ballAxisY >= RACKET_Y - BALL_SIZE
		                && ballAxisX > racketAxisX
		                && ballAxisX <= racketAxisX + RACKET_WIDTH))
			{
				ballSpeedAtVertical = -ballSpeedAtVertical;
			}
			ballAxisY += ballSpeedAtVertical;
			ballAxisX += ballSpeedAtHorizen;
			tableArea.repaint();
		};
		timer = new Timer(100, taskPerformer);
		
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		timer.start();
		frame.pack();
		frame.setVisible(true);
	}

	class MyCanvas extends Canvas
	{
		public void paint(Graphics g)
		{
			if (isLose)
			{
				g.setColor(new Color(255, 0, 0));
				g.setFont(new Font("Times", Font.BOLD, 30));
				g.drawString("Game Over", 50, 200);
			} else
			{
				g.setColor(new Color(0, 240, 80));
				g.fillOval(ballAxisX, ballAxisY, BALL_SIZE, BALL_SIZE);
				g.setColor(new Color(80, 80, 200));
				g.fillRect(racketAxisX, RACKET_Y, RACKET_WIDTH, RACKET_HEIGHT);
			}
		}
	}
	
	public static void main(String[] args)
	{
		new testAppGamePinBall().init();
	}
}
