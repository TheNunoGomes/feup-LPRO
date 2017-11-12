package dkeep.logic;

import java.util.ArrayList;
import java.util.Random;
public class GameState {
	private Map map;
	protected Hero hero;
	protected ArrayList<Dragon> dragons;
	protected Sword sword;
	protected int numDragons;
	private boolean gameOver = false;
	private boolean win = false;
	private String outputString;
	private int dragonsKilled;
	public GameState(){
		outputString = " ";
		dragonsKilled = 0;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map mapa) {
		map = mapa;
	}
	public void newGame(int num) {
		numDragons = num;
		dragons =  new ArrayList<Dragon>(numDragons);
		for(int i = 0;i < numDragons;i++) {
			Dragon dragAux = new Dragon(map); 
			dragAux.index = i;
			dragons.add(dragAux);
			map.setChar(dragAux);
		}
		map.setChar(hero = new Hero(map));
		map.setChar(sword = new Sword(map));
	}
	public Dragon getDrag(Dragon index) {
		return index;
	}
	public ArrayList<Dragon> getList() {
		return dragons;
	}
	public Hero getHero() {
		return hero;
	}
	public Sword getSword() {
		return sword;
	}
	public boolean testGame() {
		return gameOver;
	}
	public boolean testWin() {
		return win;
	}
	public void changeGame() {
		gameOver = !gameOver;
	}
	public void changeWin() {
		win = !win;
	}
	private boolean testTop(int[] coords,Dragon drag) {
		return (coords[0] == drag.getCoord()[0]-1) && (coords[1] == drag.getCoord()[1]);
	}
	private boolean testBot(int[] coords,Dragon drag) {
		return (coords[0] == drag.getCoord()[0]+1) && (coords[1] == drag.getCoord()[1]);
	}
	private boolean testLeft(int[] coords,Dragon drag) {
		return (coords[0] == drag.getCoord()[0]) && (coords[1] == drag.getCoord()[1]-1);
	}
	private boolean testRight(int[] coords,Dragon drag) {
		return (coords[0] == drag.getCoord()[0]) && (coords[1] == drag.getCoord()[1]+1);
	}	
	public boolean testDragon(int[] coords,Dragon dragAux) {		//false = adjacent
		return !(testRight(coords,dragAux) || testLeft(coords,dragAux) || testTop(coords,dragAux) || testBot(coords,dragAux));	
	}
	public boolean testMove(Hero myHero, int[] newCoord) { 
		if (!map.testChar(newCoord, 'X')){
			outputString = "Wall!";
			callMove(outputString);
			return false;
		}
		if(!map.testChar(newCoord,'E')){
			if(!getHero().getKey()) {
				outputString = "Key missing!";
				callMove(outputString);
				return false;
			}
			else 
				moveChar(myHero, newCoord);
			changeWin();
		}
		if(!myHero.getArmed() && !map.testChar(newCoord, 'd','f')) {
			outputString = "Don't wake the dragon";
			callMove(outputString);
			return false;
		}
		if (!map.testChar(newCoord, 'S')) {
			myHero.updateArmed();
			moveChar(myHero, newCoord);
			outputString = "Sword picked up!";
			callMove(outputString);
		}
		if(!map.testChar(newCoord, ' '))
			moveChar(myHero, newCoord);
		checkKey();
		return true;
	}
	public String callMove(String s) {
		return s;
	}
	public boolean validDragon(Dragon index) {
		int[] pos = getHero().getCoord();
		return testDragon(pos,index);
	}
	public boolean validDragons() {
		for(Dragon index : dragons) {
			if(!index.getAlive()) continue;
			if(!validDragon(index) && !hero.getArmed() && !index.checkSleep()) {	//check if adj,armed,sleep
				hero.dead();
				changeGame();
				return false;
			}
			if(hero.getArmed() && !validDragon(index)) {
				map.setChar(new Element(index.getCoord(), ' ', map));
				index.changeAlive();
				outputString = "Dragon slain || Key picked up";
				dragonsKilled++;
			}
		}
		return true;
	}
	public void checkKey() {
		if(dragonsKilled >= numDragons)
			map.getHero().giveKey();
	}
	public void moveChar(Element el,int[] newCoord) {
		int[] oldCoord = el.getCoord();
		Element old = new Element(el.getCoord(),' ',map);
		if(el.getSymb() == 'F' ){
			Dragon aux = (Dragon) el;
			if((map.getSword().getCoord()[0] == oldCoord[0]) && (map.getSword().getCoord()[1] == oldCoord[1])){
				old = map.getSword();
				aux.onSword();
			}
		}
		map.setChar(old);										//Clear old position
		el.setCoord(newCoord);									// Set new coord on el
		map.setChar(el);	
	}
	public void dragonMove(Dragon index){
		Random rand = new Random();
		int row;
		int col;
		int []newPos;
		int drag_c = map.getDrag(index).getCoord()[1];
		int drag_r = map.getDrag(index).getCoord()[0];
		int i = 0;
		while (i <= 4) {
			row = rand.nextInt(drag_r + 1 - (drag_r - 1) + 1) + drag_r - 1;
			col = rand.nextInt(drag_c + 1 - (drag_c - 1) + 1) + drag_c - 1;
			if (row != drag_r && col != drag_c) continue;
			newPos = new int[]{row,col};
			if (!map.testChar(newPos,'S')) {
				moveChar(map.getDrag(index),newPos);
				map.getDrag(index).onSword(); 
				break;
			}
			if(!map.testChar(newPos,' ')) {
				moveChar(map.getDrag(index),newPos);
				break;
			}
			i++;
		}
	}
	public void printOut() {
		System.out.println(outputString);
		outputString = " ";
	}
}