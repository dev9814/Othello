package othello;

public class Board {

	private char board[][];
	
	private int boardSize = 8;
	
	private char p1Symbol, p2Symbol;
	
	private int p1count, p2count;
	
	private static final char EMPTY = ' '; 

	
	int XDir[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	int YDir[] = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public Board(char p1Symbol, char p2Symbol) {
		
		board = new char[boardSize][boardSize];
		
		for(int i=0;i<boardSize;i++) {
			for(int j=0;j<boardSize;j++) {
				
				// Initially we make every cell empty
				board[i][j] = EMPTY;
			}
		}
		
		this.p1Symbol = p1Symbol;
		this.p2Symbol = p2Symbol;
		
		board[3][3] = p1Symbol;
		board[3][4] = p2Symbol;
		
		board[4][3] = p2Symbol;
		board[4][4] = p1Symbol;
		
	}
	
	public void print() {
		System.out.println("---------------------------------");
		for(int i=0;i<boardSize;i++) {
			for(int j=0;j<boardSize;j++) {
				System.out.print("| "+ board[i][j]+" |");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("------------------------------------");
	}
	
	protected boolean move(char symbol, int x, int y) {
		
		if(x<0 || x>=boardSize || y<0 || y>=boardSize || board[x][y]!=EMPTY) {
			
			return false;
		}
		
		boolean bell = false;
		
		for(int i=0;i<XDir.length;i++) {
			
			int r = x;
			int c = y;
			
			int XStep = XDir[i];
			int YStep = YDir[i];
			
			
			int count = 0;
			
			while(true) {
				
				if((r+XStep)<0 || (r+XStep)>=boardSize || (c+YStep)<0 || (c+YStep)>=boardSize || board[r+XStep][c+YStep] == EMPTY) {
					
					break;
				}
				
								
				else if(board[r+XStep][c+YStep]==symbol) {
					
					break;
				}
				
				else {
					
					
					
					while(true) {
						
						r = r + XStep;
						c = c + YStep;
						
						count++;
						
						if(r<0 || r>=boardSize || c<0 || c>=boardSize || board[r][c] == EMPTY) {
							
							
							
							count = 0;
							break;
						}
						
						if(board[r][c]==symbol) {
							
							
							
							break;
						}
						
						
					}
					
					
					if(count>0) {
						r = x;
						c = y;
						
						
						
						for(int j=0;j<count;j++) {
							board[r][c] = symbol;
							r = r + XStep;
							c = c + YStep;
								
						}
						
						bell = true;
					}
					
					
					break;
				}
				
			
				
			} // While loop
			
			
			
		} // For loop
		
		if(bell == true) {
			return true;
		}else {
			return false;
		}
		
		

	} // Move Function
}
