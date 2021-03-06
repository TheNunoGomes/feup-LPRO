package dkeep.logic;
public class Dragon extends Element {
	private boolean sleep = false;
	private boolean alive = true;
	private boolean sword = false;
	public int index;
	public Dragon(Map map) {
		super('D',map);
		// TODO Auto-generated constructor stub
	}
	public void changeSleep() {
		sleep = !sleep;
		updateSleep();
	}
	private void updateSleep() {
		if (checkSleep()) {
			if (sword) setSymb('f');
			else setSymb('d');
		}
		else {
			if(sword) setSymb('F');
			else setSymb('D');
		}
	}
	public boolean checkSleep() {
		return sleep;
	}
	public boolean getAlive() {
		return alive;
	}
	public void changeAlive() {
		alive = false;
	}
	public void onSword() {
		sword = !sword;
		if (sword) setSymb('F');
		else setSymb('D');
	}
}