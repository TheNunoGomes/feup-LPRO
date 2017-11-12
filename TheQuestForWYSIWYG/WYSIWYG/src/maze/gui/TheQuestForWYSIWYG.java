package maze.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dkeep.logic.Dragon;
import dkeep.logic.GameState;
import dkeep.logic.Map;

public class TheQuestForWYSIWYG {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblJlabel = new JLabel("Nuno Gomes");
	private JButton btnUp = new JButton("Up");
	private JButton btnLeft = new JButton("Left");
	private JButton btnRight = new JButton("Right");
	private JButton btnDown = new JButton("Down");
	public static Map mapa;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		mapa = new Map();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TheQuestForWYSIWYG window = new TheQuestForWYSIWYG();
					window.frame.setSize(1000, 780);
					window.frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TheQuestForWYSIWYG() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 566, 517);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Number of Dragons:");
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblDragonMovement = new JLabel("Dragon Movement:");
		panel.add(lblDragonMovement);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Random", "Still"}));
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
		
		lblJlabel.setFont(new Font("Consolas", Font.PLAIN, 30));
		panel_1.add(lblJlabel);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.EAST);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{50, 50, 50, 50, 0};
		gbl_panel_2.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);

		btnUp.setEnabled(false);
		btnLeft.setEnabled(false);
		btnRight.setEnabled(false);
		btnDown.setEnabled(false);
		
		JButton btnNewGame = new JButton("New Game");
		GridBagConstraints gbc_btnNewGame = new GridBagConstraints();
		gbc_btnNewGame.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewGame.gridx = 0;
		gbc_btnNewGame.gridy = 0;
		panel_2.add(btnNewGame, gbc_btnNewGame);
		
		GridBagConstraints gbc_btnUp = new GridBagConstraints();
		gbc_btnUp.fill = GridBagConstraints.BOTH;
		gbc_btnUp.insets = new Insets(0, 0, 5, 5);
		gbc_btnUp.gridx = 2;
		gbc_btnUp.gridy = 6;
		panel_2.add(btnUp, gbc_btnUp);
		
		GridBagConstraints gbc_btnLeft = new GridBagConstraints();
		gbc_btnLeft.fill = GridBagConstraints.VERTICAL;
		gbc_btnLeft.anchor = GridBagConstraints.EAST;
		gbc_btnLeft.insets = new Insets(0, 0, 5, 5);
		gbc_btnLeft.gridx = 1;
		gbc_btnLeft.gridy = 7;
		panel_2.add(btnLeft, gbc_btnLeft);
		
		GridBagConstraints gbc_btnRight = new GridBagConstraints();
		gbc_btnRight.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRight.insets = new Insets(0, 0, 5, 0);
		gbc_btnRight.gridx = 3;
		gbc_btnRight.gridy = 7;
		panel_2.add(btnRight, gbc_btnRight);
		
		GridBagConstraints gbc_btnDown = new GridBagConstraints();
		gbc_btnDown.fill = GridBagConstraints.BOTH;
		gbc_btnDown.insets = new Insets(0, 0, 5, 5);
		gbc_btnDown.gridx = 2;
		gbc_btnDown.gridy = 8;
		panel_2.add(btnDown, gbc_btnDown);
		
		JButton btnExit = new JButton("Exit");
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnExit.insets = new Insets(0, 0, 5, 5);
		gbc_btnExit.anchor = GridBagConstraints.NORTH;
		gbc_btnExit.gridx = 0;
		gbc_btnExit.gridy = 12;
		panel_2.add(btnExit, gbc_btnExit);
		
		JPanel panel_4 = new GraphicPanel(this);
		frame.getContentPane().add(panel_4, BorderLayout.CENTER);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{717, 0};
		gbl_panel_4.rowHeights = new int[]{396, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText() == "")
					lblJlabel.setText("Insert number of Dragons!");
				else {
					int numDragon = Integer.parseInt(textField.getText()); //getInput();
					if(numDragon < 15 && numDragon > 0)
					{
						btnUp.setEnabled(true);
						btnLeft.setEnabled(true);
						btnDown.setEnabled(true);
						btnRight.setEnabled(true);
						mapa = new Map();
						mapa.newGame(numDragon);
						updateMap();
						forceRepaint(panel_4);
						lblJlabel.setText("GOOD LUCK!");
					}
					else
						lblJlabel.setText("Invalid number of Dragons!");
				}
			}
		});
		
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblJlabel.setText("");
				String com = "w";
				int[] nextPos = getPos(com, mapa);	//process input
				while(com == "w") {
					if (nextPos[0] == -1 || nextPos[1] == -1)		//test for invalid commands
						continue;
					if(updateHero(nextPos)) {						//Hero moves
						//callMovement(mapa, com);
						updateMap();								//refresh screen
						forceRepaint(panel_4);
						//cicle through
						mapa.validDragons();								//Test hero for adj dragon
						if(mapa.testGame() || mapa.testWin())		//Test win/lose conditions
							break;
						//Cicle through array
						if(comboBox.getSelectedItem() == "Random")
							updateDragons();		//Move dragons	
						mapa.validDragons();
					}
					updateMap();
					forceRepaint(panel_4);
					mapa.printOut();
					if(mapa.testGame() || mapa.testWin())		   		//Test win/lose conditions
						break;
					com = " ";
				}
				if(mapa.testGame()) {
					btnUp.setEnabled(false);
					btnLeft.setEnabled(false);
					btnRight.setEnabled(false);
					btnDown.setEnabled(false);
					lblJlabel.setText("YOU DIED!");
				}
			}
		});
		
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblJlabel.setText("");
				String com = "a";
				int[] nextPos = getPos(com, mapa);	//process input
				while(com == "a") {
					if (nextPos[0] == -1 || nextPos[1] == -1)		//test for invalid commands
						continue;
					if(updateHero(nextPos)) {						//Hero moves
						//callMovement(mapa, com);
						updateMap();								//refresh screen
						forceRepaint(panel_4);
						//cicle through
						mapa.validDragons();						//Test hero for adj dragon
						if(mapa.testGame() || mapa.testWin())		//Test win/lose conditions
							break;
						//Cicle through array
						if(comboBox.getSelectedItem() == "Random")
							updateDragons();		//Move dragons	
						mapa.validDragons();
					}
					updateMap();
					forceRepaint(panel_4);
					mapa.printOut();
					if(mapa.testGame() || mapa.testWin())		   		//Test win/lose conditions
						break;
					com = " ";
				}
				if(mapa.testGame()) {
					btnUp.setEnabled(false);
					btnLeft.setEnabled(false);
					btnRight.setEnabled(false);
					btnDown.setEnabled(false);
					lblJlabel.setText("YOU DIED!");
				}
			}
		});
		
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblJlabel.setText("");
				String com = "s";
				int[] nextPos = getPos(com, mapa);	//process input
				while(com == "s") {
					if (nextPos[0] == -1 || nextPos[1] == -1)		//test for invalid commands
						continue;
					if(updateHero(nextPos)) {						//Hero moves
						//callMovement(mapa, com);
						updateMap();	
						forceRepaint(panel_4);							//refresh screen
						//cicle through
						mapa.validDragons();								//Test hero for adj dragon
						if(mapa.testGame() || mapa.testWin())		//Test win/lose conditions
							break;
						//Cicle through array
						if(comboBox.getSelectedItem() == "Random")
							updateDragons();		//Move dragons	
						mapa.validDragons();
					}
					updateMap();
					forceRepaint(panel_4);
					mapa.printOut();
					if(mapa.testGame() || mapa.testWin())		   		//Test win/lose conditions
						break;
					com = " ";
				}
				if(mapa.testGame()) {
					btnUp.setEnabled(false);
					btnLeft.setEnabled(false);
					btnRight.setEnabled(false);
					btnDown.setEnabled(false);
					lblJlabel.setText("YOU DIED!");
				}
			}
		});
		
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblJlabel.setText("");
				String com = "d";
				int[] nextPos = getPos(com, mapa);	//process input
				while(com == "d") {
					if (nextPos[0] == -1 || nextPos[1] == -1)		//test for invalid commands
						continue;
					if(updateHero(nextPos)) {						//Hero moves
						//callMovement(mapa, com);
						updateMap();
						forceRepaint(panel_4);								//refresh screen
						//cicle through
						mapa.validDragons();								//Test hero for adj dragon
						if(mapa.testGame() || mapa.testWin())		//Test win/lose conditions
							break;
						//Cicle through array
						if(comboBox.getSelectedItem() == "Random")
							updateDragons();		//Move dragons
						mapa.validDragons();
					}
					updateMap();
					forceRepaint(panel_4);
					mapa.printOut();
					if(mapa.testGame() || mapa.testWin())		   		//Test win/lose conditions
						break;
					com = " ";
				}
				if(mapa.testGame() || mapa.testWin()) {
					btnUp.setEnabled(false);
					btnLeft.setEnabled(false);
					btnRight.setEnabled(false);
					btnDown.setEnabled(false);
					lblJlabel.setText("YOU DIED!");
				}
				if(mapa.testGame())
					lblJlabel.setText("YOU DIED!");
				if(mapa.testWin())
					lblJlabel.setText("YOU WIN!");
			}
		});
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}
	public String printMap(JPanel tArea) {
		int row, column;
		String rowS = new String();
		int v[] = new int[2];
		for(row = 0; row < 10; row++) {
			for(column = 0; column < 10; column++) {
				v[0] = row;
				v[1] = column;
				rowS += mapa.getChar(v).getSymb() + " ";
			}
			rowS += "\n";
		}
		return rowS;
	}
	public static void updateMap() {
		mapa.getMap().printMap();
	}
	public static int[] getPos(String com, GameState map) {	
		int next_row = map.getHero().getCoord()[0], next_col = map.getHero().getCoord()[1];
		int curr_row = next_row, curr_col = next_col;
		switch(com) {
		case "W": 
		case "w":	next_row = curr_row - 1;
		break;
		case "S":
		case "s":	next_row = curr_row + 1;
		break;
		case "A":
		case "a":	next_col = curr_col - 1;
		break;
		case "D":
		case "d":	next_col = curr_col + 1;
		break;
		default: System.out.println("Unknown"); next_row = -1; next_col = -1;
		}
		return (new int[] {next_row,next_col});
	}
	public static void updateDragons() {
		Iterator<Dragon> it = mapa.getList().iterator();
		Random rand = new Random();
		for(Dragon index : mapa.getList()) {
			index = it.next();
			if(rand.nextInt(99) < 25) 
				index.changeSleep();
			else if (mapa.getDrag(index).getAlive() && !mapa.getDrag(index).checkSleep()) 				//Move Dragon if alive
				mapa.dragonMove(index);
		}
	}
	public static boolean updateHero(int[] nextPos) {
		return mapa.testMove(mapa.getMap().getHero(), nextPos);
	}
	public static int getInput() {
		Scanner scan = new Scanner(System.in);
		int numDragon = 0;
		while(true) {
			System.out.print("Input number of dragons: ");
			numDragon = scan.nextInt();
			if(numDragon > 0 && numDragon < 15)	break;
			System.out.println("Invalid number of dragons, 15 > dragons > 0");
		}
		return numDragon;
	}
	/*public void callMovement(Map mapa, String com) {
		if(!mapa.testChar(getPos(com, mapa), 'X'));
				lblJlabel.setText("Wall");
		if(!mapa.testChar(getPos(com, mapa), 'E'))
			if(!mapa.getMap().getHero().getKey())
				lblJlabel.setText("Key Missing");
		if(!mapa.getMap().getHero().getArmed() && !mapa.testChar(getPos(com, mapa), 'd','f'))
			lblJlabel.setText("Don't wake the dragon");
		if (!mapa.testChar(getPos(com, mapa), 'S'))
			lblJlabel.setText("Sword picked up!");
		else
			lblJlabel.setText(" ");
	}*/
	public void forceRepaint(JPanel panel) {
		panel.validate();
		panel.repaint();
		frame.validate();
		frame.repaint();
	}
}