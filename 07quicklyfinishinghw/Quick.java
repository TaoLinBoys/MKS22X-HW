import java.lang.*;
public class Quick{
    private static int partition(int[]data, int left, int right){
	int indexR = left + (int)(Math.random()*(right - left + 1));
	swap(data, indexR, left); //bring the random number to the front
	int randNum = data[left];
	System.out.println("random int: " + data[left]); //print the front aka random number

	int startL = left + 1;
	int startR = right;

	while(startL!=startR){
	    if(data[startL] <= randNum){
		startL++;
	    }else{
		swap(data, startL, startR);
		startR--;
	    }
	}
	
	if(data[startL] < randNum){
	    swap(data, startL, left);
	    return startL;
	}else{
	    swap(data, startL - 1, left);
	    return startL - 1;
	}
    }

    
    public static int quickselect(int[]data, int k){
	return quickselect(data, k, 0, data.length - 1);
    }

    private static int quickselect(int[]data, int k, int left, int right){
        int isK = partition(data, left, right);
	if(k == isK)return data[k];

	if(isK < k){
	    return quickselect(data,k,isK+1,right);
	}else{
	    return quickselect(data,k,left,isK-1);
	}
    }



    private static void swap(int[]data, int x, int y){
	int xa = data[x];
	data[x] = data[y];
	data[y] = xa;
    }
    
    public static void printArray(int[]data){
	String ary = "";
	for(int i = 0; i < data.length; i++){
	    ary += data[i] + ", ";
	}
	System.out.println(ary);
    }

    public static void main(String[]args){
	int[]test = {2, 5 ,1, 21, 14, 9};

	System.out.println("======TESTING PARTITION=======");
	printArray(test);
	partition(test,0,test.length-1);
	printArray(test);
	System.out.println("==============================");
	System.out.println("");

	System.out.println("======TESTING QUICKSELECT=======");

	//printArray(test);
	//System.out.println(quickselect(test, 2));
	
	System.out.println("================================");
	System.out.println("");
    }
}
