public class Driver{
    public static void main(String[]args){
		if(args.length!=0){
			QueenBoard board = new QueenBoard(Integer.parseInt(args[0]));
			board.solve();
			board.printSolution();
		}else{System.out.println("Give me a number");}
    }
}
