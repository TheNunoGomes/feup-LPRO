package maze.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import dkeep.logic.Map;

public class GraphicPanel extends JPanel {
	protected BufferedImage wall;
	protected BufferedImage heroUnarmed;
	protected BufferedImage heroArmed;
	protected BufferedImage dragonAwake;
	protected BufferedImage dragonAsleep;
	protected BufferedImage sword;
	protected BufferedImage dragonOnSword;
	protected BufferedImage exitClosed;
	protected BufferedImage exitOpen;
	protected BufferedImage floor;
	protected BufferedImage error;
	private TheQuestForWYSIWYG gameWindow;
	
	public GraphicPanel(TheQuestForWYSIWYG window) {
		super();
		gameWindow = window;	
		try{
			wall = ImageIO.read(new File("res/Wall.png"));
			heroUnarmed = ImageIO.read(new File("res/heroUnarmed.png"));
			heroArmed = ImageIO.read(new File("res/heroArmed.png"));
			dragonAwake = ImageIO.read(new File("res/dragonAwake.png"));
			dragonAsleep = ImageIO.read(new File("res/dragonAsleep.png"));
			dragonOnSword = ImageIO.read(new File("res/dragonOnSword.png"));
			sword = ImageIO.read(new File("res/Sword.png"));
			exitClosed= ImageIO.read(new File("res/exitClosed.png"));
			exitOpen = ImageIO.read(new File("res/exitOpen.png"));
			floor = ImageIO.read(new File("res/floor.png"));
			error = ImageIO.read(new File("res/error.png"));
			}
		catch(IOException e) {
			System.out.println("ERROR! File not Found");
		}
	}
	
	public BufferedImage getImage(char s) {
		switch(s)
		{
			case 'X': return wall;
			case 'H': return heroUnarmed;
			case 'A': return heroArmed;
			case 'D': return dragonAwake;
			case 'd': return dragonAsleep;
			case 'F':
			case 'f': return dragonOnSword;
			case 'S': return sword;
			case 'E': return exitClosed;
			case ' ': return floor;
		}
		return error;
	}
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int row, column;
		String rowS = new String();
		int v[] = new int[2];
		for(row = 0; row < 10; row++) {
			for(column = 0; column < 10; column++) {
				v[0] = row;
				v[1] = column;
				g.drawImage(getImage(gameWindow.mapa.getChar(v).getSymb()), 64*v[1], 64*v[0], this);
			}
		}
	}
}