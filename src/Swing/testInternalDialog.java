package Swing;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class testInternalDialog
{
	private JFrame jf = new JFrame("�����ڲ��Ի���");
	private JDesktopPane desktop = new JDesktopPane();
	private JButton internalBn = new JButton("�ڲ����ڵĶԻ���");
	private JButton deskBn = new JButton("��������ĶԻ���");
	//����һ���ڲ����ڣ��ô��ڿ��϶�����������󻯡���С�����ر�
	private JInternalFrame iframe = new JInternalFrame("�ڲ�����");
	
	public void init()
	{
		//���ڲ�������������
		iframe.add(new JScrollPane(new JTextArea(8, 40)));
		desktop.setPreferredSize(new Dimension(400, 300));
		//������������ӵ�JFrame������
		jf.add(desktop);
		//�����ڲ����ڵĴ�С��λ��
		iframe.reshape(0 , 0 , 300 , 200);
		//��ʾ��ѡ���ڲ�����
		iframe.show();
		desktop.add(iframe);
		JPanel jp = new JPanel();
		deskBn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//�����ڲ��Ի���������������Ϊ�����
				JOptionPane.showInternalMessageDialog(desktop,
					"������������ĶԻ���");
			}
		});
		internalBn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//�����ڲ��Ի������ڲ�������Ϊ�����
				JOptionPane.showInternalMessageDialog(iframe,
					"�����ڲ����ڵĶԻ���");
			}
		});
		jp.add(deskBn);
		jp.add(internalBn);
		jf.add(jp , BorderLayout.SOUTH);
		jf.pack();
		jf.setVisible(true);

	}
	public static void main(String[] args) 
	{
		new testInternalDialog().init();
	}
}

