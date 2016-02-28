import java.util.*;
import java.io.*;

public class Bronze{
    private static boolean DEBUG = true;
    private int[][]lake;
    private int R,C,E,N;
	
    public Bronze(File file){
	try{
	    Scanner s = new Scanner(file);
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
	

    private int max3by3(int R_s, int C_s){
	int max = 0;
	for(int i = R_s-1; i < R_s+2; i++){
	    for(int j = C_s-1; j < C_s+2; j++){
		if(lake[i][j] > max)max=lake[i][j];
	    }
	}
	return max;
    }

    public void stomp(int R_s, int C_s, int D_s){
	int max = max3by3(R_s,C_s)-D_s;
	for(int i = R_s-1; i < R_s+2; i++){
	    for(int j = C_s-1; j < C_s+2; j++){
		if(lake[i][j] > max)lake[i][j]=max;
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
	System.out.println(sumD*72*72 + ",7,Lin,Tao");
    }
	
    public static void main(String[]args){
	if(args.length!=0){
	    File f = new File(args[0]);
	    Bronze test = new Bronze(f);
	    //test.printLake();
	}
    }
	
	
	
    public void debug(String s){
	if(DEBUG){
	    System.out.println(s);
	}
    }
    public void debug(int s){
	if(DEBUG){
	    System.out.println(s);
	}
    }
}
