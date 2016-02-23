public class KnightBoard{
    private int[][] board;
	private int moveNum = 1;

    public KnightBoard(int size){
		board = new int[size][size];
    }

    public boolean solve(){return solveH(0,0);}
	
	private boolean solveH(int x, int y){
		if (moveNum == board.length*board.length){return true;}
		if (move(x,y,1,2))return solveH(x+1,y+2);
	}
	
	private boolean move(int x, int y, int move1, int move2){
		if(inRange(x+move1,y+move2)){
			moveNum++;
			board[x+move1][y+move2] = moveNum;
			return true;
		}
		return false;
	}

	private boolean inRange(int x, int y){
		return x>=0 && x<board.length && y>=0 && y<board.length;
	}
	
    public void printSolution(){
		String line = "";
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board.length; j++){
				if (board[i][j]<10){line += "_"+board[i][j]+" ";}
				line += board[i][j]+" ";
			}
			line += "\n"
		}
		System.out.println(line);
	}
}
