package Swing;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.applet.*;
import javax.swing.event.*;


public class testAppletAudio extends JApplet
{
	//定义一个音频对象
	AudioClip audioClip;
	JList audioList;
	//定义三个按钮
	JButton buttonPlay;
	JButton buttonLoop;
	JButton buttonStop;

	public void init()
	{
		java.util.ArrayList<String> musicList = new java.util.ArrayList<String>();
		int i = 1;
		//采用循环加载该Applet的所有参数
		while(true)
		{	
			String musicName = getParameter(i++ + "");
			if (musicName == null)
			{
				break;
			}
			else
			{
				musicList.add(musicName);
			}
		}
		String[] musicNames = new String[musicList.size()];
		musicNames = musicList.toArray(musicNames);
		audioList = new JList(musicNames);
		//默认加载第一首音乐
		audioClip = getAudioClip(getCodeBase() , "music/" + musicNames[0] + ".mid");
		buttonPlay = new JButton("开始播放");
		buttonLoop = new JButton("循环播放");
		buttonStop = new JButton("停止播放");
		//为三个按钮和audioList添加事件监听器
		buttonPlay.addActionListener(new PlayListener());
		buttonLoop.addActionListener(new PlayListener());
		buttonStop.addActionListener(new PlayListener());
		audioList.addMouseListener(new ChangeMusicListener());
		audioList.setPreferredSize(new Dimension(240 , 400));
		add(new JScrollPane(audioList));
		JPanel jp = new JPanel();
		jp.add(buttonPlay);
		jp.add(buttonLoop);
		jp.add(buttonStop);
		add(jp , BorderLayout.SOUTH);
	}
	//定义用于三个按钮的监听器
	class PlayListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//根据按钮来决定对音频文件播放、暂停和循环播放
			if (e.getSource() == buttonPlay)
			{
				if (audioClip != null)
				{
					audioClip.stop();
				}
				audioClip = getSelectedAudioClip();
				audioClip.play();
			}
			else if(e.getSource() == buttonLoop)
			{
				if (audioClip != null)
				{
					audioClip.stop();
				}
				audioClip = getSelectedAudioClip();
				audioClip.loop();
			}
			else if (e.getSource() == buttonStop)
			{
				audioClip.stop();
			}
		}
	}
	//实现JList上的鼠标动作监听器
	class ChangeMusicListener extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e)
		{
			if (e.getClickCount() >= 2)
			{
				if (audioClip != null)
				{
					audioClip.stop();
				}
				audioClip = getSelectedAudioClip();
				audioClip.play();
			}
		}
	}
	//返回JList中当前选中项对应的音频对象
	private AudioClip getSelectedAudioClip()
	{
		String selected = audioList.getSelectedValue().toString();
		//返回以当前选中项创建的音频对象
		return getAudioClip(getCodeBase() , "music/"
			+ selected + ".mid");
	}
}
