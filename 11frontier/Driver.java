public class Driver{
    public static void main(String[]args){
	if(args.length > 0){
	    BetterMaze test = new BetterMaze(args[0]);
	    System.out.println(test);
	    test.solveBFS();
	    System.out.println(test);

	    BetterMaze test2 = new BetterMaze(args[0]);
	    System.out.println(test2);
	    test.solveDFS();
	    System.out.println(test2);

	    
	}else{
	    System.out.println("gimme name of dat file");
	}
    }    
}
