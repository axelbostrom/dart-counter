package dartcounter;

import java.util.ArrayList;

public class Player {
	
	int score, legs;
	String name;
	ArrayList<Integer> scoreList = new ArrayList<Integer>();
	
	public Player(String name, int score, int legs) {
		this.name = name;
		this.score = score;
		this.legs = legs;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLegs() {
		return legs;
	}

	public void setLegs(int legs) {
		this.legs = legs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
