package dkeep.cli;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import dkeep.logic.Dragon;
import dkeep.logic.GameState;
import dkeep.logic.Map;
public class Main {
	public static Map game;
	public static void mainTerm(String[] args){
		int numDragon = getInput();
		game = new Map();
		game.newGame(numDragon);									//Start new game
		String com;
		updateMap();
		Scanner scan = new Scanner(System.in);
		while(true) {
			com = scan.next();								//get user input
			int[] nextPos = getPos(com,game);				//process input
			if (nextPos[0] == -1 || nextPos[1] == -1)		//test for invalid commands
				continue;
			if(updateHero(nextPos)) {						//Hero moves
				updateMap();								//refresh screen
				//cicle through
				game.validDragons();								//Test hero for adj dragon
				if(game.testGame() || game.testWin())		//Test win/lose conditions
					break;
				//Cicle through array
				updateDragons();		//Move dragons	
				game.validDragons();
			}				
			updateMap();
			game.printOut();
			if(game.testGame() || game.testWin())		   		//Test win/lose conditions
				break;
		}
		endingScreen();
		scan.close();
	}
	private static void endingScreen() {
		if (game.testGame()) 
			System.out.println("You lose!");
		if(game.testWin()) {
			final String cup = 
					" YOU WIN!\n"  
							+ "______\n"
							+ "\\    /\n"
							+ " \\  /\n"
							+ "  \\/\n"
							+ "  ()\n"
							+ "  ()\n"
							+ " _()_\n"
							+ "[____]";
			System.out.println(cup);
		}
	}
	public static int[] getPos(String com,GameState map) {	
		int next_row = map.getHero().getCoord()[0] ,next_col = map.getHero().getCoord()[1];
		int curr_row = next_row ,curr_col = next_col;
		switch(com) {
		case "W": 
		case "w":	next_row = curr_row - 1;
		break;
		case "S":
		case "s":	next_row = curr_row + 1;
		break;
		case "A":
		case "a":	
			next_col = curr_col - 1;
			break;
		case "D":
		case "d":	next_col = curr_col + 1;
		break;
		default: System.out.println("Unknown"); next_row = -1; next_col = -1;
		}
		return (new int[] {next_row,next_col});
	}
	public static void updateMap() {
		game.getMap().printMap();
	}
	public static void updateDragons() {
		Iterator<Dragon> it = game.getList().iterator();
		Random rand = new Random();
		for(Dragon index : game.getList()) {
			index = it.next();
			if(rand.nextInt(99) < 25) 
				index.changeSleep();
			else if (game.getDrag(index).getAlive() && !game.getDrag(index).checkSleep()) 				//Move Dragon if alive
				game.dragonMove(index);
		}
	}
	public static boolean updateHero(int[] nextPos) {
		return game.testMove(game.getMap().getHero(), nextPos);
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
}