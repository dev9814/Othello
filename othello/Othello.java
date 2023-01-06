package othello;

import java.util.Scanner;


public class Othello {

private Player player1, player2;
	
	private Board board;
	
	private int numPlayers;
	
	private int turns = 60;
	
	public static void main(String[] args) {
		
		Othello o = new Othello();
		
		o.startGame();
	}
	
	public void startGame() {
		Scanner s = new Scanner(System.in);
		
		// Take Player Input
		player1 = takePlayerInput(++numPlayers);
		player2 = takePlayerInput(++numPlayers);
		
		while(player1.getSymbol() == player2.getSymbol()) {
			System.out.println("Symbol already taken!! Please enter the symbol again.");
			player2.setSymbol(s.next().charAt(0));
		}
		
		// Create The Board
		board = new Board(player1.getSymbol(), player2.getSymbol());
		
		// Play The Game
		boolean player1Turn = true;
		boolean status = false;
		
		while(turns>0 || status==false) {
			if(player1Turn) {
				System.out.println("Player 1-"+ player1.getName()+"'s turn");
				
				board.print();
				
				System.out.println("Enter x: ");
				int x = s.nextInt();
				System.out.println("Enter y: ");
				int y = s.nextInt();
				
				
				
				status = board.move(player1.getSymbol(), x, y);
				if(status == false ) {
					
					board.print();
					
					System.out.println("Invalid move!! Please try again.");
					continue;
				}
				turns--;
				
				
			}
			else {
					System.out.println("Player 2-"+ player2.getName()+"'s turn");
					
					board.print();
					
					System.out.println("Enter x: ");
					int x = s.nextInt();
					System.out.println("Enter y: ");
					int y = s.nextInt();
					
					
					
					status = board.move(player2.getSymbol(), x, y);
					
					if(status == false) {
						
						board.print();
						
						System.out.println("Invalid move!! Please try again.");
						continue;
					}
					
					turns--;
					
			}
			player1Turn = !player1Turn;
			board.print();
		}
		
					
	}		
	
	private Player takePlayerInput(int num) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Player "+num+" name: ");
		String name = s.nextLine();
		System.out.println("Enter Player "+num+" symbol: ");
		char symbol = s.next().charAt(0);
		Player p = new Player(name, symbol);
		return p;
	}
}
