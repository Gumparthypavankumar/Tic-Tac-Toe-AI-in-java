import java.util.*;

public class TicTacToe {
	private static final Scanner in = new Scanner(System.in);
	private static String ans = "";
	private static char bot = 'X';
	private static char player = 'O';
	private static void printBoard(char gameBoard[][]) {
		System.out.println();
		for(char row[]: gameBoard) {
			for(char ch: row) {
				System.out.print(ch);
			}
			System.out.println();
		}
	}
	
	private static void insertLetter(char gameBoard[][], int rowPos, int colPos,char letter) {
		if(gameBoard[rowPos][colPos] == ' ') {
			gameBoard[rowPos][colPos] = letter;
			printBoard(gameBoard);
			// For every move check if player wins!
			if(checkWin(gameBoard)) {
				if(letter == bot)
					System.out.println("X wins!");
				else
					System.out.println("O wins!");
				System.exit(0);
			}
			if(checkDraw(gameBoard)) {
				System.out.println("Game is Drawn!");
				System.exit(0);
			}
		}
		else {
			System.out.println("This Position is already occupied please choose other free ones");
			System.out.println("Please Enter the Position of row and column(space separated): ");
			int row = in.nextInt();
			int col = in.nextInt();
			if((row%2 == 0 && row >= 0 && row < 5) && (col%2 == 0 && col >= 0 && col < 5)) {
				insertLetter(gameBoard, row, col, letter);
			}
			else {
				System.out.println("Sorry, Row and column position should be 0, 2 or 4 only. Please use numbers only");
			}
		}
	}
	
	private static boolean checkDraw(char gameBoard[][]) {
		// To achieve draw state every single grid must not be empty
		if(gameBoard[0][0] != ' ' && gameBoard[0][2] != ' ' && gameBoard[0][4] != ' ' && gameBoard[2][0] != ' ' && gameBoard[2][2] != ' ' && gameBoard[2][4] != ' ' && gameBoard[4][0] != ' ' && gameBoard[4][2] != ' ' && gameBoard[4][4] != ' ')
			return true;
		return false;
	}
	
	private static boolean checkWin(char gameBoard[][]) {
		// Row wise 
		if((gameBoard[0][0] != ' ' && gameBoard[0][2] != ' ' && gameBoard[0][4] != ' ') && (gameBoard[0][0] == gameBoard[0][2]) && (gameBoard[0][2] == gameBoard[0][4])) {
			return true;
		}
		else if((gameBoard[2][0] != ' ' && gameBoard[2][2] != ' ' && gameBoard[2][4] != ' ') && (gameBoard[2][0] == gameBoard[2][2]) && (gameBoard[2][2] == gameBoard[2][4])) {
			return true;
		}
		else if((gameBoard[4][0] != ' ' && gameBoard[4][2] != ' ' && gameBoard[4][4] != ' ') && (gameBoard[4][0] == gameBoard[4][2]) && (gameBoard[4][2] == gameBoard[4][4])) {
			return true;
		}
		// Column wise
		else if((gameBoard[0][0] != ' ' && gameBoard[2][0] != ' ' && gameBoard[4][0] != ' ') && (gameBoard[0][0] == gameBoard[2][0]) && (gameBoard[2][0] == gameBoard[4][0])) {
			return true;
		}
		else if((gameBoard[0][2] != ' ' && gameBoard[2][2] != ' ' && gameBoard[4][2] != ' ') && (gameBoard[0][2] == gameBoard[2][2]) && (gameBoard[2][2] == gameBoard[4][2])) {
			return true;
		}
		else if((gameBoard[0][4] != ' ' && gameBoard[2][4] != ' ' && gameBoard[4][4] != ' ') && (gameBoard[0][4] == gameBoard[2][4]) && (gameBoard[2][4] == gameBoard[4][4])) {
			return true;
		}
		// Diagonally
		else if(((gameBoard[0][0] != ' ' && gameBoard[2][2] != ' ' && gameBoard[4][4] != ' ') && gameBoard[0][0] == gameBoard[2][2]) && (gameBoard[2][2] == gameBoard[4][4])) {
			return true;
		}
		else if((gameBoard[0][4] != ' ' && gameBoard[2][2] != ' ' && gameBoard[4][0] != ' ') && (gameBoard[0][4] == gameBoard[2][2]) && (gameBoard[2][2] == gameBoard[4][0])) {
			return true;
		}
		return false;
	}
	
