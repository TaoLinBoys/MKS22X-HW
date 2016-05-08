import java.util.*;
@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>
{
    private int size;
    private T[] data;

    public MyHeap(){
	data = (T[])(new Comparable[10]);
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
	    if(data[childLeft].compareTo(data[childRight]) > 0){
		biggest = childLeft;
	    }else{
		biggest = childRight;
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
	if(data[k].compareTo(data[parent]) > 0){
	    swap(k, parent);
	    pushUp(parent);
	}
    }

    private void heapify(){
	
    }
    
    public T delete(){
	return data[0];
    }

    public void add(T x){
	
    }
    
    private void doubleSize(){

    }
    public String toString(){
	return "";
    }

    //do this last
    public MyHeap(boolean isMax){}
    public MyHeap(T[] array, boolean isMax){}

}
