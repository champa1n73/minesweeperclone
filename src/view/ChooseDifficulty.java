package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ChooseDifficulty implements ActionListener{

	JButton Easy = new JButton();
	JButton Normal = new JButton();
	JButton Hard = new JButton();
	JFrame frame = new JFrame();
	JLabel background = new JLabel("",new ImageIcon("background.png"), JLabel.CENTER);
//	JLabel peepoFlagEasy = new JLabel("",new ImageIcon("peepoflag.gif"), JLabel.CENTER);
//	JLabel peepoFlagNormal = new JLabel("",new ImageIcon("peepoflag.gif"), JLabel.CENTER);
//	JLabel peepoFlagHard = new JLabel("",new ImageIcon("peepoflag.gif"), JLabel.CENTER);
	
	ChooseDifficulty(){
		
		Easy.setBounds(75,150,250,80);
		Easy.setFocusable(true);
		Easy.setVisible(true);
		Easy.setIcon(new ImageIcon("easy.png"));
		Easy.addActionListener(this);
		
		Normal.setBounds(375,150,250,80);
		Normal.setFocusable(true);
		Normal.setVisible(true);
		Normal.setIcon(new ImageIcon("normal.png"));
		Normal.addActionListener(this);
		
		Hard.setBounds(675,150,250,80);
		Hard.setFocusable(true);
		Hard.setVisible(true);
		Hard.setIcon(new ImageIcon("hard.png"));
		Hard.addActionListener(this);
		
		background.setBounds(0, 0, 1000, 563);
//		peepoFlagEasy.setBounds(135,240,128,128);
//		peepoFlagNormal.setBounds(435,240,128,128);
//		peepoFlagHard.setBounds(735,240,128,128);
		
		frame.add(Easy);
		frame.add(Normal);
		frame.add(Hard);
		frame.add(background);
//		frame.add(peepoFlagEasy);
//		frame.add(peepoFlagNormal);
//		frame.add(peepoFlagHard);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,563);
		frame.setResizable(false);
		frame.setLayout(null);;
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setTitle("MineSweeper");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == Easy) {
			frame.dispose();
			new GameFrame(8, 8, 3);
		}
		
		if(e.getSource() == Normal) {
			frame.dispose();
			new GameFrame(16, 16, 40);
		}
		
		if(e.getSource() == Hard) {
			frame.dispose();
			new GameFrame(20, 30, 99);
		}

		
	}

}
