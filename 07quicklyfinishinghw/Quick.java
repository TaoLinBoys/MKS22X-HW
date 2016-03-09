import java.lang.*;
public class Quick{
    private static int partition(int[]data, int left, int right){
	int indexR = left + (int)(Math.random()*(right - left + 1));
	int leftI = data[left];   //what data at left is right now
	int randNum = data[indexR]; //what data is at random index
	data[left]=randNum;    //switching the random integer
	data[indexR]=leftI;    //with the leftmost one

	
	System.out.println("RANDOMLY SELECTED INTEGER: " + randNum);

	
	int ctrL = left+1; //counter to start from left side
	                   //+1 cuz of switching with random variable
	int ctrR = right;  //counter from right side

	//if it's the lowest num, just leave it
	if(randNum == lowestNum(data))return left;

	
	//if not, partition
	while(ctrL != ctrR){
	    if(data[ctrL] <= randNum){//if its less than the random int
		ctrL++;               //leave it
	    }else{              //else, switch the left most and right most
		int a = data[ctrL];
		int b = data[ctrR];
		
		data[ctrL] = b;
		data[ctrR] = a;
		//ctrL++;
		ctrR--;
	    }
	}

	
	//loop ended so ctrL and ctrR are equal and
	//the randomint that was at the left most side will
	//replace the int at ctrL if randNum > data[ctrL]
	//if randNum < data[ctrL], then replace it with data[ctrL+1]
	if(randNum > data[ctrL]){
	    int leftside = data[ctrL];
	    data[ctrL] = randNum;
	    data[left] = leftside;
	    return ctrL;
	}else{
	    int leftside = data[ctrL - 1];
	    data[ctrL] = randNum;
	    data[left] = leftside;
	    return ctrL - 1;
	}
    }

    private static int lowestNum(int[]data){
	int num = data[0];
	for(int i = 1; i < data.length; i++){
	    if(data[i] < num)num = data[i];
	}
	return num;
    }


    
    public static int quickselect(int[]data, int k){return 2;}




    
    public static void printArray(int[]data){
	String ary = "";
	for(int i = 0; i < data.length; i++){
	    ary += data[i] + ", ";
	}
	System.out.println(ary);
    }

    public static void main(String[]args){
	int[]test = {2, 5 ,1, 21, 14, 9};
	printArray(test);
	partition(test,0,test.length-1);
	printArray(test);
    }
}
