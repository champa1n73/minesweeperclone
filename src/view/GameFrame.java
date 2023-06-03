package view;
import java.util.Stack;
import java.util.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.LoadData;
import control.World;
import view.GamePanel;
public class GameFrame extends JFrame {

	/**
	 * 
	 */	
//	public enum GameState
//	{
//		Single,
//		Multi
//	}
//	public Stack<GameState> gameState = new Stack<GameState>();
	int i, j;
	public Stack<Integer> xStack = new Stack<>();
	public Stack<Integer> yStack = new Stack<>();
//	public Stack<ButtonPlay> stack = new Stack<>();
	public Stack<Integer> stack2 = new Stack<>();
	public int openCount = 0;
	public int singleUndo = 0;
	public static int move = 0;
	private static final long serialVersionUID = 1L;

	private LoadData loadData;
	private GamePanel gamePanel;

	private JMenuBar mnb;
	private JMenu menu;
	private JMenuItem basic, nomal, hard, newGame, back, undo;

	public GameFrame(int w, int h, int boom) {
		
		loadData = new LoadData();

		setJMenuBar(mnb = new JMenuBar());
		mnb.add(menu = new JMenu("Game"));

		menu.add(newGame = new JMenuItem("New game"));
		menu.addSeparator();
		menu.add(basic = new JMenuItem("Basic"));
		menu.add(nomal = new JMenuItem("Nomal"));
		menu.add(hard = new JMenuItem("Hard"));
		menu.addSeparator();
		menu.add(undo = new JMenuItem("Undo"));
		menu.addSeparator();
		menu.add(back = new JMenuItem("Back to Main Menu"));

		if (w == 8) {
			basic.setIcon(new ImageIcon(loadData.getListImage().get("tich")));
		} else if (w == 16) {
			nomal.setIcon(new ImageIcon(loadData.getListImage().get("tich")));
		} else {
			hard.setIcon(new ImageIcon(loadData.getListImage().get("tich")));
		}
		
		undo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!stack2.empty())
				{
					int counter = stack2.pop();
					if (counter > 1)
					{
						for (int l = 0; l < counter; l++)
						{
							if (!xStack.empty())
							{
								i = xStack.pop();
							}
							if (!yStack.empty())
							{
								j = yStack.pop();
							}
							
//							System.out.println(openCount);	
						gamePanel.world.arrayBoolean[i][j] = false;
						gamePanel.world.arrayButton[i][j].setNumber(-1);
						gamePanel.world.arrayButton[i][j].repaint();		
//						System.out.println("Multi undo at: " + i + " " + j);
						}	
					}
					else
					{
						if (!xStack.empty())
						{
							i = xStack.pop();
						}
						if (!yStack.empty())
						{
							j = yStack.pop();
						}
						
//						System.out.println(openCount);	
					gamePanel.world.arrayBoolean[i][j] = false;
					gamePanel.world.arrayButton[i][j].setNumber(-1);
					gamePanel.world.arrayButton[i][j].repaint();		
//					System.out.println("Multi undo at: " + i + " " + j);
					}
					
					move--;
				}						
				
		}
		}
		);

		
		basic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new GameFrame(8, 8, 10);
			}
		});

		nomal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new GameFrame(16, 16, 40);
			}
		});

		hard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new GameFrame(20, 30, 99);
			}
		});

		newGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new GameFrame(w, h, boom);
			}
		});

		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new LaunchPage();
			}
		});

		add(gamePanel = new GamePanel(w, h, boom, this));

		setIconImage(loadData.getListImage().get("title"));
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
//	public void MakeUndo(GameState GameState)
//	{
//		switch (GameState)
//		{
//		case Single:
//		{
//			if (singleUndo > 0)
//			{
//				if (!xStack.empty())
//				{
//					i = xStack.pop();
//				}
//				if (!yStack.empty())
//				{
//					j = yStack.pop();
//				}
//				gamePanel.world.arrayBoolean[i][j] = false;
//				gamePanel.world.arrayButton[i][j].setNumber(-1);
//				gamePanel.world.arrayButton[i][j].repaint();		
//				System.out.println("Single undo at: " + i + " " + j);
//				singleUndo--;
//			}
//			break;
//		}
//		case Multi:
//		{
//			for (int l = 0; l < openCount; l++)
//			{
//				if (!xStack.empty())
//				{
//					i = xStack.pop();
//				}
//				if (!yStack.empty())
//				{
//					j = yStack.pop();
//				}
//				
//				System.out.println(openCount);	
//			gamePanel.world.arrayBoolean[i][j] = false;
//			gamePanel.world.arrayButton[i][j].setNumber(-1);
//			gamePanel.world.arrayButton[i][j].repaint();		
//			}			
//			openCount = 0;
//		}
//	}
//}
	
	
	
	public void getPos(int i, int j) {
		xStack.push(i);
		yStack.push(j);
		openCount++;
	}
	
//	public void getPosForMulti(int i, int j) {
//		xStack.push(i);
//		yStack.push(j);
//		openCount++;
//		stack2.push(openCount);
//	}
//	public void getPosForSingle(int i, int j) {
//		xStack.push(i);
//		yStack.push(j);
//		singleUndo++;
//		
//	}
	
	
	public LoadData getLoadData() {
		return loadData;
	}

	public void setLoadData(LoadData loadData) {
		this.loadData = loadData;
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	

}
