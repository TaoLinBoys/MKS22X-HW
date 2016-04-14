import java.util.*;

public class Driver{
    public static void main(String[]args){
	if(args.length > 0){


	    //testing BFS & DFS - it works
	    BetterMaze test = new BetterMaze(args[0]);
	    
	    test.setAnimate(true);
	    test.solveBFS();
	    //test.solveDFS();
	    System.out.println(test);
	    System.out.println(Arrays.toString(test.solutionCoordinates()));

	    
	}else{
	    System.out.println("gimme name of dat file");
	}
    }    
}
