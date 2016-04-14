import java.util.*;
import java.io.*;

public class BetterMaze{
    private class Node{
	public int[] coord;
        public Node prev;
	public Node(int x, int y, Node P){
	    coord = new int[2];
	    coord[0]=x;
	    coord[1]=y;
	    prev = P;
	}
	public int[] getValue(){
	    return coord;
	}
	public Node getPrev(){
	    return prev;
	}
    }

    private char[][] maze;
    private int[]    solution;
    private int      startRow,startCol;
    private Frontier<Node> placesToGo;
    private boolean  animate;//default to false

   /**return a COPY of solution.
     *This should be : [x1,y1,x2,y2,x3,y3...]
     *the coordinates of the solution from start to end.
     *Precondition : one of the solveXXX methods has already been 
     * called (solveBFS OR solveDFS OR solveAStar)
     *(otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
    **/
    public int[] solutionCoordinates(){
	MyQueue<Integer> listOfInts = new MyQueue<Integer>();
	Node current = placesToGo.next();
	while(current != null){
	    listOfInts.enqueue(current.getValue()[0]);
	    listOfInts.enqueue(current.getValue()[1]);
	    current = current.getPrev();
	}

	solution = new int[listOfInts.size()];
	for(int i = 0; i < solution.length; i++){
	    solution[i] = listOfInts.dequeue();
	}
	
	
	return solution;
    }    


    /**initialize the frontier as a queue and call solve
    **/
    public boolean solveBFS(){  
        placesToGo = new FrontierQueue<Node>();      
	return solve();
    }   


   /**initialize the frontier as a stack and call solve
    */ 
    public boolean solveDFS(){  
        placesToGo = new FrontierStack<Node>();  
	return solve();
    }    

   /**Search for the end of the maze using the frontier. 
      Keep going until you find a solution or run out of elements on the frontier.
    **/
    private boolean solve(){
	Node startNode = new Node(startRow, startCol, null);
	placesToGo.add(startNode); //adding start pos to frontier
	while(placesToGo.hasNext()){	    
	    Node current = placesToGo.next();
	    
	    int[] xandy = current.getValue();
	    int x = xandy[0];
	    int y = xandy[1];
	    if(maze[x][y] == 'E'){
		return true;
	    }
	    
	    for(Node neigh : getNeighbors(current)){
		placesToGo.add(neigh);
		maze[x][y] = '.';
	    }
	    
	    if(animate){
		wait(100);
		clearTerminal();
	    	System.out.println(toString());
	    }
	    
	}
	return false;
    }
    
    private ArrayList<Node> getNeighbors(Node current){
	int row = current.getValue()[0];
	int col = current.getValue()[1];
        ArrayList<Node> neighbors = new ArrayList<Node>();

	if(maze[row+1][col] == ' ' || maze[row+1][col] == 'E'){
	    neighbors.add(new Node(row+1,col,current));
	}
	if(maze[row-1][col] == ' ' || maze[row-1][col] == 'E'){
	    neighbors.add(new Node(row-1,col,current));
	}
	if(maze[row][col+1] == ' ' || maze[row][col+1] == 'E'){
	    neighbors.add(new Node(row,col+1,current));
	}
	if(maze[row][col-1] == ' ' || maze[row][col-1] == 'E'){
	    neighbors.add(new Node(row,col-1,current));
	}
	return neighbors;
    }
     
   /**mutator for the animate variable  **/
    public void setAnimate(boolean b){ animate = b; }    


    public BetterMaze(String filename){
	animate = false;
	int maxc = 0;
	int maxr = 0;
	startRow = -1;
	startCol = -1;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxr == 0){
		    //calculate width of the maze
		    maxc = line.length();
		}
		//every new line add 1 to the height of the maze
		maxr++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	System.out.println(maxr+" "+maxc);
	maze = new char[maxr][maxc];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i / maxc][i % maxc] = c;
	    if(c == 'S'){
		startCol = i % maxc;
		startRow = i / maxc;
	    }
	}
    }







    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public String toString(){
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	if(animate){
	    ans = "Solving a maze that is " + maxr + " by " + maxc + "\n";
	}
	for(int i = 0; i < maxc * maxr; i++){
	    if(i % maxc == 0 && i != 0){
		ans += color(37,40) + "\n";
	    }
	    char c =  maze[i / maxc][i % maxc];
	    if(c == '#'){
		ans += color(38,47)+c;
	    }else{
		ans += color(33,40)+c;
	    }
	}
	//nice animation string
	if(animate){
	    return HIDE_CURSOR + go(0,0) + ans + color(37,40) +"\n"+ SHOW_CURSOR + color(37,40);
	}else{
	    return ans + color(37,40) + "\n";
	}
    } 
    


       
    
    

}
