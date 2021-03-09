package dartcounter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	/*
	 * Welcome to Dart Counter, a simple program made to check score of a dart game 
	 * and output the result of every player to a .txt document that then can be shown live
	 * in Streamlabs OBS.
	 * 
	 * THIS IS A VERY BASIC PROGRAM
	 * 
	 * Author: Axel Boström
	 * Trykk
	 * D-Group 20/21
	 */
	
	public static void main(String[] args) {
		Game game = new Game();
		createPlayers(game);
	}

	private static void createPlayers(Game game) {
		Scanner scan = new Scanner(System.in);
		
		/* player 1 */
		System.out.println("Please enter the name of the first player.");
		String name1 = scan.nextLine();
		Player player1 = new Player(name1, 301, 0);
		
		/* player 2 */
		System.out.println("Please enter the name of the second player.");
		String name2 = scan.nextLine();
		Player player2 = new Player(name2, 301, 0);
		
		setName(name1, name2);
		
		game.startGame(player1, player2);
	}

	private static void setName(String name1, String name2) {
		try {
			FileWriter myWriter = new FileWriter("namn.txt", false);
			myWriter.write(name1 + "\n" + name2);
			myWriter.close();
			System.out.println("Updated names.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
	}
	
}
