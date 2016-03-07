import java.io.*;
import java.util.*;

public class Silver{
    private int[][]pasture;
    public int startR, startC, endR, endC, seconds;

    public Silver(String fileName){
	File fileN = new File(fileName);
	try{
	    Scanner fileS = new Scanner(fileN);

	    //initializing arrays rows and cols
	    int rows = fileS.nextInt();
	    int cols = fileS.nextInt();
	    seconds = fileS.nextInt();
	    pasture = new int[rows][cols];

	    //filling array with values
	    for(int i = 0; i < rows; i++){
		String row = fileS.next();
		for(int j = 0; j < cols; j++){
		    if(row.charAt(j)=='.'){
			pasture[i][j] = 0;
		    }else{
			pasture[i][j] = -1;
		    }
		}
	    }

	    //where to start and end
	    startR = fileS.nextInt()-1;
	    startC = fileS.nextInt()-1;
	    endR = fileS.nextInt()-1;
	    endC = fileS.nextInt()-1;

	    pasture[startR][startC] = 1;
	}catch(FileNotFoundException e){}
    }

    public void solve(){
	//printPasture();
	for (int loops = 0; loops < seconds; loops++){
	    int[][]fillerPasture = new int[pasture.length][pasture[0].length];
	    copyArray(pasture, fillerPasture);
	    //printStuff(fillerPasture);
	    conway(pasture, fillerPasture);
	}
	System.out.println(pasture[endR][endC] + ",7,Lin,Tao");
    }
    
    public void conway(int[][]ary1, int[][]ary2){
	for(int i = 0; i < ary1.length; i++){
	    for(int j = 0; j < ary1[i].length; j++){
		if(ary2[i][j]>=0){
		    conwayH(i,j,ary1,ary2);
		}
	    }
	}
    }

    public void conwayH(int row, int col, int[][]ary1, int[][]ary2){
	int sum = 0;
	if(row+1 < ary1.length    && ary2[row+1][col]>=0)  sum += ary2[row+1][col];
	if(row-1 > 0              && ary2[row-1][col]>=0)  sum += ary2[row-1][col];
	if(col+1 < ary1[0].length && ary2[row][col+1]>=0)  sum += ary2[row][col+1];
	if(col-1 > 0              && ary2[row][col-1]>=0)  sum += ary2[row][col-1];
	
	//printPasture();
	ary1[row][col] = sum;
    }
    
    public void copyArray(int[][]original, int[][]copy){
	//copy = new int[original.length][original[0].length];
	for(int i = 0; i < original.length; i++){
	    for(int j = 0; j < original[i].length; j++){
		copy[i][j] = original[i][j];
	    }
	}
    }
    
    public void printPasture(){
	for(int i = 0; i < pasture.length; i++){
	    String line = "";
	    for(int j = 0; j < pasture[i].length; j++){
		line += pasture[i][j]+ " ";
	    }
	    System.out.println(line);
	}
	System.out.println("");
    }
    public void print(int[][]array1){
	//System.out.println("THIS IS ARY2");
	for(int i = 0; i < array1.length; i++){
	    String line = "";
	    for(int j = 0; j < array1[i].length; j++){
		line += array1[i][j]+ " ";
	    }
	    System.out.println(line);
	}
	System.out.println("");

    }
    
    public static void main(String[]args){
	if(args.length!=0){
	    Silver John = new Silver(args[0]);
	    John.solve();
	}
    }
}
