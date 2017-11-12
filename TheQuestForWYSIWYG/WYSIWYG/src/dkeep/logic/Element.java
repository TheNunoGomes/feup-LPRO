package dkeep.logic;
import java.util.*;
public class Element {
	private int[] coordinates = new int[2];
	private char symb;
	public Element(int[] startCoord,char symbol,Map map) {		//Constructor, set initial coordinates
			setSymb(symbol);
			setCoord(startCoord);
	}
	public Element (char symbol,Map gameMap) {			//set Element el in random
		Random rand = new Random();
		setSymb(symbol);
		int row, column;
		Iterator<Dragon> it;
		boolean val = true;
		while(true) { 
			it = gameMap.dragons.iterator();
			row = rand.nextInt(8) + 1; 
			column = rand.nextInt(8) + 1;
			int []newPos = new int[]{row,column};
			System.out.println(String.format("Creating:%c",symbol));
			while(it.hasNext() && (symbol == 'H')) {
				if(!(val &= gameMap.testDragon(newPos,it.next())))
					break;
			}
			switch (symbol){
				case 'D': val = !gameMap.testChar(newPos,' '); break;
				case 'S': val &= (gameMap.testChar(newPos,'D','X','E','H')); break;
				case 'H': val &= (gameMap.testChar(newPos,'D','X','E')); break;
			}
			if(val){
				setCoord(newPos);  
				break;
			}
			val = true;
		}
	}
	public void setCoord (int[] newCoord) {
		coordinates = newCoord;
	}
	public int[] getCoord() {
		return coordinates;
	}
	public void setSymb(char newSymb) {
		symb = newSymb;
	}
	public char getSymb() {
		return symb;
	}
}