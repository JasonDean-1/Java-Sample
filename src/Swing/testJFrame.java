package Swing;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class testJFrame
{
	JFrame frame = new JFrame("Test");
	Icon okIcon = new ImageIcon("ico/ok.png");
	JButton okButton = new JButton("OK");
	JRadioButton maleRadioButton = new JRadioButton("Male", true);
	JRadioButton femaleRadioButton = new JRadioButton("Female", false);
	ButtonGroup buttonGroup = new ButtonGroup();
	JCheckBox marriedCheckBox = new JCheckBox("married?", false);
	String[] colors = new String[]{"Red", "Green", "Blue"};
	JComboBox<String> colorComboBox = new JComboBox<>(colors);
	JList<String> colorList = new JList<>(colors);
	JTextArea textArea = new JTextArea(8,20);
	JTextField nameTextField = new JTextField(40);
	JMenuBar menuBar = new JMenuBar();
	JMenu fileMenu = new JMenu("File");
	JMenu editMenu = new JMenu("Edit");
	Icon newIcon = new ImageIcon("ico/new.png");
	Icon saveIcon = new ImageIcon("ico/save.png");
	Icon exitIcon = new ImageIcon("ico/exit.png");
	Icon copyIcon = new ImageIcon("ico/copy.png");
	Icon pasteIcon = new ImageIcon("ico/paste.png");

	JMenuItem newItem = new JMenuItem("New",newIcon);
	JMenuItem saveItem = new JMenuItem("Save",saveIcon);
	JMenuItem exitItem = new JMenuItem("Exit",exitIcon);
			
			
			
			
			
			
			
			
			
}
