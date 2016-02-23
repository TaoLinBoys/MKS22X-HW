public class KnightBoard{
    private int[][]board;

    public KnightBoard(int size){
		board = new int[size][size];
    }

    public boolean solve(){return solveH(1,0,0);}
	
	private boolean solveH(int moveNum, int x, int y){
		
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
