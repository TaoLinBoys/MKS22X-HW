public class Driver{
    public static void main(String[]args){
		if(args.length!=0){
			QueenBoard board = new QueenBoard(Integer.parseInt(args[0]));
			board.solve();
			String s = board.toString();
			System.out.println(s);
		}else{System.out.println("Give me a number");}
    }
}
