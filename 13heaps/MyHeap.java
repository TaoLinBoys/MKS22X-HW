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
	data = array;
	heapify();
	size = array.length;
    }

    private void swap(int x, int y){
	int temp = x;
	data[x] = data[y];
	data[y] = data[temp];
    }

    private void pushDown(int k){ //code requires there to be two children
	int childLeft = k*2;      //need to fix that
	int childRight = k*2+1;
	int biggest = 0;
	if(data[childLeft].compareTo(data[childRight]) > 0){
	    biggest = childLeft;
	}else{
	    biggest = childRight;
	}
	if(data[k].compareTo(data[biggest]) < 0){
	    swap(k, biggest);
	}
	pushDown(biggest); //keeps doing this until its in the right place
    }

    private void pushUp(int k){ //this one too
	int parent = k/2;
	if(data[k].compareTo(data[parent]) > 0){
	    swap(k, parent);
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
