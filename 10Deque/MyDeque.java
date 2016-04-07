public class MyDeque<T>{
    private T[] data;
    private int size, start, end;
    
    @SuppressWarnings("unchecked") public MyDeque(){
	data = (T[]) new Object[5];
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
	start = 2;
	end = 1 + size;
	data = newDeque;
    }
    
    public void addFirst(T value){
	//System.out.println(start);
	if(size == data.length){
	    grow();
	}else if(size == 0){
	    data[start] = value;
	    size++;
	}else if(start == 0){
	    start = data.length - 1;
	}else{
	    start--;
	}
	data[start] = value;
	size++;
    }

    public void addLast(T value){
	if(size == data.length){
	    grow();
	}else if(size == 0){
	    data[end] = value;
	    size++;
	}else if(end == data.length-1){
	    end = 0;
	}else{
	    end++;
	}
	data[end] = value;
	size++;
    }
    
    public String toString(){
	String dataS = "[ ";
	for(int i = 0; i < data.length; i++){
	    if(data[i] == null){
		dataS += "_ ";
	    }else{
		dataS += data[i] + " ";
	    }
	}
	return dataS+"]"+" start: "+data[start]+" end: "+data[end];
    }

    public static void main(String[]args){
	MyDeque<Integer> test1 = new MyDeque<Integer>();

	//adding to deque a bunch of times to test add and grow
	test1.addFirst(3);
	System.out.println(test1);
	test1.addFirst(5);
	System.out.println(test1);
	test1.addFirst(4);
	System.out.println(test1);
	test1.addFirst(9);
	System.out.println(test1);
	test1.addFirst(30);
	System.out.println(test1);
	test1.addFirst(7);
	System.out.println(test1);

	System.out.println("=======================================");
	MyDeque<Integer> test2 = new MyDeque<Integer>();
	test2.addLast(5);
	System.out.println(test2);
	test2.addLast(21);
	System.out.println(test2);
	test2.addLast(6);
	System.out.println(test2);
	test2.addLast(8);
	System.out.println(test2);
	test2.addLast(13);
	System.out.println(test2);
    }
}
