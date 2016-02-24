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
		}
		catch(FileNotFoundException e){}
	}
	
	public void stomp(int R_s, int C_s, int D_s){
		for(int i = R_s-1; i < R_s+2; i++){
			for(int j = C_s-1; j < C_s+2; j++){
				
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
	
	public int findDepth(){
		int sumD = 0;
		for(int i = 0; i < R; i++){
			for(int j = 0; j < C; j++){
				if(E-lake[i][j] > 0)sumD+=(E-lake[i][j]);
			}
		}
		return sumD*72*72;
	}
	
	public static void main(String[]args){
		Bronze test = new Bronze();
		test.printLake();
		System.out.println(test.findDepth() + " 7,Lin,Tao");
	}
	
	
	
	public void debug(String s){
		if(DEBUG){
			System.out.println(s);
		}
	}
}