package dartcounter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

	int MAX_SCORE = 180;
	int START_SCORE = 301;

	boolean gameover;
	boolean legover;

	public Game() {

	}

	public void startGame(Player player1, Player player2) {
		gameover = false;
		legover = false;
		updateScore(player1.getScore(), player2.getScore());
		updateLegs(player1.getLegs(), player2.getLegs());
		while (!gameover) {
			scoreCheck(player1);
			if ((player1.getScore() == 0) && !(player1.getLegs() == 2)) {
				legover = true;
				System.out.println("");
				System.out.println(player1.getName() + " won the leg.");
			} else if (player1.getLegs() == 2) {
				gameover = true;
				System.out.println("");
				System.out.println(player1.getName() + " won the game!!");
				updateScore(player1.getScore(), player2.getScore());
				updateLegs(player1.getLegs(), player2.getLegs());
				break;
			}

			updateScore(player1.getScore(), player2.getScore());

			if (legover) {
				player1.setScore(START_SCORE);
				player2.setScore(START_SCORE);
				updateScore(player1.getScore(), player2.getScore());
				updateLegs(player1.getLegs(), player2.getLegs());
				legover = false;
			}

			scoreCheck(player2);
			if ((player2.getScore() == 0) && !(player2.getLegs() == 2)) {
				legover = true;
				System.out.println("");
				System.out.println(player1.getName() + " won the leg.");
			} else if (player2.getLegs() == 2) {
				gameover = true;
				System.out.println("");
				System.out.println(player1.getName() + " won the game!!");
				updateScore(player1.getScore(), player2.getScore());
				updateLegs(player1.getLegs(), player2.getLegs());
				break;
			}

			updateScore(player1.getScore(), player2.getScore());

			if (legover) {
				player1.setScore(START_SCORE);
				player2.setScore(START_SCORE);
				updateScore(player1.getScore(), player2.getScore());
				updateLegs(player1.getLegs(), player2.getLegs());
				legover = false;
			}
		}
	}

	private void scoreCheck(Player player) {
		Scanner scan = new Scanner(System.in);
		boolean validScore = false;

		System.out.println(
				player.getName() + " require " + player.getScore() + ". Has won " + player.getLegs() + " legs.");
		System.out.println("Please input this rounds score for " + player.getName() + ":");
		while (validScore == false) {
			try {

				int score = scan.nextInt();
				if (validScore(score, player)) {
					player.setScore(player.getScore() - score);
					player.scoreList.add(score);
					validScore = true;
				} else if (player.getScore() - score == 0) {
					player.setScore(player.getScore() - score);
					player.scoreList.add(score);
					if (player.getLegs() == 2) {
						scan.close();
						return;
					} else {
						player.setLegs(player.getLegs() + 1);
					}
					validScore = true;
				} else {
					System.out.println("Incorrect input, try again.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Incorrect input, try again:");
			}
		}

		if (player.getScore() == 0) {
			return;
		}
		System.out.println(player.getName() + " now require " + player.getScore() + ".");
		System.out.println("");
	}

	private void updateScore(int i, int j) {
		try {
			FileWriter myWriter = new FileWriter("score.txt", false);
			myWriter.write(i + "\n" + j);
			myWriter.close();
			System.out.println("Updated score.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	private void updateLegs(int legs, int legs2) {
		try {
			FileWriter myWriter = new FileWriter("ben.txt", false);
			myWriter.write(legs + "\n" + legs2);
			myWriter.close();
			System.out.println("Updated legs.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
	}

	private boolean validScore(int score, Player player) {
		if (score <= 180 && player.getScore() - score > 0) {
			return true;
		}
		return false;
	}
}
