import java.util.*;
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
	
	//System.out.println();
	//System.out.println(toString());
	//System.out.println();
    }
    
    public void addFirst(T value){
	//System.out.println(size);
	if(size == data.length){
	    grow();
	}
	if(size == 0){
	    start++;
	}
	if(start == 0){
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
	}
	if(size == 0){
	    end--;
	}
	if(end == data.length-1){
	    end = 0;
	}else{
	    end++;
	}
	data[end] = value;
	size++;
    }

    public T removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	T removedVal = data[start];
	data[start] = null;
	if(start == data.length-1){
	    start = 0;
	}else{
	    start++;
	}
	return removedVal;
    }

    public T removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	T removedVal = data[end];
	data[end] = null;
	if(end == 0){
	    end = data.length-1;
	}else{
	    end--;
	}
	return removedVal;
    }

    public T getFirst(){
        if(size == 0){
	    throw new NoSuchElementException();
	}
	return data[start];
    }

    public T getLast(){
        if(size == 0){
	    throw new NoSuchElementException();
	}
	return data[end];
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
	return dataS+"]"+" start: "+getFirst()+" end: "+getLast();
    }

    public static void main(String[]args){
	MyDeque<Integer> test1 = new MyDeque<Integer>();
        /*for(int i = 0; i < 20; i++){
	    test1.addFirst(i);
	    System.out.println(test1);
	    }
	*/

	System.out.println("=======================================");
	MyDeque<Integer> test2 = new MyDeque<Integer>();
        /*for(int i = 0; i < 15; i++){
	    test2.addLast(i);
	    System.out.println(test2);
	    }
	*/
	
	System.out.println("=======================================");
	MyDeque<Integer> test3 = new MyDeque<Integer>();
	/*for(int i = 0; i < 15; i++){
	    test3.addFirst(i);
	}
	System.out.println(test3);
	for(int j = 0; j < 15; j++){
	    System.out.println(test3.removeFirst());
	    System.out.println(test3);
	}
        */

	System.out.println("=======================================");
	MyDeque<Integer> test4 = new MyDeque<Integer>();
	for(int i = 0; i < 15; i++){
	    test4.addFirst(i);
	}
	System.out.println(test4);
	for(int j = 0; j < 15; j++){
	    System.out.println(test4.removeLast());
	    System.out.println(test4);
	}
	
    }
}
