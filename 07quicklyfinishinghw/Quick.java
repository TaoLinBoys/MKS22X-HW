import java.lang.*;
public class Quick{
    private static int partition(int[]data, int left, int right){
	int indexR = left + (int)(Math.random()*(right - left + 1));
	int leftI = data[left];   //what data at left is right now
	int randNum = data[indexR]; //what data is at random index
	data[left]=randNum;    //switching the random integer
	data[indexR]=leftI;    //with the leftmost one

	System.out.println(randNum);
	
	int[]newData = new int[data.length]; //creating new list to hold
	                                     //the partitioned elements

	int leftD = 0;  //index to indicate where to place randNum
	int rightD = data.length-1;
	
	for(int i = 0; i < data.length; i++){
	    if(data[i] < randNum){
		newData[leftD] = data[i];
		leftD++;
	    }
	    if(data[i] > randNum){
		newData[rightD] = data[i];
		rightD--;
	    }
	}

	newData[rightD] = randNum;

	for(int i = 0; i < data.length; i++){
	    data[i] = newData[i];
	}

	return rightD;
	
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

	printArray(test);
	System.out.println(quickselect(test, 2));
	
	System.out.println("================================");
	System.out.println("");
    }
}
