public class Driver{
    public static void main(String[]args){
	if(args.length > 0){
	    BetterMaze test = new BetterMaze(args[0]);
	    System.out.println(test);
	}else{
	    System.out.println("gimme name of .dat file");
	}
    }    
}