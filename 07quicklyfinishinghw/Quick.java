import java.lang.*;
public class Quick{

    //PARTITION
    private static int partitionOld(int[]data, int left, int right){
	int indexR = left + (int)(Math.random()*(right - left + 1));
	swap(data, indexR, left); 
	int randNum = data[left];

	int startL = left + 1;
	int startR = right;

	while(startL < startR){
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

    

    //QUICKSELECT
    public static int quickselect(int[]data, int k){
	return quickselect(data, k, 0, data.length - 1);
    }

    private static int quickselect(int[]data, int k, int left, int right){
	if(left == right){
	    return data[left];
	}
	
        int isK = partitionOld(data, left, right);
	if(k == isK)return data[k];

	if(isK < k){
	    return quickselect(data,k,isK+1,right);
	}else{
	    return quickselect(data,k,left,isK-1);
	}
    }

    //QUICKSORT
    public static void quickSortOld(int[]data){
	quickSortOld(data,0,data.length-1);
    }

    private static void quickSortOld(int[]data, int left, int right){
        if(left < right){
	    int split = partitionOld(data, left, right);
	    quickSortOld(data, split + 1, right);
	    quickSortOld(data, left, split - 1);
	}
    }

    //NEW STUFF///////////////////////////////////////////////

    public static int[] partition(int[]data, int left, int right){
	int indexR = left + (int)(Math.random()*(right - left + 1));
	swap(data, indexR, left); 
	int randNum = data[left];

	//System.out.println(randNum);
	
	int startL = left + 1;
	int startR = right;

	while(startL < startR){
	    if(data[startL] <= randNum){
		startL++;
	    }else{
		swap(data, startL, startR);
		startR--;
	    }
	}

	int index2 = startL - 1;
	for(int i = 0; i < startL; i++){
	    if(data[i] == data[startL]){
		swap(data, i, index2);
		index2--;
	    }
	}
	//System.out.println(data[index2+1]);

	int[]indexes = {index2, startL};
	
	if(data[startL] < randNum){
	    swap(data, startL, left);
	    return indexes;
	}else{
	    swap(data, startL - 1, left);
	    return indexes;
	}
    }


    public static void quickSort(int[]data){
	quickSort(data,0,data.length-1);
    }

    private static void quickSort(int[]data, int left, int right){
        if(left < right){
	    int[] split = partition(data, left, right);
	    //printArray(data);
	    quickSort(data, left, split[0]-1);
	    quickSort(data, split[1]+1, right);
	}
    }


    //HELPERS, ETC
    public static String name(){
	return "7,Lin,Tao";
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

    public static int[] create(){
	int size = (int)(Math.random()*10) + 1;
	int[] data = new int[10];
	for(int i = 0; i < data.length; i++){
	    int rand = (int)(Math.random()*3);
	    data[i] = rand;
	}
	return data;
    }

    public static void main(String[]args){
	int[]test = create();
	int[]test2 = create();
	int[]test3 = create();
	int[]test4 = create();

	System.out.println("======TESTING PARTITION=======");
	printArray(test);
	partition(test,0,test.length-1);
	printArray(test);
	System.out.println("");

	
	System.out.println("======TESTING QUICKSORTOLD======");	
	printArray(test3);
	quickSortOld(test3);
	printArray(test3);
	System.out.println("");

	System.out.println("======TESTING QUICKSORT======");	
	printArray(test4);
	quickSort(test4);
	printArray(test4);
	System.out.println("");
    }
}
