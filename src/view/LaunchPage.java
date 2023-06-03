package view;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LaunchPage implements ActionListener{
	
	JFrame frame = new JFrame();
	JButton playButton = new JButton();
	JButton exitButton = new JButton();
	JButton helpButton = new JButton();
	JLabel background = new JLabel("",new ImageIcon("background.png"), JLabel.CENTER);
	
	LaunchPage(){
		
		helpButton.setBounds(20, 20, 80, 30);
		helpButton.setFocusable(true);
		helpButton.addActionListener(this);
		helpButton.setIcon(new ImageIcon("helpbutton.png"));
		helpButton.setVisible(true);
		
		playButton.setBounds(375,100,250,80);
		playButton.setFocusable(true);
		playButton.addActionListener(this);
		playButton.setIcon(new ImageIcon("play.png"));
		playButton.setVisible(true);
		
		exitButton.setBounds(375,250,250,80);
		exitButton.setFocusable(true);
		exitButton.addActionListener(this);
		exitButton.setIcon(new ImageIcon("exit.png"));
		exitButton.setVisible(true);
		
		background.setBounds(0, 0, 1000, 563);
		
		frame.add(helpButton);
		frame.add(playButton);
		frame.add(exitButton);
		frame.add(background);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(1000,563);
		frame.setLayout(null);;
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setTitle("MineSweeper");
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == playButton) {
			frame.dispose();
			new ChooseDifficulty();
		}
		
		if(e.getSource() == exitButton) {
			System.exit(0);
		}
		
		if(e.getSource() == helpButton) {
			new HelpWindow();
		}

	}
	
}

