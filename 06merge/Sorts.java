public class Sorts{
    public static int[] merge(int[]a, int[]b){
	int[]finalInt = new int[a.length + b.length];
	int x = 0;
	int y = 0;
	int z = 0;
		
	while (x < a.length && y < b.length){
	    if (a[x] < b[y]){
		finalInt[z] = a[x];
		z++;
		x++;
	    }else{
		finalInt[z] = b[y];
		z++;
		y++;
	    }				
	}
	return finalInt;
    }
}	
