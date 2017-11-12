package dkeep.logic;
public class Hero extends Element {
	private boolean armed = false;
	private boolean hasKey = false;
	private boolean alive = true;
	public Hero(Map map) {
		super('H',map);
		// TODO Auto-generated constructor stub
	}
	public void updateArmed() {					//Change symbol if armed
		armed = true;
		setSymb('A');
	}
	public boolean getArmed() {
		return armed;
	}
	public boolean getKey() {					//Test for key
		return hasKey;
	}
	public void giveKey() {						//Give key to hero
		hasKey = true;
	}
	public void dead() {
		alive = false;
	}
	public boolean getAlive() {
		return alive;
	}
}