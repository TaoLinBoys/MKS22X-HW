import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>
{
    private int size;
    private T[] data;
    public boolean ISMAX = true;

    public MyHeap(){
	data = (T[])(new Comparable[15]);
	size = 0;
    }
    public MyHeap(T[] array){
	size = array.length;
	data = (T[])(new Comparable[size + 1]);
	for(int i = 0; i < size; i++){
	    data[i+1] = array[i];
	}
	heapify();
    }

    public MyHeap(boolean isMax){
	this();
	ISMAX = isMax;
    }
    public MyHeap(T[] array, boolean isMax){
	this(array);
        ISMAX = isMax;
    }

    private void swap(int x, int y){
	T temp = data[x];
	data[x] = data[y];
	data[y] = temp;
    }

    private void pushDown(int k){
	int childLeft = k*2;      
	int childRight = k*2+1;
	int biggest = 0;

	//gotta find the biggest child
	if(childLeft > data.length && childRight > data.length){
	    //do nothing    
	}else if(childLeft < data.length && childRight > data.length){
	    biggest = childLeft;
	}else if(childLeft > data.length && childRight < data.length){
	    biggest = childRight;
	}else{

	    if(ISMAX){
		if(data[childLeft].compareTo(data[childRight]) > 0){
		    biggest = childLeft;
		}else{
		    biggest = childRight;
		}
	    }else{
		if(data[childLeft].compareTo(data[childRight]) < 0){
		    biggest = childLeft;
		}else{
		    biggest = childRight;
		}
	    }
	}

	//swapping the things
	if(biggest != 0){
	    swap(biggest, k);
	    pushDown(biggest);
	}
    }

    private void pushUp(int k){
	int parent = k/2;
	if(ISMAX && parent != 0){
	    if(data[k].compareTo(data[parent]) > 0){
		swap(k, parent);
		pushUp(parent);
	    }
	}else if(!ISMAX && parent!= 0){
	    if(data[k].compareTo(data[parent]) < 0){
		swap(k, parent);
		pushUp(parent);
	    }
	}
    }

    private void heapify(){
	for(int i = size/2; i > 0; i--){
	    pushDown(i);
	}
    }
    
    public T delete(){
	if(size == 0)throw new NoSuchElementException();
	
	T first = data[1];
        data[1] = data[size--];
	pushDown(1);
	return first;
    }

    public T peek(){
	if(size == 0)throw new NoSuchElementException();
	return data[1];
    }

    public void add(T x){
	if(size + 1 == data.length)doubleSize();
	data[size + 1] = x;
	size++;
	pushUp(size);
    }
    
    private void doubleSize(){
	T[] doubled = (T[])(new Comparable[size*2]);
	for(int i = 1; i < data.length; i++){
	    doubled[i] = data[i];
	}
	data = doubled;
    }
    
    public String toString(){
	String array = "[ ";
	for(int i = 1; i < size; i++){
	    array += data[i] + ", ";
	}
	array += data[size] + " ]";
	return array;
    }
}
