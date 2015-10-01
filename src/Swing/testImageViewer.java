package Swing;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.beans.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;

public class testImageViewer
{
	final int PREVIEW_SIZE = 100;
	JFrame jf = new JFrame("testImageViewer");
	JMenuBar menuBar = new JMenuBar();
	//该label用于显示图片
	JLabel label = new JLabel();
	//以当前路径创建文件选择器
	JFileChooser chooser = new JFileChooser(".");
	JLabel accessory = new JLabel();
	ExtensionFileFilter filter = new ExtensionFileFilter();
	public void init()
	{
		//-------------------下面开始初始化JFileChooser的相关属性-----------------
		// 创建一个FileFilter
		filter.addExtension("jpg");
		filter.addExtension("jpeg");
		filter.addExtension("gif");
		filter.addExtension("png");
		filter.setDescription("图片文件(*.jpg,*.jpeg,*.gif,*.png)");
		chooser.addChoosableFileFilter(filter);
		//禁止“文件类型”下拉列表中显示“所有文件”选项。
		chooser.setAcceptAllFileFilterUsed(false); 
		//为文件选择器指定自定义的FileView对象
		chooser.setFileView(new FileIconView(filter));
		//为文件选择器指定一个预览图片的附件组件
		chooser.setAccessory(accessory);
		//设置预览图片组件的大小和边框
		accessory.setPreferredSize(new Dimension(PREVIEW_SIZE, PREVIEW_SIZE));
		accessory.setBorder(BorderFactory.createEtchedBorder());
		//用于检测被选择文件的改变事件
		chooser.addPropertyChangeListener(new PropertyChangeListener()
		{
			public void propertyChange(PropertyChangeEvent event) 
			{
				//JFileChooser的被选文件已经发生了改变
				if (event.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)
				{
					//获取用户选择的新文件 
					File f = (File) event.getNewValue();
					if (f == null)
					{ 
						accessory.setIcon(null); 
						return; 
					}
					//将所文件读入ImageIcon对象中
					ImageIcon icon = new ImageIcon(f.getPath());
					//如果图像太大，则缩小它
					if(icon.getIconWidth() > PREVIEW_SIZE)
					{	
						icon = new ImageIcon(icon.getImage()
							.getScaledInstance(PREVIEW_SIZE, -1, Image.SCALE_DEFAULT));
					}
					//改变accessory Label的图标
					accessory.setIcon(icon);
				}
			}
		});

		//----------下面代码开始为该窗口安装菜单------------
		JMenu menu = new JMenu("文件");
		menuBar.add(menu);
		JMenuItem openItem = new JMenuItem("打开");
		menu.add(openItem);
		//单击openItem菜单项显示“打开文件”的对话框
		openItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//设置文件对话框的当前路径
				//chooser.setCurrentDirectory(new File("."));
				//显示文件对话框
				int result = chooser.showDialog(jf , "打开图片文件");
				//如果用户选择了APPROVE（赞同）按钮，即打开，保存及其等效按钮
				if(result == JFileChooser.APPROVE_OPTION)
				{
					String name = chooser.getSelectedFile().getPath();
					//显示指定图片
					label.setIcon(new ImageIcon(name));
				}
			}
		});
		JMenuItem exitItem = new JMenuItem("退出");
		menu.add(exitItem);
		exitItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		});
		jf.setJMenuBar(menuBar);
		//添加用于显示图片的JLabel组件。
		jf.add(new JScrollPane(label));
		jf.setSize(500, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

	public static void main(String[] args)
	{
		new testImageViewer().init();
	}
}

//创建FileFilter的子类，用以实现文件过滤功能
class ExtensionFileFilter extends FileFilter
{

	private String description = "";
	private ArrayList<String> extensions = new ArrayList<String>();
	//自定义方法，用于添加文件扩展名
	public void addExtension(String extension)
	{
		if (!extension.startsWith("."))
		{
			extension = "." + extension;
			extensions.add(extension.toLowerCase());
		}
	}
	//用于设置该文件过滤器的描述文本
	public void setDescription(String aDescription)
	{
		description = aDescription;
	}
	//继承FileFilter类必须实现的抽象方法，返回该文件过滤器的描述文本
	public String getDescription()
	{
		return description; 
	}
	//继承FileFilter类必须实现的抽象方法，判断该文件过滤器是否接受该文件
	public boolean accept(File f)
	{
		//如果该文件是路径，接受该文件
		if (f.isDirectory()) return true;
		//将文件名转为小写（全部转为小写后比较，用于忽略文件名大小写）
		String name = f.getName().toLowerCase();
		//遍历所有可接受的扩展名，如果扩展名相同，该文件就可接受。
		for (String extension : extensions)
		{
			if (name.endsWith(extension)) 
			{
				return true;
			}
		}
		return false;
	}
}
//自定义一个FileView类，用于为指定类型的指定图标
class FileIconView extends FileView
{
	private FileFilter filter;
	public FileIconView(FileFilter filter)
	{
		this.filter = filter;
	}
	//如果文件不是目录，并且不是
	public Icon getIcon(File f)
	{
		if (!f.isDirectory() && filter.accept(f))
		{
			return new ImageIcon("ico/pict.png");
		}
		else if (f.isDirectory())
		{
			//获取所有根路径
			File[] fList = File.listRoots();
			for (File tmp : fList)
			{
				//如果该路径是根路径
				if (tmp.equals(f))
				{
					return  new ImageIcon("ico/dsk.png");
				}
			}
			return new ImageIcon("ico/folder.png");
		}
		//使用默认图标
		else
		{
			return null;
		}
	}
}