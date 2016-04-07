public class MyDeque<T>{
    private Object[] data;
    private int size, start, end;
    
    public MyDeque(){
	data = new Object[4];
	start = 1;
	end = 1;
    }

    public void addFirst(T value){
	//if(size == data.length()){
	//    grow();
	//	}
	if(start < 0){
	    start = data.length()-1;
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
