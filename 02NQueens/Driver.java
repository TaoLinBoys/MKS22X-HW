public class Driver{
    public static void main(String[]args){

	QueenBoard a = new QueenBoard(4);
	a.addQueen(1,0);
	System.out.println(a.toString());
	a.printBoard();



    }
}