	private static boolean checkWhichMarkWon(char gameBoard[][], char mark) {
		// Row wise 
		if((gameBoard[0][0] != ' ' && gameBoard[0][2] != ' ' && gameBoard[0][4] != ' ') && (gameBoard[0][0] == gameBoard[0][2]) && (gameBoard[0][2] == gameBoard[0][4])) {
			return true;
		}
		else if((gameBoard[2][0] != ' ' && gameBoard[2][2] != ' ' && gameBoard[2][4] != ' ') && (gameBoard[2][0] == gameBoard[2][2]) && (gameBoard[2][2] == gameBoard[2][4])) {
			return true;
		}
		else if((gameBoard[4][0] != ' ' && gameBoard[4][2] != ' ' && gameBoard[4][4] != ' ') && (gameBoard[4][0] == gameBoard[4][2]) && (gameBoard[4][2] == gameBoard[4][4])) {
			return true;
		}
		// Column wise
		else if((gameBoard[0][0] != ' ' && gameBoard[2][0] != ' ' && gameBoard[4][0] != ' ') && (gameBoard[0][0] == gameBoard[2][0]) && (gameBoard[2][0] == gameBoard[4][0])) {
			return true;
		}
		else if((gameBoard[0][2] != ' ' && gameBoard[2][2] != ' ' && gameBoard[4][2] != ' ') && (gameBoard[0][2] == gameBoard[2][2]) && (gameBoard[2][2] == gameBoard[4][2])) {
			return true;
		}
		else if((gameBoard[0][4] != ' ' && gameBoard[2][4] != ' ' && gameBoard[4][4] != ' ') && (gameBoard[0][4] == gameBoard[2][4]) && (gameBoard[2][4] == gameBoard[4][4])) {
			return true;
		}
		// Diagonally
		else if(((gameBoard[0][0] != ' ' && gameBoard[2][2] != ' ' && gameBoard[4][4] != ' ') && gameBoard[0][0] == gameBoard[2][2]) && (gameBoard[2][2] == gameBoard[4][4])) {
			return true;
		}
		else if((gameBoard[0][4] != ' ' && gameBoard[2][2] != ' ' && gameBoard[4][0] != ' ') && (gameBoard[0][4] == gameBoard[2][2]) && (gameBoard[2][2] == gameBoard[4][0])) {
			return true;
		}
		return false;
	}
	
	private static void PlayerMove(char gameBoard[][]) {
		System.out.println("Please Enter the Position of row and column(space separated): ");
		int rowPos = in.nextInt();
		int colPos = in.nextInt();
		if((rowPos%2 == 0 && rowPos >= 0 && rowPos < 5) && (colPos%2 == 0 && colPos >= 0 && colPos < 5)) {
			insertLetter(gameBoard,rowPos,colPos,player);
		}
		else {
			System.out.println("Sorry, Row and column position should be 0, 2 or 4 only. Please use numbers only");
		}
	}
	
	private static void ComputerMove(char gameBoard[][]) {
		int bestScore = -800;
		int bestMoverow = 0, bestMovecol = 0;
		for(int i=0;i<gameBoard.length;i++) {
			for(int j=0;j<gameBoard[0].length;j++) {
				if(gameBoard[i][j] == ' ') {
					gameBoard[i][j] = bot;
					int score = minMax(gameBoard, 0, false);
					gameBoard[i][j] = ' ';
					if(score > bestScore) {
						bestScore = score;
						bestMoverow = i;
						bestMovecol  = j;
					}
				}
			}
		}
		insertLetter(gameBoard, bestMoverow, bestMovecol, bot);
		return;
	}
	
	private static void startGame(char gameBoard[][]) {
		while(!checkWin(gameBoard)) {
			ComputerMove(gameBoard);
			PlayerMove(gameBoard);
		}
	}
	
	private static int minMax(char[][] gameBoard,int depth, boolean isMaximising) {
		if (checkWhichMarkWon(gameBoard, bot))
	        return 1;
	   else if (checkWhichMarkWon(gameBoard, player))
	        return -1;
	   else if(checkDraw(gameBoard))
	        return 0;
		if(isMaximising) {
			int bestScore = -800;
			for(int i=0;i<gameBoard.length;i++) {
				for(int j=0;j<gameBoard[0].length;j++) {
					if(gameBoard[i][j] == ' ') {
						gameBoard[i][j] = bot;
						int score = minMax(gameBoard, 0, false);
						gameBoard[i][j] = ' ';
						if(score > bestScore) {
							score = bestScore;
						}
					}
				}
			}
			return bestScore;
		}
		else {
			int bestScore = 800;
			for(int i=0;i<gameBoard.length;i++) {
				for(int j=0;j<gameBoard[0].length;j++) {
					if(gameBoard[i][j] == ' ') {
						gameBoard[i][j] = player;
						int score = minMax(gameBoard, 0, true);
						gameBoard[i][j] = ' ';
						if(score > bestScore) {
							bestScore = score;
						}
					}
				}
			}
			return bestScore;
		}
	}
	private static void playGame() {
		// An array of moves in grid of 9 positions starting from 0 to 8 holding either X or O characters
				/*
				 *    0 --->  0 | 1 | 2
				 *    1 --->  0 | 1 | 2 
				 *    2 --->  0 | 1 | 2
				*/

		// Setting the default values for gameBoard
		char gameBoard[][] = {
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '}
			};
		printBoard(gameBoard);
		startGame(gameBoard);
	}
	public static void main(String[] args) {
		playGame();
	}
}
