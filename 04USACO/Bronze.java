import java.util.*;
import java.io.*;

public class Bronze{
    private static boolean DEBUG = true;
    private int[][]lake;
    private int R,C,E,N;
	
    public Bronze(){
	try{
	    Scanner s = new Scanner(new File("makelake.in"));
	    Scanner a = new Scanner(s.nextLine());
	    R = a.nextInt();
	    C = a.nextInt();
	    E = a.nextInt();
	    N = a.nextInt();
			
	    lake = new int[R][C];
	    for(int i = 0; i < R; i++){
		Scanner line = new Scanner(s.nextLine());
		for(int j = 0; j < C; j++){
		    lake[i][j]=line.nextInt();
		}
	    }
			
	    while(s.hasNext()){
		Scanner stomper = new Scanner(s.nextLine());
		int r = stomper.nextInt();
		int c = stomper.nextInt();
		int d = stomper.nextInt();
		stomp(r,c,d);
	    }
	}
	catch(FileNotFoundException e){}
	findDepth();
    }
	
    public void stomp(int R_s, int C_s, int D_s){
	for(int i = R_s-1; i < R_s+2; i++){
	    for(int j = C_s-1; j < C_s+2; j++){
		lake[i][j]-=D_s;
	    }
	}
    }
	
    public void printLake(){
	String strLake = "";
	for(int i = 0; i < R; i++){
	    for(int j = 0; j < C; j++){
		strLake += lake[i][j]+" ";
	    }
	    strLake+="\n";
	}
	System.out.println(strLake);
    }
	
    public void findDepth(){
	int sumD = 0;
	for(int i = 0; i < R; i++){
	    for(int j = 0; j < C; j++){
		if(E-lake[i][j] > 0)sumD+=(E-lake[i][j]);
	    }
	}
	System.out.println(sumD*72*72);
    }
	
    public static void main(String[]args){
	Bronze test = new Bronze();
	//test.printLake();
	//System.out.println(findDepth() + " 7,Lin,Tao");
    }
	
	
	
    public void debug(String s){
	if(DEBUG){
	    System.out.println(s);
	}
    }
}
