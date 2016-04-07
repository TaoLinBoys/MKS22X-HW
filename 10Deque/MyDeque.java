public class MyDeque<T>{
    private T[] data;
    private int size, start, end;
    
    @SuppressWarnings("unchecked") public MyDeque(){
	data = (T[]) new Object[4];
	start = 2;
	end = 2;
	size = 0;
    }

    @SuppressWarnings("unchecked") private void grow(){
	T[] newDeque = (T[]) new Object[data.length*2];
	int newStart = 2;
	if(start < end){
	    for(int i = start; i <= end; i++){
		newDeque[newStart] = data[i];
		newStart++;
	    }
	}else{
	    for(int i = start; i < data.length; i++){
		newDeque[newStart] = data[i];
		newStart++;
	    }
	    for(int j = 0; j <= end; j++){
		newDeque[newStart] = data[j];
		newStart++;
	    }
	}
    }
    
    public void addFirst(T value){
	//if(size == data.length()){
	//    grow();
	//	}
	if(start < 0){
	    start = data.length-1;
	    data[start] = value;
	}
	if(size == 0){
	    data[start] = value;
	}else{
	    start--;
	    data[start] = value;
	}
	size++;
    }
    
    public String toString(){
	String dataS = "[ ";
	for(int i = start; i <= end; i++){
	    dataS += data[i] + " ";
	}
	return dataS+"]";
    }

    public static void main(String[]args){
	MyDeque<Integer> test = new MyDeque<Integer>();
	test.addFirst(3);
	System.out.println(test);
	test.addFirst(21312321);
	System.out.println(test);
    }
}
