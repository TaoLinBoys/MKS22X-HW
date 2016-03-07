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
	int[]ans=new int[first.length+second.length];
	int indexA=0;
	int indexB=0;
	int i;
	
	for (i=0; i<ans.length && indexA<a.length && indexA<b.length; i++){
	    if (first[firstIndex]>second[secondIndex]){
		ans[i] = b[indexB];
		indexB++;
	    }else{
		ans[i] = a[indexA];
		indexA++;
	    }
	}

	int[]remainders;
	int remains;
	if (firstIndex==first.length){
	    remainders=second;
	    remains=secondIndex;
	}else{
	    remainders=first;
	    remains=firstIndex;
	}
	
	for (int k=remains;k<remainders.length;k++){
	    ans[i]=remainders[k];
	    i++;
	}
	return ans;
    }

    public static void mergeSort (int[]data){
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
    


    public static void main(String[]args){
	int[]ary={8,7,1,4};
	int[]ary2={324,5,345,234,-1};
	mergeSort(ary);
	printArray(ary);
	mergeSort(ary2);
	printArray(ary2);
    }
}	
