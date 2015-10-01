package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.Box;

public class testCommonComponent
{
	Frame frame = new Frame();
	Button buttonOK = new Button("OK");
	CheckboxGroup checkBoxGroup = new CheckboxGroup();
	Checkbox male = new Checkbox("man", checkBoxGroup, true);
	Checkbox female = new Checkbox("woman", checkBoxGroup, true);
	Checkbox married = new Checkbox("Married?", false);
	Choice colorChooser = new Choice();
	List colorList = new List(6, true);
	TextArea textArea = new TextArea(5, 20);
	TextField textFieldName = new TextField(50);

	public void init()
	{
		colorChooser.add("Red");
		colorChooser.add("Green");
		colorChooser.add("Blue");
		colorList.add("Red");
		colorList.add("Green");
		colorList.add("Blue");
		Panel bottomPanel = new Panel();
		bottomPanel.add(textFieldName);
		bottomPanel.add(buttonOK);
		frame.add(bottomPanel, BorderLayout.SOUTH);
		Panel checkPanel = new Panel();
		checkPanel.add(colorChooser);
		checkPanel.add(male);
		checkPanel.add(female);
		checkPanel.add(married);

		Box topLeftBox = Box.createVerticalBox();
		topLeftBox.add(textArea);
		topLeftBox.add(checkPanel);

		Box topBox = Box.createHorizontalBox();
		topBox.add(topLeftBox);
		topBox.add(colorList);
		frame.add(topBox);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args)
	{
		new testCommonComponent().init();
	}
}
