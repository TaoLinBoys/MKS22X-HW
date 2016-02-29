public class KnightBoard{
    private int[][] board;;

    public KnightBoard(int size){
	board = new int[size][size];
    }

    public boolean solve(){return solveH(0,0,1);}
	
    private boolean solveH(int x, int y, int moveNum){
	if(!(inRange(x,y)))return false;
	if(board[x][y]!=0)return false;

	board[x][y]=moveNum;
	if(moveNum == board.length*board.length)return true;

	if(solveH(x+1, y+2, moveNum+1))return true;
	if(solveH(x+1, y-2, moveNum+1))return true;
	if(solveH(x-1, y+2, moveNum+1))return true;
	if(solveH(x-1, y-2, moveNum+1))return true;
	if(solveH(x+2, y+1, moveNum+1))return true;
	if(solveH(x+2, y-1, moveNum+1))return true;
	if(solveH(x-2, y+1, moveNum+1))return true;
	if(solveH(x-2, y-1, moveNum+1))return true;
	   
	/*
	if((solveH(x+1, y+2, moveNum+1) ||
	    solveH(x+1, y-2, moveNum+1) ||
	    solveH(x-1, y+2, moveNum+1) ||
	    solveH(x-1, y-2, moveNum+1) ||
	    solveH(x+2, y+1, moveNum+1) ||
	    solveH(x+2, y-1, moveNum+1) ||
	    solveH(x-2, y+1, moveNum+1) ||
	    solveH(x-2, y-1, moveNum+1) )){
	    return true;
	    }*/

	//board[x][y]=0;
	moveNum--;
	return false;


	/*
	if (moveNum == board.length*board.length){return true;}
	if (inRange(x,y) && (board[x][y]==0)){
	    board[x][y]=moveNum;
	    return 
	}
	return false;*/
    }

    private boolean inRange(int x, int y){
	return x>=0 && x<board.length && y>=0 && y<board.length;
    }
	
    public void printSolution(){
	String line = "";
	for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board.length; j++){
		if (board[i][j]==0){line+="__ ";}
		if (board[i][j]<10 && board[i][j]>0){line += "_"+board[i][j]+" ";}
		if (board[i][j]>=10){line += board[i][j]+" ";}	
	    }
	    line += "\n";
	}
	System.out.println(line);
    }

    public static void main(String[]args){
	if(args.length!=0){
	    KnightBoard board = new KnightBoard(Integer.parseInt(args[0]));
	    board.solve();
	    board.printSolution();
	}
    }
}
