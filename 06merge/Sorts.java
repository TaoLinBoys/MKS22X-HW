import java.util.*;

public class Sorts{
    public static void printArray (int[]data){
	System.out.print("{");
	for (int i = 0;i<data.length;i++){
	    if (i+1==data.length){
		System.out.print(data[i]);
	    }
	    else{
		System.out.print(data[i]+",");
	    }
	}
	System.out.print("}\n");
    }

    public static int[] merge (int[]a, int[]b){
	int[]ans=new int[a.length+b.length];
	int indexA=0;
	int indexB=0;
	int i;
	
	for(i=0; i<ans.length && indexA<a.length && indexB<b.length; i++){
	    if (a[indexA]>b[indexB]){
		ans[i] = b[indexB];
		indexB++;
	    }else{
		ans[i] = a[indexA];
		indexA++;
	    }
	}

	int[]remainders;
	int remains;
	if (indexA==a.length){
	    remainders=b;
	    remains=indexB;
	}else{
	    remainders=a;
	    remains=indexA;
	}
	
	for (int j = remains; j < remainders.length; j++){
	    ans[i]=remainders[j];
	    i++;
	}
	return ans;
    }

    public static void mergesort (int[]data){
	int[]ans = helper(data);
	for (int i=0;i<data.length;i++){
	    data[i]=ans[i];
	}
    }


    public static int[] helper (int[]data){
	if (data.length==1){return data;}
	int end=data.length/2;
	int start=end;
	int[]firstHalf=Arrays.copyOfRange(data,0,end);
	int[]secondHalf=Arrays.copyOfRange(data,start,data.length);
        int[]ans=merge(helper(firstHalf),helper(secondHalf));
	return ans;
    }

    public static String name(){
	return "7,Lin,Tao";
    }


    public static void main(String[]args){
	int[]ary={36, 82, 1, 10, 20102030};
	int[]ary2={40, 5, 7, 12, 101};
	mergesort(ary);
	printArray(ary);
	mergesort(ary2);
	printArray(ary2);
    }
}	
