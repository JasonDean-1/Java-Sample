package AWT;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

import javax.swing.BoxLayout;

public class testLayout
{
	static void flowLayout(Frame frame)
	{
		frame.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
		for (int i = 0; i < 10; i++)
		{
			frame.add(new Button("hit me " + (i + 1)));
		}
	}
	static void borderLayout(Frame frame)
	{
		frame.setLayout(new BorderLayout(30, 5));
		frame.add(new Button("Up"), BorderLayout.NORTH);
		frame.add(new Button("Down"), BorderLayout.SOUTH);
		frame.add(new Button("Left"), BorderLayout.WEST);
		frame.add(new Button("Right"), BorderLayout.EAST);
		frame.add(new Button("Center"), BorderLayout.CENTER);
	}
	static void boxLayout(Frame frame)
	{
		frame.setLayout(new BoxLayout(frame, BoxLayout.X_AXIS));
		frame.add(new Button("First Button"));
		frame.add(new Button("Second Button"));
		
	}
	
	static void cardLayout(Frame frame)//ÓÐBUG
	{
		Panel panel = new Panel();
		final CardLayout cardLayout =new CardLayout();
		String[] cards ={"card1","card2","card3","card4"};
		panel.setLayout(cardLayout);
		for( int i = 0;i<cards.length;i++)
		{
			panel.add(cards[i], new Button(cards[i]));
		}
		Panel panel2=new Panel();
		ActionListener actionListener = e->
		{
			switch (e.getActionCommand())
			{
				case "previous" :
					cardLayout.previous(panel);
					break;
				case "next" :
					cardLayout.next(panel);
					break;
				default :
					break;
			}
		};
		Button previous = new Button("previsous button");
		Button next = new Button("next button");
		previous.addActionListener(actionListener);
		next.addActionListener(actionListener);
		panel2.add(previous);
		panel2.add(next);
		frame.add(panel);
		frame.add(panel2);
		
	}
	
	static void gridLayout(Frame frame)
	{
		frame.setLayout(new GridLayout(3, 5, 4, 4));
		String[] calc = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
		        "+", "-", "*", "/", "."};
		Panel panel = new Panel();
		Panel panel2 = new Panel();
		panel2.setLayout(new GridLayout(3, 5,3,3));
		panel.add(new TextField(30));
		frame.add(panel, BorderLayout.NORTH);
		for(int i=0;i<calc.length;i++)
		{
			panel2.add(new Button(calc[i]));
		}
		frame.add(panel2);
		
	}
	static void gridBagConstraints(Frame frame)
	{
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		GridBagLayout gridBagLayout = new GridBagLayout();
		Button[] buttons = new Button[10];
		frame.setLayout(gridBagLayout);
		
		for(int i =0;i<buttons.length;i++)
		{
			buttons[i]=new Button("Hit Me"+i);
		}
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.weightx=1;
		for(int i=0;i<4;i++)
		{
			gridBagLayout.setConstraints(buttons[i], gridBagConstraints);
			frame.add(buttons[i]);
		}
		gridBagConstraints.gridwidth=GridBagConstraints.REMAINDER;
		for(int i=6;i<8;i++)
		{
			gridBagLayout.setConstraints(buttons[i], gridBagConstraints);
			frame.add(buttons[i]);
		}
		gridBagConstraints.weightx=0;
		for(int i=8;i<9;i++)
		{
			gridBagLayout.setConstraints(buttons[i], gridBagConstraints);
			frame.add(buttons[i]);
		}
	}


	
	
	public static void main(String[] args)
	{
		Frame frame = new Frame("test");
		//flowLayout(frame);
		//borderLayout(frame);
		boxLayout(frame);
		//cardLayout(frame);
		//gridLayout(frame);
		//gridBagConstraints(frame);
		frame.pack();
		frame.setVisible(true);
	}
}
