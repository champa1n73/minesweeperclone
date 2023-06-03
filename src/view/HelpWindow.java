package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HelpWindow implements ActionListener{

	JButton clearButton = new JButton();
	JFrame frame = new JFrame();
	JLabel background = new JLabel("",new ImageIcon("GuideUI.png"), JLabel.CENTER);

	HelpWindow(){
		
		clearButton.setBounds(280, 590, 80, 30);
		clearButton.setFocusable(true);
		clearButton.setVisible(true);
		clearButton.setIcon(new ImageIcon("clearButton.png"));
		clearButton.addActionListener(this);
		
		background.setBounds(0, 0, 376, 626);
		
		frame.add(clearButton);
		frame.add(background);
		frame.setSize(390,660);
		frame.setResizable(false);
		frame.setLayout(null);;
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Guide");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == clearButton) {
			frame.dispose();
		}
	
	}
}
