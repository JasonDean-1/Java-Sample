package Swing;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.math.BigDecimal;


public class testListModel
{
	private JFrame mainWin = new JFrame("测试ListModel");
	//根据NumberListModel对象来创建一个JList对象
	private JList numScopeList = new JList(
		new NumberListModel(1 , 21 , 2));
	//根据NumberComboBoxModel对象来创建JComboBox对象
	private JComboBox numScopeSelector = new JComboBox(
		new NumberComboBoxModel(0.1 , 1.2 , 0.1));
	private JTextField showVal = new JTextField(10);

	public void init()
	{
		//JList的可视高度可同时显示4个列表项
		numScopeList.setVisibleRowCount(4); 
		//默认选中第三项到第五项（第一项的索引是0）
		numScopeList.setSelectionInterval(2, 4);
		//设置每个列表项具有指定的高度和宽度。
		numScopeList.setFixedCellHeight(30);
		numScopeList.setFixedCellWidth(90);
		//为numScopeList添加监听器
		numScopeList.addListSelectionListener(new ListSelectionListener()
		{
			public void  valueChanged(ListSelectionEvent e)
			{
				//获取用户所选中的所有数字
				Object[] nums = numScopeList.getSelectedValues();
				showVal.setText("");
				//把用户选中的数字添加到单行文本框中
				for (Object num : nums )
				{
					showVal.setText(showVal.getText() + num.toString() + " , ");
				}
			}
		});		
		//设置列表项的可视高度可显示5个列表项
		numScopeSelector.setMaximumRowCount(5); 
		Box box = new Box(BoxLayout.X_AXIS);
		box.add(new JScrollPane(numScopeList));
		JPanel p = new JPanel();
		p.add(numScopeSelector);
		box.add(p);
		//为numScopeSelector添加监听器
		numScopeSelector.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				//获取JComboBox所选中的数字
				Object num = numScopeSelector.getSelectedItem();
				showVal.setText(num.toString());
			}
		});

		JPanel bottom = new JPanel();
		bottom.add(new JLabel("您选择的值是："));
		bottom.add(showVal);

		mainWin.add(box);
		mainWin.add(bottom , BorderLayout.SOUTH);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);

	}
	public static void main(String[] args) 
	{
		new testListModel().init();
	}
}

class NumberListModel extends AbstractListModel
{
	protected BigDecimal start;
	protected BigDecimal end;
	protected BigDecimal step;
	public NumberListModel(double start , double end , double step)
	{
		this.start = BigDecimal.valueOf(start);
		this.end = BigDecimal.valueOf(end);
		this.step = BigDecimal.valueOf(step);
	}
	//返回列表项的个数
	public int getSize()
	{
		return (int)Math.floor(end.subtract(start).divide(step)
			.doubleValue()) + 1;
	}
	//返回指定索引处的列表项
	public Object getElementAt(int index)
	{
		return BigDecimal.valueOf(index).multiply(step).add(start);
	}
}

class NumberComboBoxModel extends NumberListModel
	implements ComboBoxModel
{
	//用于保存用户选中项的索引
	private int selectId = 0;
	public NumberComboBoxModel(double start , double end , double step)
	{
		super(start , end , step);
	}

	//设置选中“选择项”
  	public void setSelectedItem(Object anItem)
	{
		if (anItem instanceof BigDecimal)
		{
			BigDecimal target = (BigDecimal)anItem;
			//根据选中的值来修改选中项的索引
			selectId = target.subtract(super.start).divide(step).intValue();
		}
	}
	//获取“选择项”的值
  	public Object getSelectedItem()
	{
		//根据选中项的索引来取得选中项
		return BigDecimal.valueOf(selectId).multiply(step).add(start);
	}
}